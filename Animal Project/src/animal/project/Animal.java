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
public interface Animal {
    
    /**
     * Returns the kind of the animal;
     * 
     * @return the kind of animal
     */
    public String animalKind();
    
    /**
     * Returns the age of the animal
     * 
     * @return the age of animal
     */
    public int getAge();
    
    /**
     * Returns if the animal can Eat the food
     * 
     * @param food the name of the food
     * @return weather or not the animal can eat the food
     */
    public boolean canEat(String food);
    
    /**
     * increments age if animal is alive
     * if age is over maxAge animal will die
     * if animal is not alive throws Exception
     * @throws Exception if animal is not alive
     */
    public void ageOneYear() throws Exception;
    
    /**
     * 
     * @return the eating Sound
     */
    public String eatingSound();
    
    
    /**
     * if the animal can eat the food the feeds the animal, and is alive
     * if not throws Exception
     * 
     * @param food the name of the food
     * @throws Exception if animal cannot eat the food
     */
    public void feed (String food) throws Exception;
    
    /**
     * Returns the habitat of the animal
     * 
     * @return the habitat
     */
    public String whereLives();
    
    /**
     * Changes the maxAge to age, if the animal is alive
     * Otherwise throws Exception
     * @throws Exception if animal is not alive
     */
    public void gotSick() throws Exception;
    /**
     * 
     * @return if the animal is alive
     */
    public boolean isAlive();
}
