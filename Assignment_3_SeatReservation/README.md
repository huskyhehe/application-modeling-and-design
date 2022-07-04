# Assignment 3 – Seat Reservation – Deadline 10/13/21

 

## Background

You are part of a software engineering team that builds a software application for an airline. This software has multiple interconnected components, and each team member works on different pieces.

 

## Your tasks

You are given a task to build components for flight seat reservations based on the following requirements:

- Create a `Flight` component, with attributes (source, destination, flight number, departure time, arrival time, a list of Seats).
- Create a `Seat` component that has a relationship to Flight Each Seat component has a seat number and should ‘know’ whether it is available or booked.
- Create `SeatReservation` component, that has a relationship to Seat. SeatReservation makes the Seat component unavailable for further bookings. SeatReservation stores information about the Customer who made the reservation.
- Add methods for the Flight component to find an available seat and make a reservation.
- Add another method for reservation that can book an available aisle or window seat.
 

## Note

Once you build your classes, add code in the main method to create a Flight, add available Seats, make several reservations. You should print the information to console.