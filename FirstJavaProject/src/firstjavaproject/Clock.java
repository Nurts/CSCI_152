/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstjavaproject;

/**
 *
 * @author Nurtas
 */
public class Clock {
    public int hours;
    private int minutes;
    private int seconds;
    public 
        Clock(int h, int m, int s){
            hours = h;
            minutes = m;
            seconds = s;
        }
        void resetToMidnight(){
            hours = 0;
            minutes = 0;
            seconds = 0;
        }
        boolean isMorning(){
            return (hours < 12);
        }
        
        void tick(){
            seconds++;
            if(seconds >= 60){
                seconds = 0;
                minutes++;
            }
            if(minutes >= 60){
                minutes = 0;
                hours++;
            }
            if(hours >= 24){
                hours = 0;
            }
        }
        
    
}
