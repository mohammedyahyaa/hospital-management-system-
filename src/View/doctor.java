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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class doctor extends Application {

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
        search.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 20px; -fx-font-size:10px;-fx-font: normal bold 15 'serif'");
        tf_search.setPrefWidth(500);
        tf_search.setPrefHeight(60);

        Label patientState = new Label(" state of patient");
        patientState.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");
        TextArea tf_patientState = new TextArea(" ");

        HBox hbox_age = new HBox();
        hbox_age.getChildren().addAll(patientState, tf_patientState);
         hbox_age.setSpacing(20);

        Label illness = new Label(" illness");
         illness.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");
        TextField tf_illness = new TextField(" ");

        Label medecines = new Label(" medecines");
         medecines.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");
        TextField tf_medecines = new TextField(" ");
       

        HBox hbox_illness = new HBox();
        hbox_illness.getChildren().addAll(illness, tf_illness, medecines, tf_medecines);
        hbox_illness.setSpacing(20);

        VBox vb2 = new VBox();
        VBox vb3 = new VBox();

        HBox hbox = new HBox();

        vb3.getChildren().addAll(hbox_age, hbox_illness);

        hbox.getChildren().addAll(vb2, vb3);

        ////////////////////////////////////////////////////////////////////////////////////////
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(search, tf_search);
        hb1.setSpacing(40);

        TableView<Patient> table = new TableView();
        table.setStyle("-fx-background-color: firebrick; -fx-font-size: 11pt;fx-table-cell-border-color: transparent;-fx-table-header-border-color: transparent; ");

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

        Button update = new Button(" update ");

        Button close_serch = new Button(" close ");
        update.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");

        update.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 30px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");
       
        close_serch.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 35px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");

       

        vb1.getChildren().addAll(hb1, table, hbox, update, close_serch);

        stage.setTitle("Doctor");
        Scene scene = new Scene(vb1, 600, 600);
        vb1.setStyle("-fx-background-color:khaki");
        stage.setScene(scene);
        stage.show();

        close_serch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        table.setOnMouseClicked(e -> {

            Patient p = table.getSelectionModel().getSelectedItem();

            tf_patientState.setText(p.getPatientstatus());
            tf_illness.setText(p.getIllness());
            tf_medecines.setText(p.getMedecines());

            tempid = p.getId();
        });

        update.setOnMouseClicked(e -> {

            Patient p = new Patient();

            p.setPatientstatus(tf_patientState.getText());
            p.setIllness(tf_illness.getText());
            p.setMedecines(tf_medecines.getText());

            p.setId(tempid);

            op.updatepatientByDoctor(p);

            table.setItems(op.selectAllpatient());
            JOptionPane.showMessageDialog(null, "record is updated");
        });

        search.setOnMouseClicked(e -> {

            table.setItems(op.searchpatient(tf_search.getText().toString()));

        });

    }

}
