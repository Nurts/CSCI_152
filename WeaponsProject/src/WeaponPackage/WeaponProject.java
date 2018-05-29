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
public class WeaponProject {
    
    public static void attack(Weapon weapon){
        System.out.print("Attack with " + weapon.getName() + " ");
        weapon.attack();
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Sword sword = new Sword("Excalibur", 100, 10);
        Gun gun = new Gun("Gauss gun", 200, 5);
        Bomb bomb = new Bomb("Grenade", 1000, 4);
        
        Weapon[] weapons = {sword, gun, bomb};
        
        System.out.println("Can " + sword.getName() + " kill 200 health monster with one hit: " + sword.canKill(200));
        System.out.println("Can " + gun.getName() + " kill 200 health monster with one shot: " + gun.canKill(200));
        System.out.println("Can " + bomb.getName() + " kill 200 health monster: " + bomb.canKill(200));
        
        for(int i=0;i<3;i++){
            attack(weapons[i]);
        }
        attack(bomb);
        
        System.out.println(sword);
        
        sword.repair(20);
        
        System.out.println(sword);
        
        for(int i=0; i<5; i++){
            attack(gun);
        }
        
        gun.addAmmo(2);
        
        System.out.println(gun);
        
        System.out.println("Can bomb hit the target 3 meters away from point of explosion: " + bomb.canHit(3));
        
        System.out.println(bomb);
        
        
    }
}
