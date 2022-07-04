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
public class SeatReservation {
    
    private String serialNo;
    private Customer customer;
    private Seat seat;

    
    //getters and setters
    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
    
    /**
     * Method to print the reservation details
     */
    public void showReservationInfo() {
        System.out.println("| Customer Name: " + customer.getCustomerName());
        if (seat.getLocation() == null) {
            System.out.println("| Seat Number: " + seat.getSeatNo() + "\n");
        }else {
            System.out.println("| Seat Number: " + seat.getSeatNo() + "-" + seat.getLocation() + "\n");
        }                           
    }
}