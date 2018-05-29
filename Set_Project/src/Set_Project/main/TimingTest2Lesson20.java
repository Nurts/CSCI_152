/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.main;

import Set_Project.adt.HashTableSet;
import Set_Project.impl.BSTHashTableSet;
import Set_Project.impl.LLQHashTableSet;
import java.util.Random;

/**
 *
 * @author Nurtas
 */
public class TimingTest2Lesson20 {
    public static void main(String[] args) {
        /* The answers to the questions are below the code
    LLQHashTableSet
        For 10 buckets till 50000
            1st run: 1292 ms, stdDev: 66.051, Load Factor: 5000.0
            2nd run: 1363 ms, stdDev: 88.964, Load Factor: 5000.0
            3rd run: 1300 ms, stdDev: 63.669, Load Factor: 5000.0
            Average: 1318.3 ms, stdDev: 72.89
            Load Factor average: 5000.0
           
        For 100 buckets till 50000
            1st run: 220 ms, stdDev: 19.85, Load Factor: 500.0
            2nd run: 225 ms, stdDev: 22.49, Load Factor: 500.0
            3rd run: 220 ms, stdDev: 22.50, Load Factor: 500.0
            Average: 221.7 ms, stdDev: 21.6134
            Load Factor average: 500.0
        
        For 5000 buckets till 50000
            1st run: 26 ms, stdDev: 3.16, Load Factor: 10.0
            2nd run: 24 ms, stdDev: 3.18, Load Factor: 10.0
            3rd run: 19 ms, stdDev: 3.13, Laod Factor: 10.0
            Average: 23 ms, stdDev: 3.16
            Load Factor average: 10.0
        
    BSTHashTableSet
        For 10 buckets
            1st run: 23 ms, stdDev: 35.83, Load Factor: 5000.0
            2nd run: 24 ms, stdDev: 76.28, Load Factor: 5000.0
            3rd run: 22 ms, stdDev: 40.8, Load Factor: 5000.0
            Average: 23 ms, stdDev: 50.97
            Load Factor average: 5000.0
        
        For 100 Buckets
            1st run: 21 ms, stdDev: 21.60, Load Factor: 500.0
            2nd run: 20 ms, stdDev: 20.47, Load Factor: 500.0
            3rd run: 21 ms, stdDev: 23.68, Laod Factor: 500.0
            Average: 20.67 ms, stdDev: 21.92
            Load Factor average: 500.0
        
        For 5000 buckets
            1st run: 18 ms, stdDev: 3.135, Load Factor: 10.0
            2nd run: 14 ms, stdDev: 3.135, Load Factor: 10.0
            3rd run: 15 ms, stdDev: 3.21, Laod Factor: 10.0
            Average: 15.67 ms, stdDev: 3.16
            Load Factor average: 10.0
        */
     
        HashTableSet<Integer> set = new BSTHashTableSet(5000);

        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();
        Random a = new Random(); 
        for (int i = 0; i < 50000; i++) {
            set.add(a.nextInt());
        }
        time2 = System.currentTimeMillis();
        duration = time2 - time1;

        System.out.println("Time taken in ms: " + duration);
        System.out.println("The load factor: " + set.getLoadFactor());
        System.out.println("The StdDev: " + set.getBucketSizeStandardDev());
        
        /*
        Questions:
            1. The difference is between BSTHashTableSet implementations, and
               between standard deviations 
        
            2. Because the number of buckets and the number of elements are same for two 
               test cases. Random number generator gave unique 50000 elements in this test.
        
            3. Because the Random generator gave unique 50000 elements, and the elements were
               distributed less evenly compared to first test, however, it is not
               huge to make significant effect to the working time.
        
            4  a) Because if the tree will be balanced and the elements were evenly distributed
                  among buckets, the the time complexity of one add method is O(log(N/K)).
                  While LLQHashTableSet works for O(N/K);
               b) Because, the integers are not in order therefore the BST will be more balanced
               than in the first test. Since the BST is more balanced, it works much faster
        */
    }

}
