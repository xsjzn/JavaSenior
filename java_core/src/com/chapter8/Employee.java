package com.chapter8;

/**
 * @author xsj
 * @create 2020-10-28 14:55
 */
public class Employee {
    private double bonus;
    private String name;

    public Employee() {
    }

    public Employee(String name,double bonus) {
        this.bonus = bonus;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
