/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockproject;

/**
 *
 * @author Nurtas
 */
public class ClockProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Clock time = new Clock();
        try {
            time = new Clock (13,42,52);
        } catch (Exception ex) {
            System.out.println("Exception!\n" + ex.getMessage());
        }
        System.out.println(time);
        
        System.out.println("Current time: " + time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds() + " Is Morning: " + time.isMorning());
        
        time.resetToMidnight();
        time.tick();
        time.tick();
        System.out.println(time);
        
        try {
            time.setHours(23);
        } catch (Exception ex){
            System.out.println("Exception!\n" + ex.getMessage());
        }
        
        try {
            time.setMinutes(59);
        } catch (Exception ex){
            System.out.println("Exception!\n" + ex.getMessage());
        }
        
        try {
            time.setSeconds(59);
        } catch (Exception ex){
            System.out.println("Exception!\n" + ex.getMessage());
        }
        time.tick();
        
        
        
        System.out.println(time);
    }
    
}
