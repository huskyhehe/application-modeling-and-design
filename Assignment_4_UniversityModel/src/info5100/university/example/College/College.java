/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.College;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class College {
    String name;
    ArrayList<Department> departmentList;

    
    public College(String name) {
        this.name = name;
        departmentList = new ArrayList();
    }
    
    
    public Department newDepartment(String deptName) {
        Department dept = new Department(deptName);
        departmentList.add(dept);
        return dept;
    } 
    
    public void addDepartment(Department dept) {
        this.departmentList.add(dept);
    }
    
    
    public int calculateTotalRevenuesBySemester(String semester) {
        int sum = 0;
        for (Department dept : departmentList) {
            sum += dept.calculateRevenuesBySemester(semester);
        }
        return sum;
    }
    
    
    public void printTotalRevenuesBySemester(String semester) {
        System.out.println("---------- " + semester + " " + this.name + " Total Revenues " + "----------" );
        for (Department dept : departmentList) {
            dept.printRevenuesBySemester(semester);
        }
        int sum = this.calculateTotalRevenuesBySemester(semester);
        System.out.println("*** Sum:" + sum);
    }
}
