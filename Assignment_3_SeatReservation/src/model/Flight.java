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
public class Flight {
    
    private String flightNo;
    private String source;
    private String destination;   
    private String departureTime;
    private String arrivalTime;
    ArrayList<Seat> seatList;
    ArrayList<SeatReservation> seatReservationList;

    
    /**
     * Constructor to create a new flight
     * @param flightNo      the flight number
     * @param source        the origin 
     * @param destination   the distination
     * @param departureTime the departure time
     * @param arrivalTime   the arrival time
     */
    public Flight(String flightNo, String source, String destination, String departureTime, String arrivalTime) {
        this.flightNo = flightNo;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatList = new ArrayList<Seat>();
        this.seatReservationList = new ArrayList<SeatReservation>();
    }

    // getters and setters
    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    public ArrayList<SeatReservation> getSeatReservationList() {
        return seatReservationList;
    }

    public void setSeatReservationList(ArrayList<SeatReservation> seatReservationList) {
        this.seatReservationList = seatReservationList;
    }
    
    
    /**
     * Method to add a seat to the flight's seat list
     * @param   seatNo 
     * @return  a new seat 
     */
    public Seat addNewSeat(String seatNo) {
        Seat newSeat = new Seat(seatNo);
        newSeat.setLocation(seatNo);
        this.seatList.add(newSeat);
        return newSeat;
    }
    
    
    /**
     * Method to add a reservation record to the flight's reservation list
     * @param   newReservation 
     * @return  a new reservation record 
     */
    public SeatReservation addNewReservation(SeatReservation newReservation) {
        this.seatReservationList.add(newReservation);       
        return newReservation;
    }
    
    
    /**
     * Method to print the flight information
     */
    public void showFlightInfo() {
        System.out.println("============================ FLIGHT INFORMATION ============================");
        System.out.println( "* Flight No: " + flightNo +
                            "\n| From: " + source + 
                            "                     | To: " + destination +
                            "\n| Departure Time: " + departureTime +
                            "    | Arrival Time: " + arrivalTime + "\n"); 
    }
        
    
    /**
     * Method to print available seats' numbers of the flight
     */
    public void showAvailableSeats() {
        System.out.println("============================= AVAILABLE SEATS ==============================");
        System.out.print("| ");
        ArrayList<Seat> subSeats = new ArrayList<Seat>();
        for (Seat s: seatList) {
            if (s.getStatus() == 0) {
                subSeats.add(s);
            }
        }
        boolean result = subSeats.isEmpty();
        if (result == false) {
            for (Seat s: subSeats) {
                if (s.getLocation() == null) {
                    System.out.printf("<%s> | ", s.getSeatNo());
                }else {
                    System.out.printf("<%s-%s> | ",s.getSeatNo(), s.getLocation());
                }
            }
        }
        System.out.println("\n");
    }
    
    
    /**
     * Method to print reservation records of the flight for admin use
     */
    public void showReservationList() {
        System.out.println("****** RESERVATION RECORDS ******");
        for (SeatReservation r : seatReservationList) {
            System.out.printf("| %s, %s\n", r.getSeat().getSeatNo(), r.getCustomer().getCustomerName());           
        }
        System.out.println();
    }
}