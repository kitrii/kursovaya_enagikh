package client.controllers;

import client.api.Api;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatePorfolioDurationController extends MenuController{
    protected Api api = new Api();

    @FXML
    TextField ownerIdField;

    @FXML
    TextField portfolioDuration;
    @FXML
<<<<<<< HEAD
    public void handleCalculateDuration(){
=======
    private void handleCalculateDuration(){
>>>>>>> 726a48c (add gui for get all bonds)
        String result = api.calculatePortfolio(ownerIdField.getText());
        portfolioDuration.setText(result);
    }
}
