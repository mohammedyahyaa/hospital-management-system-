package View;

import Controller.Operat;
import Model.Bill;
import Model.Patient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class checkPatient extends Application {

    static String tempfirstname;
    static String templastname;
    static int tempid;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox vb1 = new VBox();
        vb1.setSpacing(10);
        vb1.setPadding(new Insets(10, 10, 10, 10));
        vb1.setAlignment(Pos.CENTER_LEFT);

        Button search = new Button("search");
        TextField tf_search = new TextField();

        ///////////  text fields to make updates
        Label firstName = new Label(" first name");
        TextField tf_firstName = new TextField(" ");

        HBox hbox_firstname = new HBox();
        hbox_firstname.getChildren().addAll(firstName, tf_firstName);

        Label lastName = new Label(" last name");
        TextField tf_lastName = new TextField(" ");

        HBox hbox_lastname = new HBox();
        hbox_lastname.getChildren().addAll(lastName, tf_lastName);

        Label age = new Label(" age");
        TextField tf_age = new TextField(" ");

        HBox hbox_age = new HBox();
        hbox_age.getChildren().addAll(age, tf_age);

        Label dateOfExamination = new Label("Date of Exatmination");
        TextField tf_dateOfexamintaion = new TextField(" ");

        HBox hbox_illness = new HBox();
        hbox_illness.getChildren().addAll(dateOfExamination, tf_dateOfexamintaion);

        VBox vb2 = new VBox();
        VBox vb3 = new VBox();

        HBox hbox = new HBox();

        vb2.getChildren().addAll(hbox_firstname, hbox_lastname);
        vb3.getChildren().addAll(hbox_age, hbox_illness);

        hbox.getChildren().addAll(vb2, vb3);

        ////////////////////////////////////////////////////////////////////////////////////////
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(search, tf_search);

        TableView<Patient> table = new TableView();

        TableColumn<Patient, Integer> columnIdColumn = new TableColumn("patient id");
        TableColumn<Patient, String> columnfirstNameColumn = new TableColumn("first name ");
        TableColumn<Patient, String> columnlastNameColumn = new TableColumn("last name");
        TableColumn<Patient, Integer> columnageColumn = new TableColumn("patient age ");
        TableColumn<Patient, String> columnillnessColumn = new TableColumn("illness");
        TableColumn<Patient, String> columnpatientstatusColumn = new TableColumn("patient status");
        TableColumn<Patient, String> columnmedecinesColumn = new TableColumn("medecines");
        TableColumn<Patient, String> columndateOfExaminationColumn = new TableColumn("Date of examination ");

        columnIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnfirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        columnlastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        columnageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnillnessColumn.setCellValueFactory(new PropertyValueFactory<>("illness"));
        columnpatientstatusColumn.setCellValueFactory(new PropertyValueFactory<>("patientstatus"));
        columnmedecinesColumn.setCellValueFactory(new PropertyValueFactory<>("medecines"));
        columndateOfExaminationColumn.setCellValueFactory(new PropertyValueFactory<>("dateofexamination"));

        columnIdColumn.prefWidthProperty().bind(table.widthProperty().divide(8));
        columnfirstNameColumn.prefWidthProperty().bind(table.widthProperty().divide(8));
        columnlastNameColumn.prefWidthProperty().bind(table.widthProperty().divide(8));
        columnageColumn.prefWidthProperty().bind(table.widthProperty().divide(8));
        columnillnessColumn.prefWidthProperty().bind(table.widthProperty().divide(8));
        columnpatientstatusColumn.prefWidthProperty().bind(table.widthProperty().divide(8));
        columnmedecinesColumn.prefWidthProperty().bind(table.widthProperty().divide(8));
        columndateOfExaminationColumn.prefWidthProperty().bind(table.widthProperty().divide(8));

        table.getColumns().addAll(columnIdColumn, columnfirstNameColumn, columnlastNameColumn, columnageColumn, columnillnessColumn, columnpatientstatusColumn, columnmedecinesColumn, columndateOfExaminationColumn);

        Operat op = new Operat();
        table.setItems(op.selectAllpatient());

        //
        Button back_search = new Button(" back ");
        Button close = new Button(" close ");

        back_search.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:16;");
        close.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:16;");

        vb1.getChildren().addAll( hb1 , table,back_search ,close  );

        stage.setTitle(" REC Form");
        Scene scene = new Scene(vb1, 600, 600);
        stage.setScene(scene);
        stage.show();

        back_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                manager m = new manager();
                try {
                    m.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(addNewPatient.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        table.setOnMouseClicked(e -> {

            Patient p = table.getSelectionModel().getSelectedItem();

            tf_firstName.setText(p.getFirstname());
            tf_lastName.setText(p.getLastname());
            tf_age.setText(String.valueOf(p.getAge()));
            tf_dateOfexamintaion.setText(p.getdate());

            tempid = p.getId();
        });

        
        
        search.setOnMouseClicked(e -> {

            table.setItems(op.searchpatient(tf_search.getText().toString()));

        });

    }

}
