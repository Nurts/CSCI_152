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
public class AutoTest {
    public static void main(String[] args){
        Automobile car1 = new Automobile("BMW");
        Automobile car2 = new Automobile("Tesla");
        
        car1.startCar();
        try{
            car1.pressGasPedal();
            car1.pressGasPedal();
        } catch (Exception ex){
            System.out.println("Exception! \n" + ex.getMessage());
        }
        
        car2.startCar();
        
        try{
            car2.pressGasPedal();
        } catch (Exception ex){
            System.out.println("Exception! \n" + ex.getMessage());
        }
        
        System.out.println(car1);
        System.out.println(car2);
        
        car1.pressBrake();
        try{
            car2.pressGasPedal();
            car2.shotdown();
            
        } catch (Exception ex){
            System.out.println("Exception! \n" + ex.getMessage());
        }
        
        System.out.println(car1);
        System.out.println(car2);
    }
}
