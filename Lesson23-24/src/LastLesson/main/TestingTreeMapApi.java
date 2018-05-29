/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LastLesson.main;

import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author Nurtas
 */
public class TestingTreeMapApi {
    public static void main(String[] args){
        Map<Integer, String> map = new TreeMap();

        System.out.println("Map: " + map + "\nSize: " + map.size());
        
        map.put( 1, "Nurtas");
        map.put( 2, "Dude");
        map.put( 3, "Someone");
        map.put( 4, "Psycho");
        map.put( 5, "Nurtas");
        
        System.out.println("Map: " + map + "\nSize: " + map.size());
        
        map.remove(4);
        System.out.println("Map: " + map + "\nSize: " + map.size());
        
        map.remove(10);
        System.out.println("Map: " + map + "\nSize: " + map.size());
        
        map.put( 1, "John");
        map.put( 3, "Anyone");
        System.out.println("Map: " + map + "\nSize: " + map.size());
        
        map.put( 6, "Six");
        map.put( 7, "Seven");
        map.put( 8, "Eight");
        System.out.println("Map: " + map + "\nSize: " + map.size());
        
        
        map.clear();
        System.out.println("Map: " + map + "\nSize: " + map.size());
        
        map.put(9, "Nine");
        map.put(10, "Ten");
        System.out.println("Map: " + map + "\nSize: " + map.size());
    }
}