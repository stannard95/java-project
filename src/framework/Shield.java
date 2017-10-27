/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

 /*
 * Class representing the shield
 * extends BasicEquipment and implements IShield
 * @author Keir Stannard
 */
public class Shield extends BasicEquipment implements IShield{
    private double damping;

/**
     *Constructor for Shield.
     * 'x' is the x-coordinate of Shield, represented as a double:
     * @param x
     * 'y' is the y-coordinate of Shield, represented as a double:
     * @param y
     * 'health' is the amount of health of Shield owned by a player is,
     * represented as a double:
     * @param health
     * 'name' is the attached label of the piece, represented as a string:
     * @param name
     * 'owner' is the number of the player that owns the Shield represented
     * as a integer:
     * @param owner
     * 'radius' is the radius of the Shield, expressed in game coordinates,
     * represented as a double:
     * @param radius
     *''damp' is the damping effect of the Shield, represented as a double:
     * @param damp
     */
public Shield(double x, double y, double health, String name, int owner, double radius, double damp) {
    super(x, y, health, name, owner, radius);
    this.damping = damp;
    }

   
    /**
     * Get the damping coefficient of the shield
     * @return a number in the range 0-1, representing the damping coefficient of the
     * shield
     */

    @Override
    public double getDamping() {
        return damping; 
    }
    

    
    
}
