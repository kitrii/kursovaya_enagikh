package client.controllers;
import client.Main;
import client.api.Api;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddBondController {
    private Label welcomeText;
    protected Stage AddBondStage;
    protected Main main;
    protected Api api;
    @FXML
    TextField bondNameField;
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
    TextField ownerNameField;


    /**
     * Инициализация полей
     */
    @FXML
    public void initialize() {
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
    /**
     * Закрытие сцены регистрации
     */
    @FXML
    private void handleCancel(){AddBondStage.close();}

    /**
     * @param AddBondStage - установка сцены регистрации
     */
    public void setAddBondStage(Stage AddBondStage){this.AddBondStage = AddBondStage;}

    public void setMain(Main main) {
        this.main = main;
    }

    public void setApi(Api api) {
        this.api = api;
    }



    /**
     * Нажатие на добавления
     * отправка данных POST запросом на сервер
     */
    @FXML
    public void handleAddBond() {
        boolean addBondResult = api.addBond(
                bondIdField.getText(),
                bondNameField.getText(),
                nominalcostField.getText(),
                couponRateField.getText(),
                repaymentPeriodField.getText(),
                couponfrequencyField.getText(),
                yieldToMaturityField.getText(),
                ownerIdField.getText(),
                ownerNameField.getText());

        if (addBondResult) {
            AddBondStage.close();
        }
    }
}

