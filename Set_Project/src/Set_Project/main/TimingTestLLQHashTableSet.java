/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.main;

import Set_Project.adt.Set;
import Set_Project.impl.LLQHashTableSet;

/**
 *
 * @author Nurtas
 */
public class TimingTestLLQHashTableSet {
    public static void main(String[] args) {
        /*
        For 10 buckets till 500000
            1st run: 471774 ms
            2nd run: 466510 ms
            3rd run: 470879 ms
            Average:`469721 ms
        For 100 buckets till 500000
            1st run: 10295 ms
            2nd run: 10369 ms
            3rd run: 10970 ms
            Average: 10545 ms
        For 100 buckets till 5000
            1st run: 0 ms
            2nd run: 0 ms
            3rd run: 0 ms
            Average: 0 ms
        */
     
        Set<Integer> set = new LLQHashTableSet(100);

        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();
     
        for (int i = 0; i < 5000; i++) {
            set.add(i);
        }
   
        time2 = System.currentTimeMillis();
        duration = time2 - time1;

        System.out.println("Time taken in ms: " + duration);
    }

}
