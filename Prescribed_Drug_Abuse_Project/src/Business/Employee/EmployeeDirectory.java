/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author hetashavi
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String fname){
        Employee employee = new Employee();
        employee.setFname(fname);
        employeeList.add(employee);
        return employee;
    }
    
    public boolean checkIfEmployeeIsUnique(String name){
        for (Employee emp : employeeList){
            if (emp.getFname().equalsIgnoreCase(name))
                return false;
        }
        return true;
    }
    
}
