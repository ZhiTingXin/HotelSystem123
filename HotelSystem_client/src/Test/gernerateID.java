package Test;
import RMI.RemoteHelper;
import main.ClientRunner;

public class gernerateID {
   public static void main(String [] args)throws Exception{
	   /*
	    * 注册的测试代码
	    */
	   ClientRunner clientRunner = new ClientRunner();
//	   Login_blservice login_blservice = new Login_bl();
	   /*
	    * 测试修改密码
	    */
	   //LoginPO login = new LoginPO("abcdskd", "mdaada");
	   String id = "151250170";
	   System.out.println(RemoteHelper.getInstance().getLoginDataService().findByID("151250170").getUserType());
	   /*
	    * 测试注销用户
	    */
	   /*
	    * 用户的登录测试
	    */
//	   LoginPO login = new LoginPO("abcdskd", "mdaada");
//	   System.out.println(login_blservice.comfirm("123456", "yxb19951119"));
	   /*
	    * 测试所属的用户类型
	    */
//	   LoginDataService asd= RemoteHelper.getInstance().getLoginDataService();
//	   System.out.println(asd.test());
   }
}
