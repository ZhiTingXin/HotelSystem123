package other;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

public class hibernateUtil {
    private static SessionFactory sf;
    
    static {
    	 StandardServiceRegistry  serviceRegistry=new StandardServiceRegistryBuilder().configure().build();   
	     sf=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory(); 
	}
    
    public static Session getSession(){
    	return sf.openSession();
    }
    
    public static void add(Object entity) {
		Session session = null;
		Transaction tx = null;
		try {
			session = hibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void delete(Object entity) {
		Session session = null;
		Transaction tx = null;
		try {
			session = hibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void update(Object entity) {
		Session session = null;
		Transaction tx = null;
		try {
			session = hibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static Object findById(Class clazz, Serializable id) {
		Session session = null;
		try {
			session = hibernateUtil.getSession();
			Object ob = session.get(clazz, id);
			return ob;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public static List findbySome(String tablename,String some,Serializable realId){
		Session session = null;
		List list =null;
		try{
			session = hibernateUtil.getSession();
			Query que = session.createQuery("from "+tablename+" where "+some+" =:"+some);
			que.setParameter(some, realId);
			list = que.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	public static List getAll(String tableName,Class clazz){
		Session session = null;
		List list = null;
		try {
			session = hibernateUtil.getSession();
			NativeQuery query = session.createNativeQuery("select * from "+tableName,clazz);
			list  =  query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
	}

}
