package Test;
import VO.AdviceFeedBackVO;
import blservice.AdviceFeedBack_blservice;
import blservice.impl.AdviceFeedBack_bl;
import main.ClientRunner;
import other.AdviceFeedBackState;
import util.DateUtil;

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
//	   String id = "151250170";
//	   System.out.println(RemoteHelper.getInstance().getLoginDataService().findByID("151250170").getUserType());
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
	   /*
	    * ����ע��
	    */
//	   Register_blservice register_blservice = new Register_bl();
//	   String date  = "2015-02-12";
//	   LocalDate localDate = DateUtil.parse_1(date);
//	   CustomerVO c = new CustomerVO("151250549","л����",3,localDate,"���˾",50);
//	   System.out.println(register_blservice.addRegister(c));
	   /*
	    * ������ӷ���
	    */
	   String send = "2013-10-12";
	   String rep = "2015-10-12";
	   AdviceFeedBack_blservice adviceFeedBack_blservice = new AdviceFeedBack_bl();
	   AdviceFeedBackVO adviceFeedBackVO = new AdviceFeedBackVO("151250170",AdviceFeedBackState.PROCESSED,"��վ���ױ���",
			   "123456",DateUtil.parse_1(send),DateUtil.parse_1(rep),"֪����");
       System.out.println(adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO));
       /*
        * 
        */
   }
}
