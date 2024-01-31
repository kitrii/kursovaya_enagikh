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
    private void initialize() {
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
    private void handleEditBond(){
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
