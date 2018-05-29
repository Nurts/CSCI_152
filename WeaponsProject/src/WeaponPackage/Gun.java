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
public class Gun extends Weapon{
    private int ammo;
    /**
     * @return the ammo
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * @param ammo the ammo to set
     */
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
    
    /**
     * @param s name to set
     * @param d damage to set
     * @param m ammo to set
     */
    public Gun(String s, int d, int m){
        super(s,d);
        ammo = m;
    }

    /**
     * increases the ammo
     * @param ammo the ammo to add
     */
    public void addAmmo(int ammo){
        this.setAmmo(this.getAmmo() + ammo);
    }
    /**
     * attacks if the ammo is not 0
     */
    @Override
    public void attack(){
        if(getAmmo() > 0){
            System.out.println("Successfull! Damage dealt with gun: " + getDamage());
            ammo--;
        }
        else {
            System.out.println("Failed! Out of Ammo!");
        }
    }
    @Override
    public String toString(){
        return "The name of the gun: " + getName() + ", the damage: " + getDamage() + ", ammo left: " + getAmmo();
    }
    
}
