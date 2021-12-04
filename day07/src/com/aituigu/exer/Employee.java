package com.aituigu.exer;

/**
 * @author xsj
 * @create 2020-09-21 16:28
 */
public class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday.toString() +
                '}';
    }
    //按照name从大到小
    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee employee=(Employee)o;
            return -this.name.compareTo(employee.name);
        }
        throw new RuntimeException("传入的类型错误") ;
    }
}
