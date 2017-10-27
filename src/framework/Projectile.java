/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

/*
 * Class representing the projectile
 * extends BasicEquipment and implements IProjectile
 * @author Keir Stannard
 */
public class Projectile implements IProjectile{
    
    private double momentum;
    private double OriginX;
    private double OriginY;
    private double direction;

    /**
     *Constructor for Projectile
     * 'x' is the x-coordinate of projectile, represented as a double:
     * @param x
     * 'y' is the y-coordinate of projectile, represented as a double:
     * @param y
     * 'direction' is the direction of the projectile, represented as an 
     * angle measured anti-clockwise from the game coordinate x axis, in radians.
     * @param direction
     * 'momentum' is the momentum of the projectile, which determines the amount
     * of health a piece will lose, represented as a double:
     * @param momentum
     */
    public Projectile(double x, double y, double direction, double momentum) {
    
    this.OriginX = x;
    this.OriginY = y;
    this.momentum = momentum;
    this.direction = direction;
    
    }
    
    /**
     * Get the momentum of the projectiles
     * @return a positive value representing the momentum of the projectile
     */
    
    @Override
    public double getMomentum() {
        return momentum; 
    }
    
    /**
     * Get the direction of the projectile
     * @return the direction of the projectile, represented as an angle measured
     * anti-clockwise from the game coordinate x axis, in radians.
     */
    
    @Override
    public double getDirection() {
        return direction; 
    }
    
    /**
     * Get the x coordinate of the position from which the projectile originated
     * @return x coordinate of position from which projectile originates, in game
     * coordinates
     */
    
    @Override
    public double getOriginX() {
        return OriginX;
    }

    /**
     * Get the y coordinate of the point from which the projectile originated
     * @return y coordinate of position from which projectile originates, in game
     * coordinates
     */
    
    @Override
    public double getOriginY() {
        return OriginY; 
    }
    
    /**
     * Sets the value of momentum, represented as a double.
     * @param moment 
     */
    
    @Override
    public void setMomentum(double moment) {
         this.momentum = moment;
    }
    
    /**
     * Sets the value of direction, represented as a double.
     * @param direct 
     */ 
     
    @Override
    public void setDirection(double direct) {
        this.direction = direct;
    
}
    
    /**
     * Sets the value of x coordinate, represented as a double.
     * @param x 
     */
    
    @Override
    public void setOriginX(double x) {
        this.OriginX = x; 
    }
    
    /**
     * Sets the value of y coordinate, represented as a double.
     * @param y 
     */
    
    @Override
    public void setOriginY(double y) {
        this.OriginY = y; 
    }

   
}
