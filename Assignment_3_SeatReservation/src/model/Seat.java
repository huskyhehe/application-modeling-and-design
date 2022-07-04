/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ZHOU
 */
public class Seat {
     
    private String seatNo;
    private String location;
    private int status;

    /**
     * Constructor to create a new seat
     * @param seatNo the seat number
     */
    public Seat(String seatNo) {
        this.seatNo = seatNo;
    }
    
    
    // getters and setters
    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
        
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
        public String getLocation() {
        return location;
    }

    /**
     * Method to set the seat's location: window, aisle or neither
     * @param seatNo the seat number
     */
    public void setLocation(String seatNo) {
        if ((seatNo.endsWith("F")) || seatNo.endsWith("A")) {
            this.location = "window";            
        }
        if ((seatNo.endsWith("C")) || seatNo.endsWith("D")) {
            this.location = "aisle";
        } 
    }   
}
