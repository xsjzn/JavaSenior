package com.aituigu.exer;

/**
 * @author xsj
 * @create 2020-09-21 16:07
 */
public class MyDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
    //按生日日期的先后排序。
    @Override
    public int compareTo(Object o) {
        if(o instanceof MyDate){
            MyDate myDate=(MyDate)o;
            int minusYear=this.getYear()-myDate.getYear();
            if(minusYear!=0){
                return minusYear;
            }
            int minsMonth=this.getMonth()-myDate.getMonth();
            if(minsMonth!=0){
                return minsMonth;
            }
            return this.getDay()-myDate.getDay();

        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
