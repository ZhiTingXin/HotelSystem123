package data.dao.impl;

import java.util.ArrayList;

import PO.SuperVipPO;
import data.dao.SuperVipDao;
import other.hibernateUtil;

public class SupVipDaoImpl implements SuperVipDao {

	public boolean addSupVip(SuperVipPO po) {
		try {
			hibernateUtil.add(po);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifySupVip(SuperVipPO po) {
		try {
			hibernateUtil.update(po);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		    return false;
		}
	}

	public ArrayList<SuperVipPO> getStrict(String disstrict) {
		try {
			ArrayList<SuperVipPO> arrayList = new ArrayList<SuperVipPO>();
			ArrayList<SuperVipPO> superVipPOs = (ArrayList<SuperVipPO>)hibernateUtil.getAll("supervip", SuperVipPO.class);
			for(SuperVipPO po:superVipPOs){
				if(po.getDistrict().equals(disstrict)){
					arrayList.add(po);
				}
			}
			return arrayList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
