package Controller;

import View.addNewPatient;
import com.mysql.jdbc.Connection;
import database_conection.DataBase_Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Patient;
import Model.Bill;
import Model.storeDoctor;
import View.doctor;
import View.generalReport;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static jdk.nashorn.internal.objects.Global.println;

public class Operat {

    public static Connection conn;
    public static Statement st;
    public static int sizee;
    private Object sum;

    public static int insertbill(Bill bill) throws SQLException {
        int rowsInserted = 0;

        try {
            st = DataBase_Connection.getconnection().createStatement();
            rowsInserted = st.executeUpdate("insert into bill (name,billnumber,billdate,billamount) values ( '" + bill.getName() + "'  ,'" + bill.getBillnumber() + "','" + bill.getBilldate() + "','" + bill.getBillamount() + "' )");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (rowsInserted > 0) {
            System.out.println("A new bill was inserted successfully!");
        }

        return rowsInserted;
    }

    public static int insertpatient(Patient pati) throws SQLException {
        int rowsInserted = 0;
        Statement st;

        try {
            st = DataBase_Connection.getconnection().createStatement();
            rowsInserted = st.executeUpdate("insert into patient (firstname,lastname,age,illness,patientstatus,medecines,date) values ( '" + pati.getFirstname() + "','" + pati.getLastname() + "','" + pati.getAge() + "','" + pati.getIllness() + "','" + pati.getPatientstatus() + "' , '" + pati.getMedecines() + "' , '" + pati.getdate() + "')");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (rowsInserted > 0) {
            System.out.println("A new patient was inserted successfully!");
        }

        return rowsInserted;
    }

    public static int insertdoctor(storeDoctor doct) throws SQLException {
        int rowsInserted = 0;
        Statement st;

        try {
            st = DataBase_Connection.getconnection().createStatement();
            rowsInserted = st.executeUpdate("insert into doctor (firstname,lastname,age,phonenumber, salary ,address) values ( '" + doct.getFirstname() + "','" + doct.getLastname() + "','" + doct.getAge() + "','" + doct.getPhonenumber() + "','" + doct.getSalary() + "' , '" + doct.getAddress() + "')");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (rowsInserted > 0) {
            System.out.println("A new doctor was inserted successfully!");
        }

        return rowsInserted;
    }

    public static int updatebill(Bill bill) {

        int rowsInserted = 0;
        Statement st;

        try {
            st = DataBase_Connection.getconnection().createStatement();
            rowsInserted = st.executeUpdate("update bill set name = '" + bill.getName() + "' , billnumber= '" + bill.getBillnumber()
                    + "' , billdate = '" + bill.getBilldate() + "' , billamount = '"
                    + bill.getBillamount() + "'   where id = '" + bill.getId() + "'    ");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowsInserted;
    }

    public static int updatepatientByDoctor(Patient pati) {

        int rowsInserted = 0;
        Statement st;

        try {
            st = DataBase_Connection.getconnection().createStatement();
            rowsInserted = st.executeUpdate("update patient set   illness = '" + pati.getIllness() + "' ,patientstatus = '" + pati.getPatientstatus()
                    + "' , medecines = '" + pati.getMedecines() + "'  where id = '" + pati.getId() + "'   ");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowsInserted;
    }

    public static int updatepatientByReceptionist(Patient pati) {

        int rowsInserted = 0;
        Statement st;

        try {
            st = DataBase_Connection.getconnection().createStatement();
            rowsInserted = st.executeUpdate("update patient set   firstname = '" + pati.getFirstname() + "' ,lastname= '" + pati.getLastname()
                    + "'  , age = '" + pati.getAge() + "' , date = '" + pati.getdate() + "'  where id = '" + pati.getId() + "'   ");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowsInserted;
    }

    public static int updatedoctor(storeDoctor doc) {

        int rowsInserted = 0;
        Statement st;

        try {
            st = DataBase_Connection.getconnection().createStatement();
            rowsInserted = st.executeUpdate("update doctor set   firstname = '" + doc.getFirstname() + "' ,lastname= '" + doc.getLastname()
                    + "'  , age = '" + doc.getAge() + "' , phonenumber = '" + doc.getPhonenumber() + "' , salary ='" + doc.getSalary() + "' , address = '" + doc.getAddress() + "' where doctorID = '" + doc.getId() + "'   ");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowsInserted;
    }

    public ObservableList<Bill> selectAllbills() {
        ObservableList<Bill> bills = FXCollections.observableArrayList();

        try {
            st = DataBase_Connection.getconnection().createStatement();
            ResultSet resultSet = st.executeQuery("select * from bill");
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Bill b = new Bill();
                b.setId(resultSet.getInt(1));
                b.setName(resultSet.getString(2));
                b.setBillnumber(resultSet.getInt(3));
                b.setBilldate(resultSet.getString(4));
                b.setBillamount(resultSet.getDouble(5));

                bills.add(b);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }

    public ObservableList<Patient> selectAllpatient() {
        ObservableList<Patient> patient = FXCollections.observableArrayList();

        try {
            st = DataBase_Connection.getconnection().createStatement();
            ResultSet resultSet = st.executeQuery("select * from patient ");
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Patient p = new Patient();
                p.setId(resultSet.getInt(1));
                p.setFirstname(resultSet.getString(2));
                p.setLastname(resultSet.getString(3));
                p.setAge(resultSet.getInt(4));
                p.setIllness(resultSet.getString(5));
                p.setPatientstatus(resultSet.getString(6));
                p.setMedecines(resultSet.getString(7));
                p.setdate(resultSet.getString(8));

                patient.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patient;
    }

    public ObservableList<storeDoctor> selectAlldoctor() {
        ObservableList<storeDoctor> doctor = FXCollections.observableArrayList();

        try {
            st = DataBase_Connection.getconnection().createStatement();
            ResultSet resultSet = st.executeQuery("select * from doctor ");
            resultSet.beforeFirst();
            while (resultSet.next()) {
                storeDoctor d = new storeDoctor();
                d.setId(resultSet.getInt(1));
                d.setFirstname(resultSet.getString(2));
                d.setLastname(resultSet.getString(3));
                d.setAge(resultSet.getInt(4));
                d.setPhonenumber(resultSet.getInt(5));
                d.setSalary(resultSet.getInt(6));
                d.setAddress(resultSet.getString(7));

                doctor.add(d);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctor;
    }

    public static void main(String[] args) {
        Operat p = new Operat();

    }

    public void deletebills(int id) {

        try {
            st = DataBase_Connection.getconnection().createStatement();
            st.executeUpdate("delete from bill where id=" + id + " ");
        } catch (SQLException ex) {
            Logger.getLogger(Operat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deletepatient(int id) {

        try {
            st = DataBase_Connection.getconnection().createStatement();
            st.executeUpdate("delete from patient where id=" + id + " ");
        } catch (SQLException ex) {
            Logger.getLogger(Operat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deletedoctor(int id) {

        try {
            st = DataBase_Connection.getconnection().createStatement();
            st.executeUpdate("delete from doctor where doctorID =" + id + " ");
        } catch (SQLException ex) {
            Logger.getLogger(Operat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<Bill> searchBill(String name) {
        ObservableList<Bill> bill = FXCollections.observableArrayList();

        try {
            st = DataBase_Connection.getconnection().createStatement();
            ResultSet resultSet = st.executeQuery("select * from bill where name = '" + name + "' or id = '" + name + "' ");
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Bill d = new Bill();
                d.setId(resultSet.getInt(1));
                d.setName(resultSet.getString(2));
                d.setBillnumber(resultSet.getInt(3));
                d.setBilldate(resultSet.getString(4));
                d.setBillamount(resultSet.getDouble(5));

                bill.add(d);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bill;
    }

    public ObservableList<Patient> searchpatient(String name) {
        ObservableList<Patient> patient = FXCollections.observableArrayList();

        try {
            st = DataBase_Connection.getconnection().createStatement();
            ResultSet resultSet = st.executeQuery("select * from patient where firstname = '" + name + "' or lastname = '" + name + "' or illness ='" + name + "' or id = '" + name + "'  ");
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Patient d = new Patient();

                d.setId(resultSet.getInt(1));
                d.setFirstname(resultSet.getString(2));
                d.setLastname(resultSet.getString(3));
                d.setAge(resultSet.getInt(4));
                d.setIllness(resultSet.getString(5));
                d.setPatientstatus(resultSet.getString(6));
                d.setMedecines(resultSet.getString(7));
                d.setdate(resultSet.getString(8));

                patient.add(d);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patient;
    }

    public ObservableList<storeDoctor> searchdoctor(String name) {
        ObservableList<storeDoctor> doctor = FXCollections.observableArrayList();

        try {
            st = DataBase_Connection.getconnection().createStatement();
            ResultSet resultSet = st.executeQuery("select * from doctor where firstname = '" + name + "' or lastname = '" + name + "' or salary ='" + name + "' or doctorID = '" + name + "'  ");
            resultSet.beforeFirst();

            while (resultSet.next()) {
                storeDoctor d = new storeDoctor();

                d.setId(resultSet.getInt(1));
                d.setFirstname(resultSet.getString(2));
                d.setLastname(resultSet.getString(3));
                d.setAge(resultSet.getInt(4));
                d.setPhonenumber(resultSet.getInt(5));
                d.setSalary(resultSet.getInt(6));
                d.setAddress(resultSet.getString(7));

                doctor.add(d);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctor;
    }

    public double sumsalary() {
        double value = 0.0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");

            PreparedStatement statement = (PreparedStatement) con.prepareStatement("select sum(salary) from doctor");
            ResultSet result = statement.executeQuery();
            result.next();
            String sum = result.getString(1);
            value = Double.parseDouble(sum);

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return value;
    }

    public double sumbills() {
        double value = 0.0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");

            PreparedStatement statement = (PreparedStatement) con.prepareStatement("select sum(billamount) from bill");
            ResultSet result = statement.executeQuery();
            result.next();
            String sum = result.getString(1);
            value = Double.parseDouble(sum);

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return value;
    }

    public int doctornum() {
        int num = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");

            PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from doctor ");
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                num++;
            }

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return num;
    }
    
    public int patientnum() {
        int num = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");

            PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from patient ");
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                num++;
            }

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return num;
    }
    
     public int billnum() {
        int num = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");

            PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from bill ");
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                num++;
            }

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return num;
    }
}
