package View;

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class manager extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        VBox v0 = new VBox();

        Button check_patient = new Button(" Check Patient Data ");
        Button add_new_doctor = new Button(" Add New Doctor  ");
        Button check_doctor = new Button("Check Doctor Data ");
        Button check_bills = new Button("check Bills ");
        Button general_report = new Button("General Report ");
        Button close = new Button("close");

        add_new_doctor.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        check_bills.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        check_doctor.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        check_patient.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        general_report.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        close.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");

        v0.getChildren().addAll(add_new_doctor, check_doctor, check_patient, check_bills, general_report , close);
        v0.setSpacing(10);

        v0.setAlignment(Pos.CENTER);
        v0.setPadding(new Insets(10, 10, 10, 10));

        stage.setTitle(" REC Form");
        Scene scene = new Scene(v0, 400, 400);
        stage.setScene(scene);
        stage.show();
        //   obj.add_new_patient ;

        add_new_doctor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addNewDoctor d = new addNewDoctor();

                try {
                    d.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(receptionist.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        check_patient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                checkPatient cp = new checkPatient();
                try {
                    cp.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(receptionist.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        check_bills.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkBills b = new checkBills();
                try {
                    b.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(receptionist.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        check_doctor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkDoctor c = new checkDoctor();
                try {
                    c.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(receptionist.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
         close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                System.exit(0);
                
            }     
        });
         
         general_report.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                generalReport g =new generalReport();
                try {
                    g.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }     
        });
         
         


    }

}
