/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Controller.Operat;
import Model.Bill;
import Model.Patient;
import java.sql.SQLException;

/**
 *
 * @author GhoNiem
 */
public class bills_search extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("patient Bills");
        VBox vbox = new VBox();

        HBox hbox1 = new HBox();
        VBox vboxRight = new VBox();

        VBox vboxLeft = new VBox();

        hbox1.getChildren().addAll(vboxRight, vboxLeft);
        Label lableBillNo = new Label("Bill No                                       ");
        lableBillNo.setStyle("-fx-font: normal bold 30px 'serif'; -fx-text-fill: firebrick; -fx-padding:20px");

        TextField textFildBillNo = new TextField();
        textFildBillNo.setFont(Font.font(20));
        textFildBillNo.setPrefWidth(100);

        Label lableBillDate = new Label("Bill Date                                    ");
        lableBillDate.setFont(Font.font(25));
        lableBillDate.setStyle("-fx-font: normal bold 30px 'serif'; -fx-text-fill: firebrick; -fx-padding:20px");

        TextField textFildBillDate = new TextField();
        textFildBillDate.setFont(Font.font(20));

        Label lableBillAmount = new Label("Bill Amount                               ");
        lableBillAmount.setStyle("-fx-font: normal bold 30px 'serif'; -fx-text-fill: firebrick; -fx-padding:20px");

        TextField textFildBillAmount = new TextField();
        textFildBillAmount.setFont(Font.font(20));

        vboxRight.getChildren().addAll(lableBillNo, textFildBillNo, lableBillDate, textFildBillDate, lableBillAmount, textFildBillAmount);
        Label lablePatientId = new Label("Patient Id ");
        lablePatientId.setStyle("-fx-font: normal bold 30px 'serif'; -fx-text-fill: firebrick; -fx-padding:20px");

        TextField textFildPatientId = new TextField();
        textFildPatientId.setFont(Font.font(20));
        Label lablePatientName = new Label("Patient Name");
        lablePatientName.setStyle("-fx-font: normal bold 30px 'serif'; -fx-text-fill: firebrick; -fx-padding:20px");

        lablePatientName.setFont(Font.font(25));
        TextField textFildPatientName = new TextField();
        textFildPatientName.setFont(Font.font(20));
        vboxLeft.getChildren().addAll(lablePatientId, textFildPatientId, lablePatientName, textFildPatientName);
        HBox hbox2 = new HBox();
        hbox1.getChildren().add(hbox2);

        Button buttonSave = new Button("Save");
        buttonSave.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");

        Button buttonCheckAllBills = new Button("Check All Bills ");
        buttonCheckAllBills.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");

        Button buttonClose = new Button("Close");
        buttonClose.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");

        Button back_add = new Button("back");
        back_add.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");

        hbox2.getChildren().addAll(buttonSave, buttonCheckAllBills, buttonClose, back_add);

        vbox.getChildren().addAll(hbox1, hbox2);
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        hbox1.setPadding(new Insets(20));
        hbox1.setSpacing(20);
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setPadding(new Insets(20));
        hbox2.setSpacing(20);
        hbox2.setAlignment(Pos.CENTER);
        vboxRight.setPadding(new Insets(20));
        vboxRight.setSpacing(20);
        vboxRight.setAlignment(Pos.TOP_RIGHT);
        vboxLeft.setPadding(new Insets(20));
        vboxLeft.setSpacing(20);
        vboxLeft.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(vbox);

        buttonSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String name = textFildPatientName.getText();

                String billnumberr = textFildBillNo.getText();
                int billnumber = Integer.parseInt(billnumberr);

                String billdate = textFildBillDate.getText();

                Bill bill = new Bill();

                bill.setName(name);
                bill.setBillnumber(billnumber);
                bill.setBilldate(billdate);
                bill.setBillamount(Double.parseDouble(textFildBillAmount.getText()));

                try {
                    Controller.Operat.insertbill(bill);
                } catch (SQLException ex) {
                    Logger.getLogger(bills_search.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

        buttonCheckAllBills.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                patient_bills p = new patient_bills();

                try {
                    p.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(bills_search.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        back_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                receptionist r = new receptionist();
                try {
                    r.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(addNewPatient.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        vbox.setStyle("-fx-background-color:khaki");

        primaryStage.setScene(scene);
        primaryStage.show();
        
        buttonClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

    }
   
    

}
