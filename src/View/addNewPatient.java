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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.Statement;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Model.Patient;
import database_conection.DataBase_Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import com.mysql.jdbc.Statement;

public class addNewPatient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        GridPane gp = new GridPane();
        gp.setMinSize(200, 200);

        gp.setHgap(15);
        gp.setVgap(15);
        gp.setPadding(new Insets(10, 10, 10, 10));

        Text medecine = new Text("medicine");
        medecine.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));

        Text first_name = new Text(" First name");
        first_name.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));

        Text last_name = new Text(" Last Name ");
        last_name.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));

        Text age = new Text(" Age");
        age.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));

//        Text address = new Text(" Address");
//        address.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));
        Text illness = new Text(" illness");
        illness.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));

        Text dateOfExamination  = new Text("Date of Examination");
        dateOfExamination.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));
        
        Text status_of_patient = new Text(" Status of patient");
        status_of_patient.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));

        Button insert = new Button(" Insert");
        Button back_add = new Button(" back");
        Button close_add = new Button(" close");
        insert.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:20;");
        back_add.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:18;");
        close_add.setStyle("-fx-background-color: darkslateblue;-fx-text-fill: white;-fx-font-size:16;");

        

        TextField tf_firstName = new TextField();
        TextField tf_lastName = new TextField();
        TextField tf_age = new TextField();
        // TextField tf_address = new TextField();
        TextField tf_illness = new TextField();
        TextField tf_dateofexamination = new TextField();
        TextArea ta_statusPatient = new TextArea();
        TextField tf_medecines = new TextField();
        
        tf_medecines.setPromptText(" enter patient medicines ");
        tf_firstName.setPromptText(" enter firstName ");
        tf_lastName.setPromptText(" enter lastName ");
        tf_age.setPromptText(" enter age ");
        tf_dateofexamination.setPromptText(" enter Date of Examinataion ");
        //   tf_address.setPromptText(" enter address ");
        tf_illness.setPromptText(" enter illness ");
        

        

        gp.add(first_name, 0, 0);
        gp.add(tf_firstName, 1, 0);

        gp.add(last_name, 0, 1);
        gp.add(tf_lastName, 1, 1);

        gp.add(age, 0, 2);
        gp.add(tf_age, 1, 2);
        
        gp.add(dateOfExamination, 0, 3);
        gp.add(tf_dateofexamination, 1, 3);

//        gp.add(address, 0, 4);
//        gp.add(tf_address, 1, 4);
        gp.add(illness, 0, 4);
        gp.add(tf_illness, 1, 4);
        
        gp.add(medecine, 0, 5);
        gp.add(tf_medecines, 1, 5);

        gp.add(status_of_patient, 0, 6);
        gp.add(ta_statusPatient, 1, 6);

        gp.add(insert, 0, 7);
        gp.add(back_add, 1, 8);
        gp.add(close_add, 1, 9);

        stage.setTitle(" REC Form");
        Scene scene = new Scene(gp, 600, 600);
        stage.setScene(scene);
        stage.show();

        gp.setAlignment(Pos.CENTER);

        insert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String firstname = tf_firstName.getText();
                String lastname = tf_lastName.getText();

                String ageee = tf_age.getText();
                int agee = Integer.parseInt(ageee);

                String illnesss = tf_illness.getText();
                String Patientstatus = ta_statusPatient.getText();
                String medicine = tf_medecines.getText();
                String dateofexamination = tf_dateofexamination.getText();
                 
                

                Patient pati = new Patient();

                
                pati.setFirstname(firstname);
                pati.setLastname(lastname);
                pati.setAge(agee);
                pati.setIllness(illnesss);
                pati.setPatientstatus(Patientstatus);
                pati.setdate(dateofexamination);
                pati.setMedecines(medicine);
                

                try {
                    Controller.Operat.insertpatient(pati);
                } catch (SQLException ex) {
                    Logger.getLogger(addNewPatient.class.getName()).log(Level.SEVERE, null, ex);
                }
                tf_firstName.setText("");
                tf_lastName.setText("");
                tf_age.setText("");
                tf_illness.setText("");
                ta_statusPatient.setText("");
                tf_dateofexamination.setText("");
                tf_medecines.setText("");
                
                JOptionPane.showMessageDialog(null, "A new patient was inserted successfully! ");
                

            }
        });
        back_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                receptionist f = new receptionist();
                try {
                    f.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(addNewPatient.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        close_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }

}
