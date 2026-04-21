    package com.example.sanmarino;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

    public class FormController implements Initializable {
        @FXML
        private TextField getTransactionID;
        int TransID;

        @FXML
        private TextField getFormmID;
        int FormID;


        //PayAmount

        @FXML
        private TextField transactAmountField;

        Double Amount;


        //datePicker
        @FXML
        private DatePicker getTransactionFormDPicker;


        public void getDate(ActionEvent event) {

        }


//Paymentmodes


        @FXML
        private ChoiceBox<Integer> payChoiceBox;

        private Integer[] paymentModes = {1,2,3};

        @Override
        public void initialize(URL location, ResourceBundle resources) {

            payChoiceBox.getItems().addAll(paymentModes);
            payChoiceBox.setOnAction(this::PayModeTypes);

        }

        public void PayModeTypes(ActionEvent event) {
        }



        //Addbutton

        private TransactFormControl mainController;

        public void setMainController(TransactFormControl mainController) {
            this.mainController = mainController;
        }

        public void AddbuttonForAll(ActionEvent event) {

            Integer bayadMethod = payChoiceBox.getValue();
            Double Amount = Double.parseDouble(transactAmountField.getText());
            LocalDate FormDPicker = getTransactionFormDPicker.getValue();
            int TransID = Integer.parseInt(getTransactionID.getText());
            int FormID = Integer.parseInt(getFormmID.getText());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("ADD");
            alert.setContentText("Are you sure everything is correct?");

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            if (alert.showAndWait().get() == ButtonType.OK) {

                Person person = new Person(TransID, FormID, Amount, bayadMethod);

                mainController.addPerson(person);

                stage.close();
            }
        }

        }


