package Test;
import RMI.RemoteHelper;
import main.ClientRunner;

public class gernerateID {
   public static void main(String [] args)throws Exception{
	   /*
	    * ע��Ĳ��Դ���
	    */
	   ClientRunner clientRunner = new ClientRunner();
//	   Login_blservice login_blservice = new Login_bl();
	   /*
	    * �����޸�����
	    */
	   //LoginPO login = new LoginPO("abcdskd", "mdaada");
	   String id = "151250170";
	   System.out.println(RemoteHelper.getInstance().getLoginDataService().findByID("151250170").getUserType());
	   /*
	    * ����ע���û�
	    */
	   /*
	    * �û��ĵ�¼����
	    */
//	   LoginPO login = new LoginPO("abcdskd", "mdaada");
//	   System.out.println(login_blservice.comfirm("123456", "yxb19951119"));
	   /*
	    * �����������û�����
	    */
//	   LoginDataService asd= RemoteHelper.getInstance().getLoginDataService();
//	   System.out.println(asd.test());
   }
}
