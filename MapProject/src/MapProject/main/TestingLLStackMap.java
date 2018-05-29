/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapProject.main;

import MapProject.adt.Map;
import MapProject.impl.LLStackMap;

/**
 *
 * @author Nurtas
 */
public class TestingLLStackMap {
    public static void main(String[] args){
        Map<Integer, String> map = new LLStackMap();
        try{
            map.removeAny();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Map: " + map + "\nSize: " + map.getSize());
        
        map.define( 1, "One");
        map.define( 2, "Two");
        map.define( 3, "Three");
        map.define( 4, "Four");
        map.define( 5, "One");
        
        System.out.println("Map: " + map + "\nSize: " + map.getSize());
        
        map.remove(4);
        System.out.println("Map: " + map + "\nSize: " + map.getSize());
        
        map.remove(10);
        System.out.println("Map: " + map + "\nSize: " + map.getSize());
        
        map.define( 1, "Not One");
        map.define( 3, "Not Three");
        System.out.println("Map: " + map + "\nSize: " + map.getSize());
        
        map.define( 6, "Six");
        map.define( 7, "Seven");
        map.define( 8, "Eight");
        System.out.println("Map: " + map + "\nSize: " + map.getSize());
        
        try{
            System.out.println("Removed: " + map.removeAny());
            System.out.println("Reomved: " + map.removeAny());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Map: " + map + "\nSize: " + map.getSize());
        
        map.clear();
        System.out.println("Map: " + map + "\nSize: " + map.getSize());
        
        map.define(9, "Nine");
        map.define(10, "Ten");
        System.out.println("Map: " + map + "\nSize: " + map.getSize());
    }
}
