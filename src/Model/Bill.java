/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mohamed
 */
public class Bill {

    
    private int id ; 
    private String name;
    private int billnumber;
    private String billdate;
    private double billamount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBillnumber() {
        return billnumber;
    }

    public void setBillnumber(int billnumber) {
        this.billnumber = billnumber;
    }

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    public double getBillamount() {
        return billamount;
    }

    public void setBillamount(double billamount) {
        this.billamount = billamount;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


}