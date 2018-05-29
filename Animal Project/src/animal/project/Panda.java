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
public class Panda extends AnimalImpl{
    
    public Panda(int maxAge) {
        super(maxAge);
    }
    
    @Override
    public String animalKind(){
        return "Panda";
    }
    
    @Override
    public boolean canEat(String food){
        return (food.equals("Bamboo"));
    }
    
    @Override
    public String eatingSound(){
        return "Crunch, Crunch...";
    }
    
    @Override
    public String whereLives(){
        return "China";
    }
}
