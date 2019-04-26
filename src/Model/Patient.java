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
public class Patient {

    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String illness;
    private String patientstatus;
    private String date ;
    private String medecines ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getPatientstatus() {
        return patientstatus;
    }

    public void setPatientstatus(String patientstatus) {
        this.patientstatus = patientstatus;
    }

    /**
     * @return the dateOfExamination
     */
    public String getdate() {
        return date;
    }

    /**
     * @param dateOfExamination the dateOfExamination to set
     */
    public void setdate(String date) {
        this.date = date;
    }
    /**
     * @return the medecines
     */
    public String getMedecines() {
        return medecines;
    }

    /**
     * @param medecines the medecines to set
     */
    public void setMedecines(String medecines) {
        this.medecines = medecines;
    }

}
