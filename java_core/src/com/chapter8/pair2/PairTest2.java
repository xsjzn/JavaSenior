package com.chapter8.pair2;

import java.time.LocalDate;

/**
 * @author xsj
 * @create 2020-10-28 11:16
 */

    public class PairTest2 {
        public static void main(String[] args) {
            LocalDate[] birthday={
                    LocalDate.of(1906,12,9),
                    LocalDate.of(1290,12,3),
                    LocalDate.of(1903,2,7),
                    LocalDate.of(1905,4,12),

            };
            ArrayAlg.Pair<LocalDate> mm=ArrayAlg.minmax(birthday);
            System.out.println("" +
                    "min=" +mm.getFirst());
            System.out.println("max=" +mm.getSecond());
        }
    }

