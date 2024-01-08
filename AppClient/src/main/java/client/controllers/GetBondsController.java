package client.controllers;
import client.Main;
import client.api.Api;
import client.models.Bond;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;


public class GetBondsController {

    private List<Bond> bondsData;
    private ObservableList<Bond> bondTable = FXCollections.observableArrayList();

    protected Api api = new Api();

    private Label welcomeText;

    @FXML
    private TableView<Bond> Bonds;
    @FXML
    TextField bondNameField;
    @FXML
    TextField bondIdField;
    @FXML
    private TableColumn<Bond, Integer> bondId;;
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
     * Нажатие на добавления
     * отправка данных GET запросом на сервер
     */
    private void initData() {
    }

    @FXML
    private void initialize() {
        initData();
        // устанавливаем тип и значение которое должно хранится в колонке
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
    public List<Bond> handleGetBonds() {
        List<Bond> getAllBondsResult = api.getAllBonds();
        System.out.println(getAllBondsResult);
//        usersData = getAllBondsResult;
        Bonds.setItems(bondTable);

        return getAllBondsResult;
    }
}

