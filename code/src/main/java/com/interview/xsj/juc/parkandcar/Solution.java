package com.interview.xsj.juc.parkandcar;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 *
 * 场景题，一个停车场，要对所停车辆进行收费。
 * 写了两个类，一个Car，一个Park，Park里有个Set存Car表示停车场停了哪些车，
 * 一个最大容量。车一进停车场就记录时间，然后出停车场计算时间差进行收费。
 * @author xsj
 * @create 2021-05-15 17:25
 */
public class Solution {
    class Car{
        private Date date;
        public void setDate(Date date){
            this.date=date;
        }
        public Date getDate(){
            return date;
        }
    }

    class Park{
        Semaphore capacity;
        Set<Car> set;
        private int hourPrice;
        public Park(int size,int hourPrice){
            this.capacity=new Semaphore(size,true);
            this.hourPrice=hourPrice;
        }

        public boolean in(Car car){
            if(capacity.tryAcquire(1)){
                set.add(car);
                car.setDate(new Date());
                return true;
            }
            return false;
        }

        public double out(Car car){
            if(!set.contains(car)){
                return 0.0;
            }
            set.remove(car);
            return (new Date().getTime()-car.getDate().getTime())/3600.0*hourPrice;
        }
    }
}
