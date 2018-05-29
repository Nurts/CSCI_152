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
public class Clock {
    private int hours;
    private int minutes;
    private int seconds;
    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * 
     * @param hours the hours to set
     * @throws Exception if hours is not in range
     */
    public void setHours(int hours) throws Exception{
        if(hours >= 24 || hours < 0){
            throw new Exception("Hours is not in range");
        }
        this.hours = hours;
    }

    /**
     * @return the minutes
     */
    public int getMinutes(){
        return minutes;
    }

    /**
     * @param minutes the minutes to set
     * @throws Exception if minutes is not in range
     */
    public void setMinutes(int minutes) throws Exception{
        if(minutes >= 60 || minutes < 0){
            throw new Exception("Minutes is not in range");
        }
        this.minutes = minutes;
    }

    /**
     * @return the seconds
     */
    public int getSeconds() {
        return seconds;
    }
    /**
     * @param seconds the seconds to set
     * @throws Exception if seconds is not in range
     */
    public void setSeconds(int seconds) throws Exception{
        if(seconds >= 60 || seconds < 0){
            throw new Exception("Seconds is not in range");
        }
        this.seconds = seconds;
    }
    /**
     * Sets the values of the clock to 0
     */
    public Clock(){
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    /**
     * 
     * @param h the hours to set
     * @param m the minutes to set
     * @param s the seconds to set
     * @throws Exception if one of the values is not in range
     */
    public Clock(int h, int m, int s) throws Exception{
        if(h>=24 || m>=60 || s>=60 || h<0 || m<0 || s<0){
            hours = 0;
            minutes = 0;
            seconds = 0;
            throw new Exception("The input values are wrong! (Clock is set to midnight)");
        }
        hours = h;
        minutes = m;
        seconds = s;
    }
    /**
     * Changes the field values to 0
     */
    public void resetToMidnight(){
        hours = 0;
        seconds = 0;
        minutes = 0;
    }
    /**
     * Checks weather the time on the clock is morning.
     * It is morning if the hours field is less than 12
     * @return if hours is less than 12
     */
    public boolean isMorning(){
        return (getHours() < 12);
    }
    /**
     * adds one second to the seconds field
     * if second exceeds the range, which is 60, then seconds will be assigned to 0
     * and minutes will increase to 1, if minutes exceeds the range hours will increase,
     * and minutes will set to 0, if hours will exceed then hours also will set to 0
     * 
     */
    public void tick(){
        seconds++;
        if(seconds == 60){
            seconds = 0;
            minutes++;
        }
        if(minutes == 60){
            minutes = 0;
            hours++;
        }
        if(hours == 24){
            hours = 0;
        }
    }
    /**
     * 
     * @return the current time on the clock
     */
    public String toString(){
        String res = "The current time: ";
        if(getHours() < 10)res += 0;
        res += getHours() + ":";
        if(getMinutes() < 10)res += 0;
        res += getMinutes() + ":";
        if(getSeconds() < 10)res += 0;
        res += getSeconds();
        return res;
    }
}
