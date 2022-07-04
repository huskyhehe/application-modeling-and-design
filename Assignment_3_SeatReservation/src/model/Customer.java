/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ZHOU
 */
public class Customer {
    
    private String customerName;
    private String customerId;

    
    /**
     * Construtor to create a new customer
     * @param customerName the name of the customer
     */    
    public Customer(String customerName) {     
        this.customerName = customerName;
    }

    //getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
        
    /**
     * Method to make a reservation with a randomly assigned seat
     * @param theFlight the flight that the customer choose
     */
    public void makeReservation(Flight theFlight) {
        System.out.println("=========================== RESERVATION DETAILS ============================");
        SeatReservation theReservation = new SeatReservation();
        ArrayList<Seat> subSeats = new ArrayList<Seat>();        
        for (Seat s: theFlight.getSeatList()) {
            if (s.getStatus() == 0) {
                subSeats.add(s);
            }
        }
        boolean result = subSeats.isEmpty();        
        if (result == false) {
            int i = (int)(Math.random() * subSeats.size());
            theReservation.setSeat(subSeats.get(i));
            theReservation.setCustomer(this);
            theReservation.getSeat().setStatus(1); 
            theFlight.addNewReservation(theReservation); 
            System.out.println("Successful Reservation!");
            theReservation.showReservationInfo();
        }else {
            System.out.println("No Seats Avaiable.\n");  
        }
    }
    
    
    /**
     * Method to make a reservation by selecting the location of seats
     * @param theFlight
     * @param theLocation 
     */
    public void makeReservation(Flight theFlight, String theLocation) {
        System.out.println("=========================== RESERVATION DETAILS ============================");
        SeatReservation theReservation = new SeatReservation();
        ArrayList<Seat> subSeats = new ArrayList<Seat>();        
        for (Seat s: theFlight.getSeatList()) {
            if ((s.getStatus() == 0) && (s.getLocation() == theLocation)) {
                subSeats.add(s);
            }
        }
        boolean result = subSeats.isEmpty();
        if (result == false) {
            int i = (int)(Math.random() * subSeats.size());
            theReservation.setSeat(subSeats.get(i));
            theReservation.setCustomer(this);
            theReservation.getSeat().setStatus(1); 
            theFlight.addNewReservation(theReservation); 
            System.out.println("* Successful Reservation!");
            theReservation.showReservationInfo();
        }else {
            System.out.println("* No " + theLocation + " Seats Avaiable.\n");  
        }    
    }
    
        
    /**
     * Method to make a reservation by selecting seat number
     * @param theFlight
     * @param theSeat 
     */
    public void makeReservation(Flight theFlight, Seat theSeat) {
        System.out.println("=========================== RESERVATION DETAILS ============================");
        if (theSeat.getStatus() == 0) {
            SeatReservation theReservation = new SeatReservation();       
            theReservation.setSeat(theSeat);        
            theReservation.setCustomer(this);
            theReservation.getSeat().setStatus(1);
            theFlight.addNewReservation(theReservation); 
            System.out.println("* Successful Reservaiton!");
            theReservation.showReservationInfo();
        } else {
            System.out.println("* Seat " + theSeat.getSeatNo() + " Unavailable.\n");
        }  
    }   
}
