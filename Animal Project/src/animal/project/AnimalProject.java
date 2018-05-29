/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal.project;

/**
 *
 * @author Nurtas
 */
public class AnimalProject {
    
    public static void feedIt(Animal animal, String food){
        System.out.print("Feeding " + food + " to " + animal.animalKind() + " -- ");
        try{
            animal.feed(food);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void incAge(Animal animal){
        try{
            animal.ageOneYear();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void getSick(Animal animal){
        try{
            animal.gotSick();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animal tiger = new Tiger(5);
        Animal cow = new Cow(10);
        Animal panda = new Panda(15);
        
        Animal[] animals = {tiger, cow, panda};
        
        incAge(tiger);
        incAge(cow);
        incAge(panda);
        
        feedIt(tiger, "Meat");
        feedIt(cow, "Meat");
        feedIt(panda, "Bamboo");
        
        System.out.println();
        
        for(int i=0;i<3;i++){
            System.out.println(animals[i].animalKind() + " lives in " + animals[i].whereLives() + "," + animals[i].getAge() + " year old");
        }
       
        for(int i=0;i<5;i++){
            for(int j=0; j<3;j++){
                incAge(animals[j]);
            }
        }
        
        System.out.println();
        
        getSick(cow);
        incAge(cow);
        
        
        feedIt(cow, "Grass");
        
        System.out.println();
        
        for(int i=0;i<3;i++){
            System.out.println(animals[i]);
        }
        
    }
    
}
