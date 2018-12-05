/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author hetashavi
 */
public class Employee {
    
    private String fname;
    private String lname;
    private int id;
    private static int count = 1;

    public Employee() {
        id = count;
        count++;
    }

     public enum Type{
        Doctor("Doctor"); 
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return fname;
    }
    
}
