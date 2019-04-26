package View;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class login extends Application {

    static TextField textField = new TextField();
    static PasswordField passwordField = new PasswordField();

    public static void main(String[] args) {
        launch(args);

    }

    // doctor user name = doctor and password = 123456
    // receptionist user name = receptionist and password =123456
    // manager user name = manager and password =123456
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        
        
        
        
        
        primaryStage.setTitle("Login");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        // create panes 
        GridPane gridPane1 = new GridPane();
        GridPane gridpane2 = new GridPane();
        GridPane gridpane3 = new GridPane();

        Scene scene = new Scene(gridPane1);
        
        gridPane1.add(gridpane2, 0, 2);
        gridPane1.add(gridpane3, 0, 3);

        // create labels 
        

        Label l2 = new Label("HOSPITAL MANAGEMENT SYSTEM");
        gridPane1.add(l2, 0, 1);
        l2.setStyle("-fx-font: normal bold 50px 'serif'; -fx-text-fill: firebrick; -fx-padding:30px");

        Label l3 = new Label("user type ");
        gridpane2.add(l3, 0, 0);
        l3.setStyle("-fx-font: normal bold 40px 'serif'; -fx-text-fill: firebrick");

        Label l4 = new Label("Password");
        gridpane2.add(l4, 0, 1);
        l4.setStyle("-fx-font: normal bold 40px 'serif'; -fx-text-fill: firebrick");

        // create user name and password text field
        String arr1[] = {"doctor", "receptionist", "manager"};
        ComboBox<String> ComboBox1 = new ComboBox<String>();
        ComboBox1.getItems().addAll(arr1);
        ComboBox1.setValue("user type");
        gridpane2.add(ComboBox1, 1, 0);
        ComboBox1.setStyle("-fx-background-color: white ;-fx-text-fill:white ;-fx-font: normal bold 35px 'serif'");
        ComboBox1.setPrefWidth(300);
        
        PasswordField passwordField = new PasswordField();
        gridpane2.add(passwordField, 1, 1);
        passwordField.setFont(Font.font("Bold", 20));

        // create login and cancel button 
        Button loginButton = new Button("Login");
        gridpane3.add(loginButton, 3, 1);
        loginButton.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");
        

        Button cancelButton = new Button("Cancel");
        gridpane3.add(cancelButton, 4, 1);
        cancelButton.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");


        Button aboutButton = new Button("About");
        gridpane3.add(aboutButton, 3, 2);
        aboutButton.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");
        

        Button termsbutton = new Button("terms  ");
        gridpane3.add(termsbutton, 4, 2);
        termsbutton.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:15px 50px; -fx-font-size:17px;-fx-font: normal bold 20px 'serif'");

        // buttons action
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (ComboBox1.getValue().toString() == "doctor" && passwordField.getText().equals("doc123456")) {

                    try {
                        doctor d = new doctor();
                        d.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);

                    }

                } else if (ComboBox1.getValue().toString()=="receptionist" && passwordField.getText().equals("rec123456")) {

                    try {
                        receptionist r = new receptionist();
                        r.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (ComboBox1.getValue().toString()=="manager" && passwordField.getText().equals("man123456")) {

                    manager r = new manager();
                    try {
                        r.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {

                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "confirm from user name and password");
                    
                    passwordField.setText("");
                }

            }
        });

        termsbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert termsAlert = new Alert(Alert.AlertType.INFORMATION);
                termsAlert.setTitle("terms and conditions ");
                termsAlert.setHeaderText("Terms and Conditions ");
                termsAlert.setContentText("you must follow any policies made available to you within the services "
                        + "don't misuse our services for example , don't interfere with our services or try to access them using "
                        + " a method other than the interface and the instructions that we provide re-export control laws and regulations"
                        + "we may suspend or stop providing our services to you if you do not comply with our terms or policies "
                        + "or if we are investigating suspected misconduct  ."
                        + "using our servcies does not give you ownership of any intellectula property rights inour services or the content you access  "
                        + "you may not use content from our services unless you obtain permission from it's owner or are otherwise permitted by law "
                        + "these terms do not grant you the right to use any branding or logos used in our services ."
                        + "don't remove obscurs , or alter any legal notices displayed in or along with our services  "
                        + "                      \n                           ** Hospital Managment System**          .  "
                        + "  "
                        + "  ");
                termsAlert.showAndWait();

            }
        });

        gridpane3.setHgap(80);
        gridpane2.setHgap(50);
        gridPane1.setHgap(80);
        gridpane3.setVgap(30);
        gridpane2.setVgap(30);
        gridPane1.setVgap(30);

        gridPane1.setAlignment(Pos.CENTER);
        // gridPane1.setStyle("-fx-background-color: #004km2j");
     
        primaryStage.setScene(scene);
       

        //gridPane1.setStyle("-fx-background-image: url(\"background.png\");");
        primaryStage.show();
        gridPane1.setStyle("-fx-background-color:khaki");
        

    }
}
