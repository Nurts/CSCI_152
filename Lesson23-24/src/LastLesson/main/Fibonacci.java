package LastLesson.main;

import LastLesson.adt.Map;
import LastLesson.impl.LLQHashTableMap;



public class Fibonacci {

	/////////////////////////
	// Version One
	/////////////////////////
	
	private static int callCount1;
	
	public static long fibCalc1(int n) {
		callCount1++;
		if(n < 2)return n;
                return fibCalc1(n-1) +fibCalc1(n-2);
	}
	
	
	public static void testFibCalc1(int n) {
		callCount1 = 0;
		System.out.println("fibCalc1("+n+") = " + fibCalc1(n) +
				"; takes " + callCount1 + " calls.");
	}
	
	/////////////////////////
	// Version Two
	/////////////////////////
	
	private static int callCount2;
	private static Map<Integer, Long> ansMap = new LLQHashTableMap(10);
	
	public static long fibCalc2(int n) {
                callCount2++;
                if(n < 2)return n;
                Long val = ansMap.getValue(n);
                if(val == null){
                    val = fibCalc2(n-1) + fibCalc2(n-2);
                    ansMap.define(n, val);
                }
                return val;
	}
	
	
	public static void testFibCalc2(int n) {
		callCount2 = 0;
                //ansMap.clear();
		System.out.println("fibCalc2("+n+") = " + fibCalc2(n) +
				"; takes " + callCount2 + " calls.");
	}
	
	///////////
	
	public static void main(String[] args) {
		
		for (int x = 0; x < 30; x++) {
			testFibCalc1(x); //CallCount(n) = CallCount(n-1) + CallCount(n-2) + 1
		}
		
		for (int x = 0; x < 30; x++) {
			testFibCalc2(x);
		}
		
	}
}
