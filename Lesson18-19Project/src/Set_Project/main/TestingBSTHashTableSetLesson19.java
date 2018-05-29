/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.main;

import Set_Project.adt.HashTableSet;
import Set_Project.impl.BSTHashTableSet;
import Set_Project.impl.Student;

/**
 *
 * @author Nurtas
 */
public class TestingBSTHashTableSetLesson19 {
    public static void main(String[] args){
        /*
        1st test: (when hashcode is 42 and 10 buckets)
            Load Factor: 20.0
            StdDev: 56.92099788303083
        2nd test: (when hashcode is 42 and 100 buckets)
            Load Factor: 2.0
            StdDev: 19.8
        3rd test: (when hashcode is ID and 10 buckets)
            Load Factor: 20.0
            StdDev: 0.0
        4th test: (when hashcode is ID and 100 buckets)
            Load Factor: 2.0
            StdDev: 0.0
        
        Because The Number of buckets and the used hashcodes are the same for two implementations
        Load Factor and StdDev depends only on hashcodes and on the number of buckets
        */
        HashTableSet<Student> set = new BSTHashTableSet(100);
        for(int i=100;i<300;i++){
            set.add(new Student(i,"Bob"));
        }
        
        System.out.println("Load Factor: " + set.getLoadFactor());
        System.out.println("StdDev: " + set.getBucketSizeStandardDev());
    }
}
