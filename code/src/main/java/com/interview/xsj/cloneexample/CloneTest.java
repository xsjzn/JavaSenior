package com.interview.xsj.cloneexample;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author xsj
 * @create 2021-07-13 17:31
 */
public class CloneTest {
    public static void main(String[] args) {
        try{
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}

class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;
    public Employee(String n, double s)
    {
        name = n;
        salary = s;
        hireDay = new Date();
    }

    public Employee clone()throws CloneNotSupportedException{
        Employee cloned=(Employee)super.clone();

        cloned.hireDay=(Date)hireDay.clone();
        return cloned;
    }

    /**
     * Set the hire day to a given date.
     * @param year the year of the hire day
     * @param month the month of the hire day
     * @param day the day of the hire day
     */
    public void setHireDay(int year, int month, int day)
    {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        // Example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString()
    {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}