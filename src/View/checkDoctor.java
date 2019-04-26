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

public class checkDoctor extends Application {

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
       

        
        ///////////  text fields to make updates
        Label firstName = new Label(" doctor first name        ");
        TextField tf_firstName = new TextField(" ");
        firstName.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_firstname = new HBox();
        hbox_firstname.getChildren().addAll(firstName, tf_firstName);

        Label lastName = new Label(" doctor last name          ");
        TextField tf_lastName = new TextField(" ");
        lastName.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_lastname = new HBox();
        hbox_lastname.getChildren().addAll(lastName, tf_lastName);

        Label salary = new Label("doctor salary         ");
        TextField tf_salary = new TextField(" ");
        salary.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_salary = new HBox();
        hbox_salary.getChildren().addAll(salary, tf_salary);

        Label address = new Label(" doctor address         ");
        TextField tf_address = new TextField(" ");
        address.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_address = new HBox();
        hbox_address.getChildren().addAll(address, tf_address);

        Label age = new Label(" doctor age       ");
        TextField tf_age = new TextField(" ");
        age.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_age = new HBox();
        hbox_age.getChildren().addAll(age, tf_age);

        Label phonenumber = new Label("phone number          " );
        TextField tf_phonenumber = new TextField(" ");
        phonenumber.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: firebrick");

        HBox hbox_phonenumber = new HBox();
        hbox_phonenumber.getChildren().addAll(phonenumber, tf_phonenumber);

        VBox vb2 = new VBox();
        VBox vb3 = new VBox();
        VBox vb4 = new VBox();

        HBox hbox = new HBox();

        vb2.getChildren().addAll(hbox_firstname, hbox_lastname);
        
        vb3.getChildren().addAll(hbox_age, hbox_phonenumber);
        
        vb4.getChildren().addAll(hbox_salary, hbox_address);
       

        hbox.getChildren().addAll(vb2, vb3, vb4);

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
        Button update = new Button(" update  ");
        Button delete = new Button(" Delete ");
        Button back_search = new Button(" back ");
        Button close_serch = new Button(" close ");
        delete.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 33px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");
        update.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 30px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");
        back_search.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 35px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");
        close_serch.setStyle(" -fx-text-fill: white; -fx-background-color: royalblue; -fx-padding:10px 35px; -fx-font-size:12px;-fx-font: normal bold 15 'serif'");

        vb1.getChildren().addAll(hb1, table, hbox, update, delete, back_search, close_serch);

        vb1.setStyle("-fx-background-color:khaki");
        stage.setTitle(" check doctor ");
        Scene scene = new Scene(vb1, 600, 600);
        stage.setScene(scene);
        stage.show();

        back_search.setOnAction(new EventHandler<ActionEvent>() {
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

        close_serch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        table.setOnMouseClicked(e -> {

            storeDoctor d = table.getSelectionModel().getSelectedItem();

            tf_firstName.setText(d.getFirstname());
            tf_lastName.setText(d.getLastname());
            tf_age.setText(String.valueOf(d.getAge()));
            tf_phonenumber.setText(String.valueOf(d.getPhonenumber()));
            tf_salary.setText(String.valueOf(d.getSalary()));
            tf_address.setText(String.valueOf(d.getAddress()));

            tempid = d.getId();
        });

        update.setOnMouseClicked(e -> {

            storeDoctor s = new storeDoctor();

            s.setFirstname(tf_firstName.getText());
            s.setLastname(tf_lastName.getText());
            s.setAge(Integer.parseInt(tf_age.getText()));
            s.setPhonenumber(Integer.parseInt(tf_phonenumber.getText()));
            s.setSalary(Integer.parseInt(tf_salary.getText()));
            s.setAddress(tf_address.getText());
            

            s.setId(tempid);

            op.updatedoctor(s);

            table.setItems(op.selectAlldoctor());
            JOptionPane.showMessageDialog(null, "record updated");

        });

  delete.setOnMouseClicked(e -> {

            op.deletedoctor(tempid);
            table.setItems(op.selectAlldoctor());
            JOptionPane.showMessageDialog(null, "record deleted");

        });
        search.setOnMouseClicked(e -> {

            table.setItems(op.searchdoctor(tf_search.getText().toString()));

        });

    }

}
