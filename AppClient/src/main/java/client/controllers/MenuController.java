package client.controllers;

import client.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuController extends Main {

<<<<<<< HEAD
    public Stage stage;
    public Scene scene;
    public Parent root;

    @FXML
    public void switchToAddBondPage(ActionEvent event) throws IOException {
=======
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void switchToAddBondPage(ActionEvent event) throws IOException {
>>>>>>> 726a48c (add gui for get all bonds)
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = Main.class.getResource("fxml/addBond.fxml");
        loader.setLocation(xmlUrl);
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
<<<<<<< HEAD
    public void switchToGetAllBondsPage(ActionEvent event) throws IOException {
=======
    private void switchToGetAllBondsPage(ActionEvent event) throws IOException {
>>>>>>> 726a48c (add gui for get all bonds)
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = Main.class.getResource("fxml/getAllBonds.fxml");
        loader.setLocation(xmlUrl);
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
<<<<<<< HEAD
    public void switchToGetPortfolioBondsPage(ActionEvent event) throws IOException {
=======
    private void switchToGetPortfolioBondsPage(ActionEvent event) throws IOException {
>>>>>>> 726a48c (add gui for get all bonds)
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = Main.class.getResource("fxml/getPortfolioBonds.fxml");
        loader.setLocation(xmlUrl);
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
<<<<<<< HEAD
    public void switchToDeleteBondPage(ActionEvent event) throws IOException {
=======
    private void switchToDeleteBondPage(ActionEvent event) throws IOException {
>>>>>>> 726a48c (add gui for get all bonds)
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = Main.class.getResource("fxml/deleteBond.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
<<<<<<< HEAD
    public void switchToEditBondPage(ActionEvent event) throws IOException {
=======
    private void switchToEditBondPage(ActionEvent event) throws IOException {
>>>>>>> 726a48c (add gui for get all bonds)
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = Main.class.getResource("fxml/editBond.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
<<<<<<< HEAD
    public void switchToCalculatePortfolioDurationPage(ActionEvent event) throws IOException {
=======
    private void switchToCalculatePortfolioDurationPage(ActionEvent event) throws IOException {
>>>>>>> 726a48c (add gui for get all bonds)
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = Main.class.getResource("fxml/calculatePortfolioDuration.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
<<<<<<< HEAD
    public void switchToMenuPage(ActionEvent event) throws IOException {
=======
    private void switchToMenuPage(ActionEvent event) throws IOException {
>>>>>>> 726a48c (add gui for get all bonds)
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = Main.class.getResource("fxml/menu.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
