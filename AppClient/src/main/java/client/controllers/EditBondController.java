package client.controllers;

import client.api.Api;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditBondController extends MenuController{

    protected Api api = new Api();
    @FXML
    TextField bondNameField =  new TextField("");
    @FXML
    TextField bondIdField;
    @FXML
    TextField nominalcostField;
    @FXML
    TextField couponfrequencyField;
    @FXML
    TextField repaymentPeriodField;
    @FXML
    TextField couponRateField;
    @FXML
    TextField yieldToMaturityField;
    @FXML
    TextField ownerIdField;
    @FXML
    TextField ownerNameField = new TextField("");
    @FXML
<<<<<<< HEAD
    public void initialize() {
=======
    private void initialize() {
>>>>>>> 726a48c (add gui for get all bonds)
        bondNameField.setText(null);
        bondIdField.setText(null);
        nominalcostField.setText(null);
        couponRateField.setText(null);
        couponfrequencyField.setText(null);
        repaymentPeriodField.setText(null);
        yieldToMaturityField.setText(null);
        ownerIdField.setText(null);
        ownerNameField.setText(null);
    }
    @FXML
<<<<<<< HEAD
    public void handleEditBond(){
=======
    private void handleEditBond(){
>>>>>>> 726a48c (add gui for get all bonds)
        api.editBond(
                bondIdField.getText(),
                bondNameField.getText(),
                ownerIdField.getText(),
                ownerNameField.getText(),
                nominalcostField.getText(),
                couponRateField.getText(),
                repaymentPeriodField.getText(),
                couponfrequencyField.getText(),
                yieldToMaturityField.getText());

    }
}
