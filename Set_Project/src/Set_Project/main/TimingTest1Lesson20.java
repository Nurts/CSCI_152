/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.main;

import Set_Project.adt.HashTableSet;
import Set_Project.impl.BSTHashTableSet;
import Set_Project.impl.LLQHashTableSet;

/**
 *
 * @author Nurtas
 */
public class TimingTest1Lesson20 {
    public static void main(String[] args) {
        /* The answers to the questions are below
    LLQHashTableSet
        For 10 buckets till 50000
            1st run: 1349 ms
            2nd run: 1367 ms
            3rd run: 1284 ms
            Average: 1333.34 ms
            Load Factor: 5000.0
            StdDev: 0.0
        
        For 100 buckets till 50000
            1st run: 168 ms
            2nd run: 153 ms
            3rd run: 137 ms
            Average: 152.67
            Load Factor: 500.0
            StdDev: 0.0
        
        For 50000 buckets till 50000
            1st run: 5 ms
            2nd run: 12 ms
            3rd run: 17 ms
            Average: 11.34 ms
            Load Factor: 10.0
            StdDev: 0.0
        
    BSTHashTableSet
        For 10 buckets
            1st run: 1206 ms
            2nd run: 1456 ms
            3rd run: 1313 ms
            Average: 1325 ms
            Load Factor: 5000.0
            StdDev: 0.0
        
        For 100 Buckets
            1st run: 156 ms
            2nd run: 139 ms
            3rd run: 161 ms
            Average: 152 ms
            Load Factor: 500.0
            StdDev: 0.0
        
        For 5000 buckets
            1st run: 10 ms
            2nd run: 4 ms
            3rd run: 8 ms
            Average: 7.34 ms
            Load Factor: 10.0
            StdDev: 0.0
        */
     
        HashTableSet<Integer> set = new BSTHashTableSet(10);

        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();
     
        for (int i = 0; i < 50000; i++) {
            set.add(i);
        }
   
        time2 = System.currentTimeMillis();
        duration = time2 - time1;

        System.out.println("Time taken in ms: " + duration);
        System.out.println("The load factor: " + set.getLoadFactor());
        System.out.println("The StdDev: " + set.getBucketSizeStandardDev());
        
        /*
        Questions:
            1. No surprises.
            
            2. Because, the number of elements are the same for all and
               and the load factor is (number of elements)/(number of buckets)
        
            3. StdDev is zero for all cases because, all the elements were evenly
               distributed. Every bucket have N/K elements.
               
            4. Because, the BSTs in the buckets are similar to the linked lists. Therefore,
               it is similar to the linked list queue. Because the elements were added in
               incresing order, all elements always went to the right side of the tree.
        */
    }

}
