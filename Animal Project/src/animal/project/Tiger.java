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
public class Tiger extends AnimalImpl{
    
    public Tiger(int maxAge) {
        super(maxAge);
    }
    
    @Override
    public String animalKind(){
        return "Tiger";
    }
    
    @Override
    public boolean canEat(String food){
        return (food.equals("Meat"));
    }
    
    @Override
    public String eatingSound(){
        return "MUNCH, MUNCH!!!";
    }
    
    @Override
    public String whereLives(){
        return "Savanna";
    }
    
}
