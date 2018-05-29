/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT_Project.main;

import ADT_Project.adt.Queue;
import ADT_Project.adt.Stack;
import ADT_Project.impl.ArrayQueue;
import ADT_Project.impl.ArrayStack;

/**
 *
 * @author Nurtas
 */
public class MethodsLesson8 {
    public static int evenCount(Stack<Integer> stk) throws Exception{
        int ans = 0;
        Stack<Integer> temp = new ArrayStack();
        while(stk.getSize()>0){
            int top = stk.pop();
            if(top % 2 == 0)ans++;
            temp.push(top);
        }
        
        while(temp.getSize()>0){
            stk.push(temp.pop());
        }
        return ans;
        
    }
    
    public static Stack<Integer> copyStack(Stack<Integer> orig) throws Exception{
        Stack<Integer> temp = new ArrayStack(), ans = new ArrayStack();
        
        while(orig.getSize() > 0){
            temp.push(orig.pop());
        }
        
        while(temp.getSize() > 0){
            int top = temp.pop();
            ans.push(top);
            orig.push(top);
        }
        
        return ans;
    }
    
    public static Queue<Integer> copyQueue(Queue<Integer> orig) throws Exception{
        Queue<Integer> ans = new ArrayQueue();
        
        for(int i=0;i<orig.getSize();i++){
            int next = orig.dequeue();
            ans.enqueue(next);
            orig.enqueue(next);
        }
        
        return ans;
        
    }
    
    public static void reverseStack(Stack<Integer> toRev) throws Exception{
        Queue<Integer> temp = new ArrayQueue();
        
        while(toRev.getSize() > 0){
            temp.enqueue(toRev.pop());
        }
        
        while(temp.getSize() > 0){
            toRev.push(temp.dequeue());
        }
    }
    
    public static void reverseQueue(Queue<Integer> toRev) throws Exception{
        Stack<Integer> temp = new ArrayStack();
        
        while(toRev.getSize() > 0){
            temp.push(toRev.dequeue());
        }
        
        while(temp.getSize() > 0){
            toRev.enqueue(temp.pop());
        }
    }
    
    public static boolean isPalindrome(Queue<Integer> q) throws Exception{
        Queue<Integer> temp = copyQueue(q);
        reverseQueue(temp);
        boolean ans = true;
        for(int i=0;i<q.getSize();i++){
            int next =  q.dequeue();
            if(next != temp.dequeue())ans = false;
            
            q.enqueue(next);
        }
        return ans;
    }
    
    public static void insert(Stack<Integer> st, int pos, int val) throws Exception{
        
        if(st.getSize() == pos)st.push(val);
        
        else {
            int cur = st.pop();
            
            insert(st,pos,val);
            
            st.push(cur);
        }
    }
    
    public static Stack<Integer> merge(Stack<Integer> s1, Stack<Integer> s2) throws Exception{
        reverseStack(s1);
        reverseStack(s2);
        Stack<Integer> ans = new ArrayStack();
        while(s1.getSize()>0 || s2.getSize()>0){
            
            if(s2.getSize() == 0)ans.push(s1.pop());
            
            else if(s1.getSize() == 0)ans.push(s2.pop());
            
            
            else{
                int f = s1.pop(),s = s2.pop();
                if(f < s){
                    ans.push(f);
                    s2.push(s);
                }
                else {
                    ans.push(s);
                    s1.push(f);
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String args[]) throws Exception{
        
        Stack<Integer> stk = new ArrayStack();
        
        for(int i=0;i<10;i++){
            stk.push(i);
        }
        
        Stack<Integer> newstk;
        System.out.println("Even: " + evenCount(stk));
            
        newstk = copyStack(stk);
        System.out.println("Copy of the stack: " + newstk);
        
        stk = merge(stk, newstk);
        System.out.println("Merging two stacks: " + stk);
        
        insert(stk, 5, 100);
        
        System.out.println("Inserting 100 to pos 5: " + stk);
        
        Queue<Integer> que = new ArrayQueue();
        
        for(int i=0;i<5;i++){
            que.enqueue(i);
        }
        for(int i=3;i>=0;i--){
            que.enqueue(i);
        }
        
        System.out.println(que + " | Is Palindrome: " + isPalindrome(que));
    }
}
