/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.main;

import ADT_Project.adt.Queue;
import ADT_Project.adt.Stack;
import ADT_Project.impl.LinkedListQueue;
import ADT_Project.impl.LinkedListStack;

/**
 *
 * @author Nurtas
 */
public class MethodsLesson11 {
    public static boolean isBalanced(Queue<Character> q) throws Exception{
        Stack<Character> st = new LinkedListStack();
        boolean ans = true,ex = false;
        for(int i=0;i<q.getSize();i++){
            char next = q.dequeue();
            q.enqueue(next);
            if(next == '{' || next == '(' || next == '[')st.push(next);
            else if(next == '}' && ( st.getSize()==0 || st.pop() != '{') )ans = false;
            else if(next == ']' && ( st.getSize()==0 || st.pop() != '[') )ans = false;
            else if(next == ')' && ( st.getSize()==0 || st.pop() != '(') )ans = false;
            else if(next != '}' && next != ']' && next != ')')ex = true;
        }
        if(ex)throw new Exception("Invalid Character in the queue");
        if(st.getSize() !=0 )ans = false;
        return ans;
    }
    
    public static boolean isPalindrome(Queue<Character> q) throws Exception{
        Stack<Character> st = new LinkedListStack();
        boolean ans =true;
        for(int i=0;i<q.getSize();i++){
            char next = q.dequeue();
            q.enqueue(next);
            if(i<q.getSize()/2)st.push(next);
            else if(i>=(q.getSize()/2)+(q.getSize()%2) && (st.getSize() == 0 || next != st.pop()))ans = false;
            
        }
        return ans;
    }
    
    public static boolean check (String s , int type) throws Exception{
        Queue<Character> q = new LinkedListQueue();
        for(int i=0;i<s.length();i++){
            q.enqueue(s.charAt(i));
        }
        if(type == 1)return isBalanced(q);
        else return isPalindrome(q);
    }
    public static void main(String args[]) throws Exception{
        String s = new String();
        try{
            s = "([)]";
            System.out.println(s + " - Is Balanced: " + check(s,1));
            s = "[{}]([][])";
            System.out.println(s + " - Is Balanced: " + check(s,1));
            s = "([{]})";
            System.out.println(s + " - Is Balanced: " + check(s,1));
            s = "([{]})!";
            System.out.println(s + " - Is Balanced: " + check(s,1));
        }catch (Exception ex){
            System.out.println(s + " - " + ex.getMessage());
        }
        
        try{
            
            s = "abacaba";
            System.out.println(s + " - Is Palindrome: " + check(s,2));
            s = "abaaba";
            System.out.println(s + " - Is Palindrome: " + check(s,2));
            s = "abbabaa";
            System.out.println(s + " - Is Palindrome: " + check(s,2));
            s = "aaaa";
            System.out.println(s + " - Is Palindrome: " + check(s,2));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
