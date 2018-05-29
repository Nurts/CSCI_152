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
public class AnimalImpl implements Animal{
    private int age;
    private int maxAge;
    private boolean isAlive;
    
    public AnimalImpl(int maxAge){
        age = 0;
        this.maxAge = maxAge;
        isAlive = true;
    }
    
    @Override
    public String animalKind() {
        return "Animal";
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean canEat(String food) {
        return (food.equals("Meat") || food.equals("Grass") || food.equals("Bamboos"));
    }

    @Override
    public void ageOneYear() throws Exception{
        if(!isAlive){
            throw new Exception(animalKind() + " is already dead!");
        }
        age++;
        if(age > maxAge){
            isAlive = false;
        }
    }
    
    @Override
    public String eatingSound() {
        return "Thank You!";
    }
    
    @Override
    public void feed(String food) throws Exception {
        if(!isAlive){
            throw new Exception( animalKind() + " is dead !");
        }
        else if(canEat(food)){
            System.out.println(eatingSound());
        }
        else{
            throw new Exception( animalKind() + " cannot eat " + food);
        }
    }

    @Override
    public String whereLives() {
        return "Earth";
    }

    @Override
    public void gotSick() throws Exception{
        if(isAlive){
            maxAge = age;
        }
        else throw new Exception("The " + animalKind() + " is already dead");
    }
    
    @Override
    public String toString(){
        return (animalKind() + " with age " + age + ". Maximum age: " + maxAge + ", Isa alive:  " +isAlive);
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }
    
}
