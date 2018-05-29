/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.main;

import ADT_Project.adt.Stack;
import ADT_Project.impl.LinkedListStack;

/**
 *
 * @author Nurtas
 */
public class IsIncreasing {
    public static boolean isIncreasing (Stack<Double> st) throws Exception{
        boolean ans = true, islast = true;
        double prev = 0.0;
        Stack<Double> temp = new LinkedListStack();
        
        while(st.getSize()>0){
            double top = st.pop();
            if(islast)islast = false;
            else if(prev < top) ans = false;
            prev = top;
            temp.push(top);
        }
        
        while(temp.getSize()>0){
            st.push(temp.pop());
        }
        return ans;
    }
    
    public static void main(String args[]){
        double inc = 0.0;
        Stack<Double> stk = new LinkedListStack();
        for(int i=0;i<10;i++){
            inc += 0.5;
            stk.push(inc);
            
        }
        stk.push(inc);
        try{
            System.out.println(stk + "\nIs increasing : " + isIncreasing(stk));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
