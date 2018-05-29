/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto_package;

/**
 *
 * @author Nurtas
 */
public class Automobile {
    private boolean engineRunning;
    private double speed;
    private String name;
    /**
     * 
     * @param s to set the name
     */
    public Automobile(String s){
        engineRunning = false;
        speed = 0.0;
        name = s;
    }
    /**
     * Sets the engineRunning field to true
     */
    public void startCar(){
        engineRunning = true;
    }
    /**
     * Increases the speed by 10 if the engine is running
     * @throws Exception if the engineRunning field is false
     */
    public void pressGasPedal() throws Exception{
        if(!engineRunning){
            throw new Exception ("The engine is not running! The speed remains unchaged!");
        }
        speed += 10.0;
    }
    /**
     * Sets the speed to 0
     */
    public void pressBrake(){
        speed = 0.0;
        
    }
    /**
     * 
     * @throws Exception if the speed is not 0
     */
    public void shotdown() throws Exception{
        if(speed != 0.0){
            throw new Exception("You should stop the car to shotdown the engine!");
        }
        engineRunning = false;
    }
    /**
     * 
     * @return engineRunning
     */
    public boolean isEngineRunning(){
        return engineRunning;
    }
    /**
     * 
     * @return speed
     */
    public double getSpeed(){
        return speed;
    }
    /**
     * Calculates the distance, which will be traveled if the car will go with 
     * constant speed in parameter argument seconds
     * @param time to calculate the distance
     * @return the distance traveled
     */
    public double calculateDistance(double time){
        return time * speed;
    }
    /**
     * 
     * @return the name the engineRunning field and speed as String
     */
    public String toString(){
        String res = "Car : " + name + ", Engine Running: " + engineRunning + ", Current Speed: " + speed;
        return res;
    }
}
