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
import Model.storeDoctor;
import database_conection.DataBase_Connection;
import java.sql.SQLException;
import static javafx.application.Application.launch;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
//import com.mysql.jdbc.Statement;

public class addNewDoctor extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color:khaki");
        gp.setMinSize(200, 200);

        gp.setHgap(15);
        gp.setVgap(15);
        gp.setPadding(new Insets(10, 10, 10, 10));

        Text first_name = new Text(" First name");
        first_name.setStyle("-fx-font: normal bold 40px 'serif'");
        first_name.setFill(Color.FIREBRICK);

        Text last_name = new Text(" Last Name ");
        last_name.setStyle("-fx-font: normal bold 40px 'serif'");
        last_name.setFill(Color.FIREBRICK);
       

        Text age = new Text(" Age");
        age.setStyle("-fx-font: normal bold 40px 'serif'");
        age.setFill(Color.FIREBRICK);

//        Text address = new Text(" Address");
//        address.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));
        Text address = new Text(" Address");
        address.setStyle("-fx-font: normal bold 40px 'serif'");
        address.setFill(Color.FIREBRICK);

        Text salary = new Text(" Salary ");
        salary.setStyle("-fx-font: normal bold 40px 'serif'");
        salary.setFill(Color.FIREBRICK);

        Text phonenumber = new Text(" Doctor's phone number ");
        phonenumber.setStyle("-fx-font: normal bold 40px 'serif'");
        phonenumber.setFill(Color.FIREBRICK); 
        
        Button insert = new Button(" Insert");
        insert.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");
        Button back_add = new Button(" back");
        back_add.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");
        Button close_add = new Button(" close");
        close_add.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");


        TextField tf_firstName = new TextField();
        tf_firstName.setPrefWidth(800);
        tf_firstName.setPrefHeight(40);
        
        TextField tf_lastName = new TextField();
        tf_lastName.setPrefWidth(800);
        tf_lastName.setPrefHeight(40);
        TextField tf_age = new TextField();
        tf_age.setPrefWidth(800);
        tf_age.setPrefHeight(40);
        // TextField tf_address = new TextField();
        TextField tf_address = new TextField();
        tf_address.setPrefWidth(800);
        tf_address.setPrefHeight(40);
        TextField tf_phonenumber = new TextField();
        tf_phonenumber.setPrefWidth(800);
        tf_phonenumber.setPrefHeight(40);
        TextField tf_salary = new TextField();
        tf_salary.setPrefWidth(800);
        tf_salary.setPrefHeight(40);

        tf_firstName.setPromptText(" enter doctor firstName ");
        tf_firstName.setFont(Font.font("Serif", 20));
        
        tf_lastName.setPromptText(" enter doctor lastName ");
        tf_lastName.setFont(Font.font("Serif", 20));
        tf_age.setPromptText(" enter  doctor age ");
        //   tf_address.setPromptText(" enter address ");
        tf_address.setPromptText(" enter doctor address ");
        tf_address.setFont(Font.font("Serif", 20));
        tf_salary.setPromptText(" enter doctor salary ");
        tf_salary.setFont(Font.font("Serif", 20));
        tf_phonenumber.setPromptText(" enter doctor phone number ");
        tf_phonenumber.setFont(Font.font("Serif", 20));

        gp.add(first_name, 0, 1);
        gp.add(tf_firstName, 1, 1);

        gp.add(last_name, 0, 2);
        gp.add(tf_lastName, 1, 2);

        gp.add(age, 0, 3);
        gp.add(tf_age, 1, 3);

//        gp.add(address, 0, 4);
//        gp.add(tf_address, 1, 4);
        gp.add(address, 0, 4);
        gp.add(tf_address, 1, 4);

        gp.add(phonenumber, 0, 5);
        gp.add(tf_phonenumber, 1,5);

        gp.add(salary, 0, 6);
        gp.add(tf_salary, 1, 6);

        HBox hboxb=new HBox();
        hboxb.setAlignment(Pos.CENTER);
        hboxb.setSpacing(20);
        hboxb.getChildren().addAll(insert,close_add,back_add);
        gp.add(hboxb, 1, 10);
        
        
        
        stage.setTitle("Add New Patient");
        Scene scene = new Scene(gp, 600, 600);
        stage.setScene(scene);
        stage.show();

        gp.setAlignment(Pos.CENTER);

        insert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String firstname = tf_firstName.getText();
                String lastname = tf_lastName.getText();

                int age = Integer.parseInt(tf_age.getText());

                String address = tf_address.getText();
                int phonenumber = Integer.parseInt(tf_phonenumber.getText());
                int salary = Integer.parseInt(tf_salary.getText());

                storeDoctor doct = new storeDoctor();

                doct.setFirstname(firstname);
                doct.setLastname(lastname);
                doct.setAge(age);
                doct.setAddress(address);
                doct.setPhonenumber(phonenumber);
                doct.setSalary(salary);
                try {
                    Controller.Operat.insertdoctor(doct);
                } catch (SQLException ex) {
                    Logger.getLogger(addNewDoctor.class.getName()).log(Level.SEVERE, null, ex);
                }

                tf_firstName.setText("");
                tf_lastName.setText("");
                tf_age.setText("");
                tf_address.setText("");
                tf_phonenumber.setText("");
                tf_salary.setText("");

                JOptionPane.showMessageDialog(null, "A new doctor was inserted successfully! ");

            }
        });
         back_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                manager m =new manager();
                try {
                    m.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(addNewDoctor.class.getName()).log(Level.SEVERE, null, ex);
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
