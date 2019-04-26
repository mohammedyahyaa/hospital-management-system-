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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class receptionist extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button add_new_patient = new Button(" Add new patient ");

        VBox v0 = new VBox();

        Button Bills = new Button("Bills ");
        Button showDoctorData = new Button("Show Doctors Data ");

        Button search_patient = new Button(" Check Patients ");
         Button close = new Button(" Close ");

        add_new_patient.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        Bills.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        search_patient.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        showDoctorData.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        close.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");

        v0.getChildren().addAll(add_new_patient, Bills, search_patient, showDoctorData , close);
        v0.setSpacing(10);

        v0.setAlignment(Pos.CENTER);
        v0.setPadding(new Insets(10, 10, 10, 10));

        stage.setTitle(" REC Form");
        Scene scene = new Scene(v0, 400, 400);
        stage.setScene(scene);
        stage.show();
        //   obj.add_new_patient ;

        add_new_patient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addNewPatient add = new addNewPatient();

                try {
                    add.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(receptionist.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        search_patient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                receptionist_search searchp = new receptionist_search();
                try {
                    searchp.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(receptionist.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Bills.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bills_search b = new bills_search();
                try {
                    b.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(receptionist.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        showDoctorData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              showDoctorData s = new showDoctorData();
                try {
                    s.start(stage);
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

    }

}
