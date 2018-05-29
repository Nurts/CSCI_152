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
public class FirstJavaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double pi = 3.1415;
        
        //for box
        int l = 3,w = 5,h = 4;
        int volume = l * w * h;
        int surfArea = (2 * l * w) + (2 * h * w) + (2 * l * h);
        
        System.out.println("The volume of the box is " + volume + "\nThe surface area of the box is " + surfArea + "\n");
        
        //for circle
        int r = 5;
        double circum = 2 * pi * r;
        double area = pi * r * r;
        System.out.print("The circumference of the circle is ");
        System.out.printf("%f",circum);
        System.out.print("\nThe area of the circle is ");
        System.out.printf("%f\n",area);
        
        //ASCII art
        
        System.out.println("\n      _/_/\n   _/    _/\n  _/_/_/_/\n _/    _/\n_/    _/\n\n    _/_/_/\n   _/    _/\n  _/_/_/  \n _/   _/ \n_/    _/\n");
        System.out.println(" _/_/_/_/_/\n    _/\n   _/\n  _/\n _/\n");
        
       
    }
    
}
