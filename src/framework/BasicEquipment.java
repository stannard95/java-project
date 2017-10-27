/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

/**
 * Class representing the basic equipment
 * implements IPiece
 * @author Keir Stannard
 */
public class BasicEquipment implements IPiece{
     double x;
     double y;
     private double health;
     private String name;
     private int owner;
     private double radius;
     
     /**
     *Constructor for BasicEquipment.
     * 'x' is the x-coordinate for the piece, represented as a double:
     * @param x
     * 'y' is the y-coordinate for the piece, represented as a double:
     * @param y
     * 'health' is the amount of health a piece owned by a player is,
     * represented as a double:
     * @param health
     * 'name' is the attached label of the piece, represented as a string:
     * @param name
     * 'owner' is the number of the player that owns the piece
     * represented as a integer:
     * @param owner
     * 'radius' is the radius of the piece, expressed in game coordinates,
     * represented as a double:
     * @param radius
     */
     
public BasicEquipment(double x, double y, double health, String name, int owner, double radius) {
    this.x = x;
    this.y = y;
    this.health = health;
    this.name = name;
    this.owner = owner;
    this.radius = radius;
}
    /**
     * Gets the value of owner
     * @return value of owner as a integer
     */

    @Override
    public int getOwner() {
        return owner; 
    }
    
    /**
     * Gets the value of health
     * @return value of health as a double
     */
    
    @Override
    public double getHealth() {
        return health; 
    }
    
    /**
     * Gets the value of x
     * @return value of x as a double
     */
    
    @Override
    public double getXPos() {
        return x; 
    }
    
    /**
     * Gets the value of y
     * @return value of y as a double
     */
    
    @Override
    public double getYPos() {
        return y; 
    }
    
    /**
     * Gets the value of radius
     * @return value of radius as a double
     */
    
    @Override
    public double getRadius() {
        return radius; 
    }
    
    /**
     * Gets the value of name
     * @return value of name as a string
     */
    
    @Override
    public String getName() {
        return name; 
    }
    
    /** 
     * Method to be called by the game engine when a projectile hits this piece
     * @param impact object representing the impact of the incoming projectile,
     * this is after modifying the health, the x and y coordinates and determining
     * whether the object impacted is a shield or a weapon, then being able to set
     * the momentum and direction of the outgoing projectile.
     * @return the object that represents the outgoing projectile. 
     */
    
    @Override
    public IProjectile onImpact(IImpact impact) { 
        IProjectile projectInv = impact.getProjectile(); //incoming projectile
        IPiece impactPiece = impact.getPiece();
        double momentumIn = impact.getProjectile().getMomentum();
        double xImpact, yImpact;
        double pi = 3.141592653589793;
        double pi2 = pi * 2;
        
        xImpact = impact.getxImpact();
        yImpact = impact.getyImpact();
        
        health = health - momentumIn * Math.sin(impact.getAngle()); //new health of piece
        if (health < 0) {
            health = 0;
        }
        
        IProjectile projectOut = impact.getProjectile(); //outgoing projectile
        projectOut.setOriginX(xImpact);
        projectOut.setOriginY(yImpact);
         switch (impact.getPiece().getName()) {
             case "Shield":
                 Shield sPiece = (Shield) impactPiece;
                 projectOut.setMomentum(momentumIn * sPiece.getDamping()); //Sets momumentum of outgoing
                
                 if(impact.getAngle() < 0) {
                     projectOut.setDirection(projectIn.getDirection() + 2 * pi);
                 }
                 else {
                 projectOut.setDirection(projectIn.getDirection() + 2 * impact.getAngle()); //sets direction of outgoing
                 if(projectOut.getDirection() > pi2) {
                     projectOut.setDirection(projectIn.getDirection() - pi2);
                 }
                 }
                 break;
             case "Weapon":
                 projectOut.setMomentum(momentumIn);
                 if(impact.getAngle() < 0) {
                     projectOut.setDirection(projectIn.getDirection() + 2 * pi);
                 }
                 else {
                 projectOut.setDirection(projectIn.getDirection() + 2 * impact.getAngle()); //sets direction of outgoing
                 if(projectOut.getDirection() > pi2) {
                     projectOut.setDirection(projectIn.getDirection() - pi2);
                 }
                 }
                 break;
         }
         
        return projectOut;  //returns outgoing projectile 
                                            
    }
    
    /**
     * Method to be called by the game engine when a piece has been successfully moved to
     * a new position. This method is called by the game engine, after it has checked that a move is valid. 
     * @param x new x coordinate for piece, in game coordinates
     * @param y new y coordinate for piece, in game coordinates
     */
    
    @Override
    public void onSuccessfulMove(double x, double y) {
        this.x = x;
        this.y = y;
    }

    

    
}
