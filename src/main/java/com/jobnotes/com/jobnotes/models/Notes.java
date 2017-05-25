package com.jobnotes.com.jobnotes.models;

/**
 * Created by edwardbenzenberg on 5/17/17.
 */
import java.util.Date;

/**
 * @author edwardbenzenberg
 *
 */


public class Notes {

    int id;
    String jobName;
    String note;
    String dateAdded;
    Date dateFinished;
    String status;

    public Notes(){

    }

    public Notes(String note, int id){
        this.note = note;
        this.id = id;

    }

    public Notes(int id,String jobName, String note, String dateAdded, String status) {
        this.id = id;
        this.jobName = jobName;
        this.note = note;
        this.dateAdded = dateAdded;
        this.dateFinished = dateFinished;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter method for jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * setter method for jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * getter method for note
     */
    public String getNote() {
        return note;
    }

    /**
     * setter method for note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * getter method for dateAdded
     */
    public String getDateAdded() {

        return dateAdded;
    }

    /**
     * setter method for dateAdded
     */
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * getter method for dateFinished
     */
    public Date getDateFinished() {
        return dateFinished;
    }

    /**
     * setter method for dateFinished
     */
    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    /**
     * getter method for finished
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter method for finished
     */
    public void setstatus(String status) {
        this.status = status;
    }




}
