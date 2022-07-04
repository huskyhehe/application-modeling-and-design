/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;
import info5100.university.example.College.College;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.CourseCatalog.*;
import info5100.university.example.CourseSchedule.*;


/**
 *
 * @author ZHOU
 */
public class Assignment4Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // Part 1
        // init Department
        Department architectureDept = new Department("the Department of Architecture");       

        
        // init Student
        PersonDirectory pd = architectureDept.getPersonDirectory();
        Person person00 = pd.newPerson("35000");
        Person person01 = pd.newPerson("35001");
        Person person02 = pd.newPerson("35002");
        Person person03 = pd.newPerson("35003");
        Person person04 = pd.newPerson("35004");
        Person person05 = pd.newPerson("35005");
        Person person06 = pd.newPerson("35006");
        Person person07 = pd.newPerson("35007");
        Person person08 = pd.newPerson("35008");
        Person person09 = pd.newPerson("35009");
                
        StudentDirectory sd = architectureDept.getStudentDirectory();        
        StudentProfile student00 = sd.newStudentProfile(person00);
        StudentProfile student01 = sd.newStudentProfile(person01);
        StudentProfile student02 = sd.newStudentProfile(person02);
        StudentProfile student03 = sd.newStudentProfile(person03);
        StudentProfile student04 = sd.newStudentProfile(person04);
        StudentProfile student05 = sd.newStudentProfile(person05);
        StudentProfile student06 = sd.newStudentProfile(person06);
        StudentProfile student07 = sd.newStudentProfile(person07);
        StudentProfile student08 = sd.newStudentProfile(person08);
        StudentProfile student09 = sd.newStudentProfile(person09);
        
        
        // init Course
        CourseCatalog cc = architectureDept.getCourseCatalog();
        Course arch5001 = cc.newCourse("History of Architecture", "arch 5001", 4);
        Course arch5002 = cc.newCourse("Site Design and Planning", "arch 5002", 4);
        Course arch5003 = cc.newCourse("Design Foundations", "arch 5003", 4);
        Course arch5004 = cc.newCourse("Architecture Lab", "arch 5004", 2);
        Course arch5005 = cc.newCourse("Urbanism Studies", "arch 5005", 2);
        
        
        // print the list of all students of the department
        architectureDept.printListOfAllStudents();
        
        // print the list of all courses of the department
        architectureDept.printGeneralCourseCatalog();

        
        
        // Part 2
        // init Fall 2021 Course Schedule 
        CourseSchedule csFall2021 = architectureDept.newCourseSchedule("Fall 2021");       
        CourseOffer arch5003Fall2021 = csFall2021.newCourseOffer("arch 5003");     
        arch5003Fall2021.generatSeats(60);
        CourseOffer arch5004Fall2021 = csFall2021.newCourseOffer("arch 5004");
        arch5004Fall2021.generatSeats(40);       
        CourseOffer arch5005Fall2021 = csFall2021.newCourseOffer("arch 5005");
        arch5005Fall2021.generatSeats(20);
       
        
        // print the fall 2021 semester course schedule of the department 
        // before students' registration
        architectureDept.printCourseScheduleBySemester("Fall 2021");
               
       
        // register the Students for the Courses
        student00.registerForCourse("Fall 2021", arch5003Fall2021);
        student01.registerForCourse("Fall 2021", arch5003Fall2021);
        student02.registerForCourse("Fall 2021", arch5003Fall2021);       
        student03.registerForCourse("Fall 2021", arch5003Fall2021);        
        student04.registerForCourse("Fall 2021", arch5004Fall2021);
        student05.registerForCourse("Fall 2021", arch5004Fall2021);
        student06.registerForCourse("Fall 2021", arch5004Fall2021);       
        student07.registerForCourse("Fall 2021", arch5005Fall2021);
        student08.registerForCourse("Fall 2021", arch5005Fall2021);
        student09.registerForCourse("Fall 2021", arch5005Fall2021);

             
        //print the list of registered student of a specific course
        architectureDept.printListOfStudentsByCourseOffer(arch5003Fall2021);
        architectureDept.printListOfStudentsByCourseOffer(arch5004Fall2021);
        architectureDept.printListOfStudentsByCourseOffer(arch5005Fall2021);      

        // print the fall 2021 semester course schedule of the department 
        // after students' registration
        architectureDept.printCourseScheduleBySemester("Fall 2021");
        
        
        
        // Part 3
        // init College and new Department
        College designCo = new College("College of Design");
        Department urbanPlanningDept = designCo.newDepartment("the Department of Urban Planning");  
        designCo.addDepartment(architectureDept);
        
        // init Course of the urbanPlanning
        CourseCatalog cc_2 = urbanPlanningDept.getCourseCatalog();
        Course urbp6001 = cc_2.newCourse("The Urban Form", "urbp 6001", 2);
        Course urbp6002 = cc_2.newCourse("Planning Studio Prep", "urbp 6002", 2);
        Course urbp6003 = cc_2.newCourse("Survey of Urban Planning", "urbp 6003", 2);
        
        
        // init Fall 2021 Course Schedule 
        CourseSchedule csFall2021_2 = urbanPlanningDept.newCourseSchedule("Fall 2021");       
        CourseOffer urbp6001Fall2021 = csFall2021_2.newCourseOffer("urbp 6001");     
        urbp6001Fall2021.generatSeats(30);
        CourseOffer urbp6002Fall2021 = csFall2021_2.newCourseOffer("urbp 6002");
        urbp6002Fall2021.generatSeats(30);       
        CourseOffer urbp6003Fall2021 = csFall2021_2.newCourseOffer("urbp 6003");
        urbp6003Fall2021.generatSeats(10);
        
        
        // print the fall 2021 semester course schedule of the department 
        // after students' registration
        urbanPlanningDept.printCourseScheduleBySemester("Fall 2021");       
        
        // register the Students for the Courses
        student04.registerForCourse("Fall 2021", urbp6001Fall2021);
        student05.registerForCourse("Fall 2021", urbp6001Fall2021);
        student06.registerForCourse("Fall 2021", urbp6002Fall2021);       
        student07.registerForCourse("Fall 2021", urbp6002Fall2021);
        student08.registerForCourse("Fall 2021", urbp6003Fall2021);
        student09.registerForCourse("Fall 2021", urbp6003Fall2021);
        
        //print the list of registered student of a specific course
        urbanPlanningDept.printListOfStudentsByCourseOffer(urbp6001Fall2021);
        urbanPlanningDept.printListOfStudentsByCourseOffer(urbp6002Fall2021);
        urbanPlanningDept.printListOfStudentsByCourseOffer(urbp6003Fall2021);           
        
        // print the fall 2021 semester course schedule of the department 
        // after students' registration
        urbanPlanningDept.printCourseScheduleBySemester("Fall 2021");
        
        
        // calculate the college's total revenue of the fall 2021 semester
        designCo.printTotalRevenuesBySemester("Fall 2021");       
           
    }   
}
