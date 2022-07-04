/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
    }
    
    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassignment = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {

            seatlist.add(new Seat(this, i));

        }

    }

    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }


    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    
    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }
    public Course getSubjectCourse(){
        return course;
    }
    public int getCreditHours(){
        return course.getCredits();
    }
    
    
    public int seatsCapacity() {
        return seatlist.size();
    }
    
    public int seatsOcupiedCount() {
        int ocupiedCount = 0;
        for (Seat s : seatlist) {
            if (s.occupied) {
                ocupiedCount ++;
            }
        }
        return ocupiedCount;
    }
    
    
    public int seatsRemainingCount() {
        int remainingCount = this.seatsCapacity() - this.seatsOcupiedCount();
        return remainingCount;
    }
    
    public void printStatusOfSeats() {
        System.out.println(this.seatsRemainingCount() + " of " 
                + this.seatsCapacity() + " seats remain");     
    }
    
    public void printCourseOffer() {
        course.printCourseDetails();
        System.out.print(" | ");
        this.printStatusOfSeats();
    }

    public void printListOfStudents() {
        int i = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
            s.seatassignment.printStudentProfile();
            i++;
            }
        }
        if (i == 0) {
            System.out.println("None");
        }
    }
}
