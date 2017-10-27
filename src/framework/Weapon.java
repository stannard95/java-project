
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

 /*
 * Class representing the Weapon
 * extends BasicEquipment and implements IWeapon
 * @author Keir Stannard
 */
public class Weapon extends BasicEquipment implements IWeapon{
    
    private double orientation;
    private double momentum;
    
/**
     *Constructor for Weapon.
     * 'x' is the x-coordinate of Weapon, represented as a double:
     * @param x
     * 'y' is the y-coordinate of Weapon, represented as a double:
     * @param y
     * 'health' is the amount of health of Weapon owned by a player is,
     * represented as a double:
     * @param health
     * 'name' is the attached label of the piece, represented as a string:
     * @param name
     * 'owner' is the number of the player that owns the Weapon represented
     * as a integer:
     * @param owner
     * 'radius' is the radius of the Weapon, expressed in game coordinates,
     * represented as a double:
     * @param radius
     * 'momentum' is the momentum of the projectile which emerges from the
     * weapon, represented as a double:
     * @param momentum
     */
    public Weapon(double x, double y, double health, String name, int owner, double radius, double momentum) {
        super(x, y, health, name, owner, radius);
        this.orientation = 50;
        this.momentum = momentum;
    }
  
    /**
     * Set the orientation of the piece
     *
     * @param angle the orientation of the piece, in radians. This is the angle at which a
     * projectile will emerge from the piece when it is fired
     */
     
    @Override
    public void setOrientation(double angle) {
        this.orientation = angle; 
    }
    
    /**
     * Get the orientation of the piece
     * @return the orientation of the piece, in radians. This is the angle at which a
     * projectile will emerge from the piece when it is fired
     */
    
    @Override
    public double getOrientation() {
        return orientation;
        
    }
    
    /**
     * @return The projectile that emerges from the weapon when it is fired
     */
    
    @Override
    public IProjectile onFireProjectile() { 
        Projectile project = new Projectile(x, y, orientation, momentum); 
        return project;
    }

    
    
    
}
