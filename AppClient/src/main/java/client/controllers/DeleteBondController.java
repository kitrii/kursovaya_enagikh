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


<<<<<<< HEAD
    public void initialize(){
=======
    private void initialize(){
>>>>>>> 726a48c (add gui for get all bonds)
        bondIdField.setText(null);
        ownerIdField.setText(null);
    }

    @FXML
<<<<<<< HEAD
    public void handleDeleteBond() {
=======
    private void handleDeleteBond() {
>>>>>>> 726a48c (add gui for get all bonds)
        api.deleteBond(bondIdField.getText(), ownerIdField.getText());
    }
}
