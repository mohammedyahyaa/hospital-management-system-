package View;

import Controller.Operat;
import Model.Bill;
import Model.Patient;
import Model.storeDoctor;
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

public class showDoctorData extends Application {

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
        tf_search.setPrefHeight(40);

        ////////////////////////////////////////////////////////////////////////////////////////
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(search, tf_search);
        hb1.setSpacing(40);

        TableView<storeDoctor> table = new TableView();
        table.setStyle("-fx-background-color: firebrick; -fx-font-size: 11pt;fx-table-cell-border-color: transparent;-fx-table-header-border-color: transparent; ");

        TableColumn<storeDoctor, Integer> columnIdColumn = new TableColumn("doctor ID ");
        TableColumn<storeDoctor, String> columnfirstNameColumn = new TableColumn("first name ");
        TableColumn<storeDoctor, String> columnlastNameColumn = new TableColumn("last name");
        TableColumn<storeDoctor, Integer> columnageColumn = new TableColumn("doctor age ");
        TableColumn<storeDoctor, String> columnphonenumberColumn = new TableColumn("phone number");
        TableColumn<storeDoctor, String> columnsalaryColumn = new TableColumn("salary");
        TableColumn<storeDoctor, String> columnaddressColumn = new TableColumn("address");

        columnIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnfirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        columnlastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        columnageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnphonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        columnsalaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        columnaddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        columnIdColumn.prefWidthProperty().bind(table.widthProperty().divide(7));
        columnfirstNameColumn.prefWidthProperty().bind(table.widthProperty().divide(7));
        columnlastNameColumn.prefWidthProperty().bind(table.widthProperty().divide(7));
        columnageColumn.prefWidthProperty().bind(table.widthProperty().divide(7));
        columnphonenumberColumn.prefWidthProperty().bind(table.widthProperty().divide(7));
        columnsalaryColumn.prefWidthProperty().bind(table.widthProperty().divide(7));
        columnaddressColumn.prefWidthProperty().bind(table.widthProperty().divide(7));

        table.getColumns().addAll(columnIdColumn, columnfirstNameColumn, columnlastNameColumn, columnageColumn, columnphonenumberColumn, columnsalaryColumn, columnaddressColumn);

        Operat op = new Operat();
        table.setItems(op.selectAlldoctor());

        //
        Button back_search = new Button(" back ");
        Button close_serch = new Button(" close ");

        back_search.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 30px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");
        close_serch.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 30px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");

        vb1.getChildren().addAll(hb1, table, back_search, close_serch);

        stage.setTitle("show Doctor Data");
        vb1.setStyle("-fx-background-color:khaki");

        Scene scene = new Scene(vb1, 600, 600);
        stage.setScene(scene);
        stage.show();

        back_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                receptionist r = new receptionist();
                try {
                    r.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(addNewPatient.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        close_serch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        search.setOnMouseClicked(e -> {

            table.setItems(op.searchdoctor(tf_search.getText().toString()));

        });

    }

}
