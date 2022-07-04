/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.*;


/**
 *
 * @author ZHOU
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            
        
        // init Flight
        Flight qr719 = new Flight("QR719", "Hong Kong", "Seattle", "2021-10-01 07:50", "2021-10-02 11:55");
 
        // init Seat and add them to the flight's seat list
        Seat eco27A = qr719.addNewSeat("27A");
        Seat eco27B = qr719.addNewSeat("27B");
        Seat eco27C = qr719.addNewSeat("27C");
        Seat eco27D = qr719.addNewSeat("27D");
        Seat eco27E = qr719.addNewSeat("27E");
        Seat eco27F = qr719.addNewSeat("27F");
        
        // show the flight's information
        qr719.showFlightInfo();
        
        // show available seats (before reservations are made)
        qr719.showAvailableSeats();
        
             
        // init Customer       
        Customer hee = new Customer("He Zhou");
        Customer archil = new Customer("Archil Lelashvili");
        Customer kal = new Customer("Kal Bugrara");
        
        
        
        // hee makes a reservation of qr719 by selecting a seat number
        hee.makeReservation(qr719, eco27B);
        
        // archil makes two reservations of qr719 by selecting the location of seats
        archil.makeReservation(qr719, "window");
        archil.makeReservation(qr719, "aisle");
        
        // kal makes a reservation of qr719 by default, with a seat assigned randomly
        kal.makeReservation(qr719);
        
 
        
        
        // show all reservation records (for admin use)
        qr719.showReservationList();
        
        // show available seats (after reservations are made)
        qr719.showAvailableSeats();
    }    
}