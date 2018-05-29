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
public class Weapon {
    private String name;
    private int damage;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }
    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    /**
     * @param s the name to set
     * @param d the damage to set
     */
    public Weapon(String s, int d){
        if(d <= 0)damage = 1;
        else damage = d;
        name = s;
    }
    /**
     * 
     * @param health to compare
     * @return if the health is less than damage
     */
    public boolean canKill(int health){
        return health <= getDamage();
    }
    /**
     * Prints the dealt damage
     */
    public void attack(){
        System.out.println("Successfull! Dealt Damage: " + getDamage());
    }
    /**
     * @return String representation
     */
    public String toString(){
        return ("The weapon name: " + getName() + ", Damage: " + getDamage());
    }
    
    
}
