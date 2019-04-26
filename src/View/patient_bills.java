/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Operat;
import static Controller.Operat.st;
import Model.Bill;
import Model.Patient;
import static View.receptionist_search.tempid;
import java.sql.SQLException;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author mohamed yahya
 */
public class patient_bills extends Application {

    static int tempidbill;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        VBox vb2 = new VBox();
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 10, 10));
        vb2.setAlignment(Pos.CENTER_LEFT);

        Button search = new Button("search");
        search.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 20px; -fx-font-size:10px;-fx-font: normal bold 15 'serif'");
        TextField tf_search = new TextField();
        tf_search.setPrefWidth(500);
        tf_search.setPrefHeight(60);

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(search, tf_search);
        hb1.setSpacing(40);

        Label patientName = new Label(" patient name    ");
        TextField tf_name = new TextField(" ");
        tf_name.setPrefWidth(500);
        tf_name.setPrefHeight(60);

        patientName.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_name = new HBox();
        hbox_name.getChildren().addAll(patientName, tf_name);

        Label billNumber = new Label(" Bill Number     ");
        TextField tf_billnumber = new TextField(" ");
        tf_billnumber.setPrefWidth(500);
        tf_billnumber.setPrefHeight(60);

        billNumber.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_billNumber = new HBox();
        hbox_billNumber.getChildren().addAll(billNumber, tf_billnumber);

        Label billDate = new Label(" Bill Date           ");
        TextField tf_BillDate = new TextField(" ");
        tf_BillDate.setPrefWidth(500);
        tf_BillDate.setPrefHeight(60);
        billDate.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_BillDate = new HBox();
        hbox_BillDate.getChildren().addAll(billDate, tf_BillDate);

        Label billAmount = new Label(" Bill Amount     ");
        TextField tf_billAmount = new TextField(" ");
        tf_billAmount.setPrefWidth(500);
        tf_billAmount.setPrefHeight(60);
        
        billAmount.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_billAmount = new HBox();
        hbox_billAmount.getChildren().addAll(billAmount, tf_billAmount);

        TableView<Bill> table = new TableView();
        table.setStyle("-fx-background-color: firebrick; -fx-font-size: 11pt;fx-table-cell-border-color: transparent;-fx-table-header-border-color: transparent; ");
       

        TableColumn<Bill, Integer> columnIdColumn = new TableColumn("patient id");
        TableColumn<Bill, String> columnpatientnameColumn = new TableColumn("patient name");
        TableColumn<Bill, Integer> columnbillnoColumn = new TableColumn("Bill no");
        TableColumn<Bill, String> columndateColumn = new TableColumn("Bill date");
        TableColumn<Bill, String> columnamountColumn = new TableColumn("Bill amount");

        columnbillnoColumn.setCellValueFactory(new PropertyValueFactory<>("billnumber"));
        columndateColumn.setCellValueFactory(new PropertyValueFactory<>("billdate"));
        columnIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnamountColumn.setCellValueFactory(new PropertyValueFactory<>("billamount"));
        columnpatientnameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        columnbillnoColumn.prefWidthProperty().bind(table.widthProperty().divide(5));
        columnIdColumn.prefWidthProperty().bind(table.widthProperty().divide(5));
        columnamountColumn.prefWidthProperty().bind(table.widthProperty().divide(5));
        columndateColumn.prefWidthProperty().bind(table.widthProperty().divide(5));
        columnpatientnameColumn.prefWidthProperty().bind(table.widthProperty().divide(5));

        table.getColumns().addAll(columnIdColumn, columnpatientnameColumn, columnbillnoColumn, columndateColumn, columnamountColumn);
        Operat o = new Operat();
        table.setItems(o.selectAllbills());

        Button delete = new Button("Delete");
        Button update = new Button("Update");
        Button back_bills = new Button("back");
        Button close_bills = new Button("close");
        delete.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 33px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");
        update.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 30px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");
        back_bills.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 35px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");
        close_bills.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 35px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");

        vb2.getChildren().addAll(hb1, table, hbox_name, hbox_billNumber, hbox_BillDate, hbox_billAmount, update, delete, back_bills, close_bills);

        stage.setTitle("patient Bills");
        Scene scene = new Scene(vb2, 600, 600);
        stage.setScene(scene);
        vb2.setStyle("-fx-background-color:khaki");
        stage.show();
        back_bills.setOnAction(new EventHandler<ActionEvent>() {
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

        close_bills.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        search.setOnMouseClicked(e -> {

            table.setItems(o.searchBill((tf_search.getText().toString())));

        });

        table.setOnMouseClicked(e -> {

            Bill b = table.getSelectionModel().getSelectedItem();

            tf_name.setText(b.getName());
            tf_billnumber.setText(String.valueOf(b.getBillnumber()));
            tf_BillDate.setText(b.getBilldate());
            tf_billAmount.setText(String.valueOf(b.getBillamount()));

            tempidbill = b.getId();
        });

        update.setOnMouseClicked(e -> {

            Bill s = new Bill();

            s.setName(tf_name.getText());
            s.setBillnumber(Integer.parseInt(tf_billnumber.getText()));
            s.setBilldate(tf_BillDate.getText());
            s.setBillamount(Double.parseDouble(tf_billAmount.getText()));

            s.setId(tempidbill);

            o.updatebill(s);

            table.setItems(o.selectAllbills());

        });
        delete.setOnMouseClicked(e -> {

            
            vb2.setPadding(new Insets(100));
            
            o.deletebills(tempidbill);
            table.setItems(o.selectAllbills());
            JOptionPane.showMessageDialog(null, "record deleted");

        });

    }

}
