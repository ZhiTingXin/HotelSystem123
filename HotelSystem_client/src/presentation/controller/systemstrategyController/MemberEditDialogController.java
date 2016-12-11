package presentation.controller.systemstrategyController;

import VO.VipVO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MemberEditDialogController {

    @FXML
    private TextField minCredit;
    @FXML
    private TextField maxCredit;
    @FXML
    private Label memberGrade;
    @FXML
    private TextField discount;
    @FXML
    private Button save;
    @FXML
    private Button cancel;

    private Stage dialogStage;
    private VipVO vipVO;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setVipVO(VipVO vipVO) {
        this.vipVO = vipVO;

        minCredit.setText(String.valueOf(vipVO.getMincredit()));
        maxCredit.setText(String.valueOf(vipVO.getMaxcredit()));
        memberGrade.setText(String.valueOf(vipVO.getVipgrade()));
        discount.setText(String.valueOf(vipVO.getDiscount()));
        
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            vipVO.setMincredit(Integer.parseInt(minCredit.getText()));
            vipVO.setMaxcredit(Integer.parseInt(maxCredit.getText()));
            vipVO.setVipgrade(Integer.parseInt(memberGrade.getText()));
            vipVO.setDiscount(Double.parseDouble(discount.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (minCredit.getText() == null || minCredit.getText().length() == 0||Integer.parseInt(minCredit.getText())<0) {
            errorMessage += "�������������ó�ʼֵ��\n"; 
        }else {
            
            try {
                Integer.parseInt(minCredit.getText());
            } catch (NumberFormatException e) {
                errorMessage += "���ó�ʼֵ������һ��������\n"; 
            }
        }

        if (maxCredit.getText() == null || maxCredit.getText().length() == 0) {
            errorMessage += "�����������������ֵ��\n"; 
        }else {
           
            try {
                Integer.parseInt(maxCredit.getText());
            } catch (NumberFormatException e) {
                errorMessage += "�������ֵ������һ��������\n"; 
            }
        }
        
        if (Integer.parseInt(maxCredit.getText())<=Integer.parseInt(minCredit.getText())) {
            errorMessage += "�������ֵ����������ó�ʼֵ��\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
        	Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("����");
			alert.setHeaderText("�����ǲ��ǳ�ʲô�������أ�");
			alert.setContentText(errorMessage);
			alert.showAndWait();
            return false;
        }
    }
}