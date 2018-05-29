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
public class Bomb extends Weapon{
    private int radius;//radius of explosion
    private boolean exploded;
    /**
     * @return the exploded
     */
    public boolean isExploded() {
        return exploded;
    }
    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
    /**
     * @param s name to set
     * @param d damage to set
     * @param r radius to set
     */
    public Bomb(String s,int d, int r){
        super(s,d);
        radius = r;
        exploded = false;
    }
    /**
     * Attacks if the bomb is not exploded yet
     */
    @Override
    public void attack(){
        if(exploded)System.out.println("Failed! The bomb already was exploded!");
        else {
            System.out.println("Successfull! Damage dealt with bomb: " + getDamage());
            exploded = true;
        }
    }
    /**
     * Sets the exploded field to true
     */
    public void Detonate(){
        exploded = true;
    }
    /**
     * returns if the explosion of the bomb will hit the object which is dst far from the point of explosion
     * @param dst distance from the point of explosion
     * @return if parameter is less than radius
     */
    public boolean canHit(int dst){
        return dst < getRadius();
    }
    /**
     * @return String representation
     */
    @Override
    public String toString(){
        return "The name of the bomb: " + getName() + ", The damage: " + getDamage() + ", The radius of explosion " + getRadius() + ", Is exploded: " + isExploded();
    }
}
