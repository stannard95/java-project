/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author keir
 */
public class ShieldTest {
    
    public ShieldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testOnImpact1() {
   
        System.out.println("onImpact 1");
        double rShield = 10; //radius of shield
        double damping = 0.8; //attenuation coefficient of shield
        double initialHealth = 100; //initial health of shield
        double expHealth=100 - 50 / Math.sqrt(2);

        //coordinates for shield
        double xShield = 100 + rShield / Math.sqrt(2);
        double yShield = -rShield / Math.sqrt(2);

        double momentum = 50;//momentum of incoming projectile
        double expMomentum=40;
        
        double orientation = 0; //orientation of incoming projectile
        //coordinates of point from which incoming projectile originates
       
        double expDirect=3.141592653589793/2;
        double xOrig = 0;
        double expX=100;
        double expY=0;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Shield shield = new Shield(xShield, yShield, initialHealth, "Shield", 1, rShield, damping);

        IProjectile projectile = causeImpact(xOrig, yOrig, orientation,
                momentum, shield, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of shield incorrect",
                expHealth, shield.getHealth(), delta);
    }
    
     
    private IProjectile causeImpact(double xorig, double yorig, 
          double orientation, double momentum,
            IShield shield, double gameRadius) {

        GameEngine engine = new GameEngine(gameRadius);
        IWeapon weapon = new Weapon(xorig, yorig, 100, "Weapon", 2, 10,  momentum);
        engine.addWeapon(weapon);
        engine.addShield(shield);
        weapon.setOrientation(orientation);
        List<IImpact> impacts = engine.fireProjectile(weapon);
        return impacts.get(0).getProjectile();

    }
    
    @Test
    public void testOnImpact2() {
   
        System.out.println("onImpact 2");
        double rShield = 10; //radius of shield
        double damping = 0.5; //attenuation coefficient of shield
        double initialHealth = 100; //initial health of shield
        double expHealth=100 - 80*Math.sqrt(3)/2;

        //coordinates for shield
        double xShield = 100+ 10*Math.sqrt(3)/2;
        double yShield = -10/2;

        double momentum = 80;//momentum of incoming projectile
        double expMomentum=40;
        
        double orientation = 0; //orientation of incoming projectile
        //coordinates of point from which incoming projectile originates
        
        double expDirect=2*3.141592653589793/3;
        double xOrig = 0;
        double expX=100;
        double expY=0;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Shield shield = new Shield(xShield, yShield, initialHealth, "Shield", 1, rShield, damping);

        IProjectile projectile = causeImpact(xOrig, yOrig, orientation,
                momentum, shield, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of shield incorrect",
                expHealth, shield.getHealth(), delta);
    }
    @Test
    public void testOnImpact3() {
   
        System.out.println("onImpact 3");
        double rShield = 10; //radius of shield
        double damping = 0.8; //attenuation coefficient of shield
        double initialHealth = 100; //initial health of shield
        double expHealth=100 - (80 / Math.sqrt(2));

        //coordinates for shield
        double xShield = 10/Math.sqrt(2);
        double yShield = -100-(10/Math.sqrt(2));

        double momentum = 80;//momentum of incoming projectile
        double expMomentum=64;
        
        double orientation = 3*(3.141592653589793/2); //orientation of incoming projectile
        //coordinates of point from which incoming projectile originates
        
        double expDirect=3.141592653589793;
        double xOrig = 0;
        double expX=0;
        double expY=-100;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Shield shield = new Shield(xShield, yShield, initialHealth, "Shield", 1, rShield, damping);

        IProjectile projectile = causeImpact(xOrig, yOrig, orientation,
                momentum, shield, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of shield incorrect",
                expHealth, shield.getHealth(), delta);
    }
    @Test
    public void testOnImpact4() {
   
        System.out.println("onImpact 4");
        double rShield = 10; //radius of shield
        double damping = 0.5; //attenuation coefficient of shield
        double initialHealth = 100; //initial health of shield
        double expHealth=100 -(80/2);

        //coordinates for shield
        double xShield = 10*(Math.sqrt(3))/2;
        double yShield = -100-(10/2);

        double momentum = 80;//momentum of incoming projectile
        double expMomentum=40;
        
        double orientation =3*(3.141592653589793/2); //orientation of incoming projectile
        //coordinates of point from which incoming projectile originates
        
        double expDirect=7*3.141592653589793/6;
        double xOrig = 0;
        double expX=0;
        double expY=-100;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Shield shield = new Shield(xShield, yShield, initialHealth, "Shield", 1, rShield, damping);

        IProjectile projectile = causeImpact(xOrig, yOrig, orientation,
                momentum, shield, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of shield incorrect",
                expHealth, shield.getHealth(), delta);
    }
    @Test
    public void testOnImpact5() {
   
        System.out.println("onImpact 5, test health below zero");
        double rShield = 10; //radius of shield
        double damping = 0.8; //attenuation coefficient of shield
        double initialHealth = 100; //initial health of shield
        double expHealth=0;

        //coordinates for shield
        double xShield = 100 + rShield / Math.sqrt(2);
        double yShield = -rShield / Math.sqrt(2);

        double momentum = 150;//momentum of incoming projectile
        double expMomentum=120;
        
        double orientation = 0; //orientation of incoming projectile
        //coordinates of point from which incoming projectile originates
       
        double expDirect=3.141592653589793/2;
        double xOrig = 0;
        double expX=100;
        double expY=0;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Shield shield = new Shield(xShield, yShield, initialHealth, "Shield", 1, rShield, damping);

        IProjectile projectile = causeImpact(xOrig, yOrig, orientation,
                momentum, shield, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of shield incorrect",
                expHealth, shield.getHealth(), delta);
    }
    
     
    
   
    }
   

