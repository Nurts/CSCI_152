/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.main;

import Set_Project.adt.Set;
import Set_Project.impl.LLQueueSet;

/**
 *
 * @author Nurtas
 */
public class MethodsLesson15 {
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> temp = new LLQueueSet();
        boolean ans = true;
        while(set1.getSize() > 0){
            int cur = 0;
            try{
                cur = set1.removeAny();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            ans = ans && set2.contains(cur);
            
            temp.add(cur);
        }
        
        while(temp.getSize()>0){
            try{
                set1.add(temp.removeAny());
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return ans;
    }
    
    public static Set<String> union(Set<String> set1, Set<String> set2){
        Set<String> temp1 = new LLQueueSet();
        Set<String> temp2 = new LLQueueSet();
        Set<String> ans = new LLQueueSet();
        
        while(set1.getSize() > 0){
            try{
                String s = set1.removeAny();
                temp1.add(s);
                ans.add(s);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        while(set2.getSize() > 0){
            try{
                String s = set2.removeAny();
                temp2.add(s);
                ans.add(s);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        while(temp1.getSize()>0){
            try{
                set1.add(temp1.removeAny());
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        while(temp2.getSize()>0){
            try{
                set2.add(temp2.removeAny());
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return ans;
    }
    
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> temp = new LLQueueSet();
        Set<Integer> ans = new LLQueueSet();
        
        while(set1.getSize() > 0){
            int cur = 0;
            try{
                cur = set1.removeAny();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            if(set2.contains(cur))ans.add(cur);
            temp.add(cur);
        }
        
        while(temp.getSize()>0){
            try{
                set1.add(temp.removeAny());
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return ans;
    }
    
    public static void main(String[] args){
        Set<Integer> set1 = new LLQueueSet();
        Set<Integer> set2 = new LLQueueSet();
        for(int i=0;i<5;i++){
            set1.add(i);
            set2.add(i);
        }
        set2.add(3);
        set2.add(10);
        set2.add(13);
        System.out.println("Is: " + set1 + " the subset of " + set2 + ": " + isSubset(set1,set2));
        set2.remove(0);
        System.out.println("Is: " + set1 + " the subset of " + set2 + ": " + isSubset(set1,set2));
            
        
        Set<String> setStr1 = new LLQueueSet();
        Set<String> setStr2 = new LLQueueSet();
        
        setStr1.add("Nurtas");
        setStr1.add("Someone");
        setStr1.add("Aba");
        
        setStr2.add("Nurtas");
        setStr2.add("Qwerty");
        setStr2.add("Abacaba");
        
        System.out.println("The union of : " + setStr1 + "\nAnd: " + setStr2 +"\nIs: " + union(setStr1,setStr2).toString());
        System.out.println("Intersection of: " + set1 + " and " + set2 + "\nIs :" + intersection(set1,set2).toString());
        
    }
}
