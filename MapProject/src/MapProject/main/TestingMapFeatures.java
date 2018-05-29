/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapProject.main;

import MapProject.adt.Map;
import MapProject.impl.KeyValuePair;
import MapProject.impl.LLQueueMap;

/**
 *
 * @author Nurtas
 */
public class TestingMapFeatures {
    public static void main(String[] args) throws Exception{
        Map<Integer, String> mp = new LLQueueMap();
        mp.define(12, "Hmmmmmmm");
        KeyValuePair<Integer, String> res = mp.removeAny();
        try{
            res = mp.removeAny();
        }catch(Exception ex){
            
        }
        System.out.println(res);
    }
}
