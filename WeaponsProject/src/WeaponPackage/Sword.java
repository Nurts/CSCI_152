/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeaponPackage;

/**
 *
 * @author Nurtas
 */
public class Sword extends Weapon{
    private int strength;
    private int cost;//repair price per one percent of strength
    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    /**
     * @param s name to set
     * @param d damage to set
     * @param c cost to set
     */
    public Sword(String s,int d, int c){
        super(s,d);
        strength = 100;
        cost = c;
    }
    /**
     * Prints the dealt damage if the strength is not 0
     * Otherwise prints that sword is broken
     */
    @Override
    public void attack(){
        if(getStrength() > 0){
            System.out.println("Successfull! Damage dealt with sword is: " + getDamage());
            setStrength(getStrength() - 1);
        }
        else System.out.println("Failed! Sword is Broken");
    }
    /**
     * Sets strength field to 100 if money parameter is more than cost
     * @param money to compare
     */
    public void repair(int money){
        if(money >= getCost() * (100 - getStrength())){
            setStrength(100);
            System.out.println("Sword was successfully repaired! (Price: " + getCost() + ")");
        }
        else System.out.println("Not enough money!");
    }
    /**
     * @return String representation
     */
    @Override
    public String toString(){
        return "The sword name: " + getName() + ", Damage: " + getDamage() + ", Strength: " + getStrength() + ", Repair price per one percent: " + getCost();
    }
}
