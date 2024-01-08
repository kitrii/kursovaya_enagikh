package client;

import client.api.Api;
import client.controllers.AddBondController;
import client.controllers.BondController;
import client.controllers.GetBondsController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Класс Main запускает приложение
 */
public class Main extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    private BorderPane mainLayout;


    private Api api;


    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Сourse work");

        Button buttonGetAllBonds = new Button("Получить информацию по всем облигациям");
        Button buttonAddBond = new Button("Добавить информацию по облигации");
        buttonAddBond.setOnAction(e -> {
            try {
                this.hello();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        buttonGetAllBonds.setOnAction(e -> {
            try {
                this.showAddBondPage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        VBox root = new VBox();
        Scene scene = new Scene(root, 500, 300);
        root.getChildren().add(buttonAddBond);
        root.getChildren().add(buttonGetAllBonds);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch();
    }

    public Main() {
        api = new Api();
    }

    public void showAddBondPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/table.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Bonds List");
        primaryStage.setScene(scene);
        primaryStage.show();//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("/fxml/table.fxml"));
//            AnchorPane registrationPage = loader.load();
//            Stage stage = new Stage();
//            stage.initModality(Modality.WINDOW_MODAL);
//            stage.initOwner(primaryStage);
//            stage.setResizable(false);
//
//            Scene scene = new Scene(registrationPage);
//            stage.setScene(scene);
//
//            AddBondController controller = loader.getController();
//            controller.setAddBondStage(stage);
//            controller.setApi(api);
//            controller.setMain(this);
//            stage.showAndWait();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void showBondInfoPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/bondsPage.fxml"));
            BorderPane bondInfoPage = loader.load();

            mainLayout.setCenter(bondInfoPage);

            BondController controller = loader.getController();
            controller.setMain(this);
            controller.setStage(primaryStage);
            controller.setApi(api);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initRootLayout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/addBond.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            primaryStage.setScene(scene);
//            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void hello() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Окно информации об облигациях
     */

}

