package PO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import other.AdviceFeedBackState;

@Entity
@Table(name="AdviceFeedBackPO")
public class AdviceFeedBackPO {
       private AdviceFeedBackState state;
       private String AdviceFeedBack_content;
       private String AdviceId;
       private String userId;
       
       public AdviceFeedBackPO(){}
       
       public AdviceFeedBackPO(AdviceFeedBackState state1,String adviceFeedBack_content,String userid){
    	   super();
    	   this.AdviceFeedBack_content = adviceFeedBack_content;
    	   this.state = state1;
    	   this.userId = userid;
       }


	public String getAdviceFeedBack_content() {
		return AdviceFeedBack_content;
	}

	public void setAdviceFeedBack_content(String adviceFeedBack_content) {
		AdviceFeedBack_content = adviceFeedBack_content;
	}
    @Id
	public String getAdviceId() {
		return AdviceId;
	}

	public void setAdviceId(String adviceId) {
		AdviceId = adviceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public AdviceFeedBackState getState() {
		return state;
	}

	public void setState(AdviceFeedBackState state) {
		this.state = state;
	}
       

}
