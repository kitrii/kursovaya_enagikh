package client.controllers;

import client.Main;
import client.api.Api;
import client.models.Bond;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.util.List;


public class BondController {
    private Main main;
    private Stage stage;
    protected Api api;
    private final ObservableList<Bond> bondsData = FXCollections.observableArrayList();

    @FXML
    private TableView<Bond> bondTableView;
    @FXML
    private TableColumn<Bond, String> bondNameColumn;
    @FXML
    private TableColumn<Bond, Integer> maturityColumn;
    @FXML
    private TableColumn<Bond, Integer> nominalColumn;
    @FXML
    private TableColumn<Bond, Integer> couponSizeColumn;
    @FXML
    private TableColumn<Bond, Integer> numberOfCouponPeriodsColumn;
    @FXML
    private TableColumn<Bond, Integer> bondDurationColumn;
    @FXML
    private TextField searchCompany;

    @FXML
    private CheckBox sortBondBtn;

    /**
     * Инициализируем данные
     * <p>
     * Добавляем записи в таблицу bondTableView
     */
    @FXML
    public void initialize() {
        // заполняем таблицу данными
        bondTableView.setItems(bondsData);

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    //    TODO: запрос по url /bonds/like или /bonds/all если пустая строка
//    @FXML
//    public void handlerBondsBtn() {
//        // обнуление таблицы
//        if (Validation.checkLength(searchCompany.getText(), 40)) {
//
//            bondTableView.getItems().clear();
//            boolean filter = false;
//            filter = sortBondBtn.isSelected();
//            List<Bond> result;
//            if (Validation.isNameBlank(searchCompany.getText())) {
//                // Получаем все авиакомпании
//                result = api.getAllBonds(filter);
//            } else {
//                // Получаем все авиакомпании по вхождению подстроки
//                result = api.getBondsBySubBondName(searchCompany.getText(), filter);
//            }
//            bondsData.addAll(result);
//        } else {
//            Alerts.showNoValidLength(stage, "поиск", 40);
//        }
//    }

//    @FXML
//    private void handleDeleteBond() {
//        boolean result = api.(searchCompany.getText());
//                if (result) {
//                    main.showBondInfoPage();
//            }
//        }


//    @FXML
//    public void handleAddBond(){
//        main.showAddBondPage();
//    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setApi(Api api) {
        this.api = api;
    }
}
