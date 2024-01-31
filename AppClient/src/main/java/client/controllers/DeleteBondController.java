package client.controllers;

import client.api.Api;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DeleteBondController extends MenuController{

    protected Api api = new Api();

    @FXML
    TextField ownerIdField;

    @FXML
    TextField bondIdField;


    private void initialize(){
        bondIdField.setText(null);
        ownerIdField.setText(null);
    }

    @FXML
    private void handleDeleteBond() {
        api.deleteBond(bondIdField.getText(), ownerIdField.getText());
    }
}
