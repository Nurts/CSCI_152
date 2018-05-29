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
public class Cow extends AnimalImpl{
    
    public Cow(int maxAge) {
        super(maxAge);
    }
    
    @Override
    public String animalKind(){
        return "Cow";
    }
    
    @Override
    public boolean canEat(String food){
        return (food.equals("Grass"));
    }
    
    @Override
    public String eatingSound(){
        return "Chew, chew, chew....";
    }
    
    @Override
    public String whereLives(){
        return "Cow farm";
    }
}
