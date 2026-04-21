    package com.example.sanmarino;

    import javafx.beans.property.SimpleObjectProperty;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.collections.transformation.FilteredList;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.stage.Modality;
    import javafx.stage.Stage;

    import javax.swing.*;
    import java.io.IOException;
    import java.net.URL;
    import java.time.LocalDate;
    import java.util.Objects;
    import java.util.ResourceBundle;

    public class TransactFormControl implements Initializable{

        @FXML
        private TextField filterField;

        public TableView<Person> tableview;


        public TableColumn<Person, Integer > colTransactID;
        public TableColumn<Person, Integer > colFormID;
        public TableColumn<Person, LocalDate> colTransactDate;
        public TableColumn<Person, Double > colTransactAmount;
        public TableColumn<Person, String> colTransactMethod;




        @FXML
        private ChoiceBox<String> ColChoiceBox;

        private String[] Colmodes = {"Transact ID", "Form ID", "Date","Amounts", "Payment Type"};




        @Override
        public void initialize(URL location, ResourceBundle resources) {


            colTransactID.setCellValueFactory(new PropertyValueFactory<>("PersonTransactID"));
            colFormID.setCellValueFactory(new PropertyValueFactory<>("PersonFormID"));
            colTransactAmount.setCellValueFactory(new PropertyValueFactory<>("PersonTransactAmount"));
            colTransactMethod.setCellValueFactory(new PropertyValueFactory<>("PersonTransactType"));
            tableview.setItems(observableList);

            ColChoiceBox.getItems().addAll(Colmodes);
            ColChoiceBox.setOnAction(this::ColmodeType);

        }
        public void ColmodeType(ActionEvent event) {
            String paymentModeType = ColChoiceBox.getValue();
            System.out.println("payment method is " + paymentModeType);
        }

        ObservableList<Person> observableList= FXCollections.observableArrayList(

        );

        public void addPerson(Person person) {
            observableList.add(person);
        }

@FXML
void buttonRemove(ActionEvent event){
            int selectedID = tableview.getSelectionModel().getSelectedIndex();


    Alert Remove = new Alert(Alert.AlertType.CONFIRMATION);
    Remove.setHeaderText("Are you sure this is the right data?");
    Remove.setContentText("If deleted, it will not be able to be restored");
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    if (Remove.showAndWait().get() == ButtonType.OK) {
        tableview.getItems().remove(selectedID);
    }

}




        //MODAL FOR TFORMS
        @FXML
        private void AddTForm(ActionEvent event) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTFormm.fxml"));
                Parent root = fxmlLoader.load();

                FormController controller = fxmlLoader.getController();
                controller.setMainController(this);  // IMPORTANT


                Stage stage = new Stage();
                stage.setTitle("My Form");
                stage.setScene(new Scene(root));


                stage.initModality(Modality.APPLICATION_MODAL);


                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        private Stage stage;
        private Scene scene;
        private Parent root;

        public void switchToAnnouncement(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ANNOUNCEMENT.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }

        public void switchToHOME(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HOME.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }



        public void switchToAbout(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ABOUT.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();




        }

        public void switchToPROFILE(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PROFILE.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }




}















