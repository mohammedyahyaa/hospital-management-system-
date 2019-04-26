package View;

import Controller.Operat;
import Model.storeDoctor;
import database_conection.DataBase_Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.swing.UIManager.getString;

public class generalReport extends Application {
    
    static TextField textField = new TextField();
    static PasswordField passwordField = new PasswordField();
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Login");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        
        VBox vBox = new VBox();
        
        Scene scene = new Scene(vBox);
        
        Label sum_doctor = new Label("sum of all doctor salaries is  :  ");
        Text salary = new Text("");
        
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(sum_doctor, salary);
        
        Label sum_bills = new Label("sum of all patient bills  is   :");
        Text bills = new Text("");
        
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(sum_bills, bills);
        
        Label doctor_number = new Label(" number of doctors    : ");
        Text docnumber = new Text("");
        
        HBox hb3 = new HBox();
        hb3.getChildren().addAll(doctor_number, docnumber);
        
        Label patient_number = new Label(" number of patient   : ");
        Text patinumber = new Text("");
        
        HBox hb4 = new HBox();
        hb4.getChildren().addAll(patient_number, patinumber);
        
        Label bills_number = new Label(" number of bills    : ");
        Text billsnumber = new Text("");
        
        HBox hb5 = new HBox();
        hb5.getChildren().addAll(bills_number, billsnumber);
        
        Button back_add = new Button(" back");
        back_add.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:18;");
        
        vBox.getChildren().addAll(hb1, hb2, hb3, hb4, hb5 , back_add);
        
        Operat o = new Operat();
        storeDoctor s = new storeDoctor();
        
        
        
        //// call value from methods 
        
        salary.setText(String.valueOf(o.sumsalary()));
        
        bills.setText(String.valueOf(o.sumbills()));
        
       docnumber.setText(String.valueOf(o.doctornum()));
       
       patinumber.setText(String.valueOf(o.patientnum()));
       
       billsnumber.setText(String.valueOf(o.billnum()));
       
       
       
       back_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                manager m =new manager();
                try {
                    m.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(addNewDoctor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
    }
}
