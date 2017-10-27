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
 * @author 14066588
 */
public class WeaponTest {
    
    public WeaponTest() {
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
        double  rWeapon= 10; //radius of Weapon
        double initialHealth = 100; //initial health of Weapon
        double expHealth=100 - 50 / Math.sqrt(2);

        //coordinates for Weapon
        double xWeapon = 100 + rWeapon / Math.sqrt(2);
        double yWeapon = -rWeapon / Math.sqrt(2);

        double momentum = 50;//momentum of incoming projectile
        double expMomentum=50;
        
        
        double direction=0;
        double expDirect=3.141592653589793/2;
        double xOrig = 0;
        double expX=100;
        double expY=0;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Weapon weapon1 = new Weapon(xWeapon, yWeapon, initialHealth,"Weapon", 1, rWeapon, momentum);

        IProjectile projectile = causeImpact(xOrig, yOrig, direction,
                momentum, weapon1, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of Weapon incorrect",
                expHealth, weapon1.getHealth(), delta);
    }
    
     
    private IProjectile causeImpact(double xorig, double yorig, 
          double orientation, double momentum,
            IWeapon Weapon, double gameRadius) {

        GameEngine engine = new GameEngine(gameRadius);
        IWeapon weapon2 = new Weapon(xorig, yorig, 100, "Weapon", 2, 10,  momentum);
        engine.addWeapon(Weapon);
        engine.addWeapon(weapon2);
        weapon2.setOrientation(orientation);
        List<IImpact> impacts = engine.fireProjectile(weapon2);
        return impacts.get(0).getProjectile();

    }
    
    @Test
    public void testOnImpact2() {
   
        System.out.println("onImpact 2");
        double rWeapon = 10; //radius of Weapon
        
        double initialHealth = 100; //initial health of Weapon
        double expHealth=100 - 80*Math.sqrt(3)/2;

        //coordinates for Weapon
        double xWeapon = 100+ 10*Math.sqrt(3)/2;
        double yWeapon = -10/2;

        double momentum = 80;//momentum of incoming projectile
        double expMomentum=80;
        
       
        double direction=0;
        double expDirect=2*3.141592653589793/3;
        double xOrig = 0;
        double expX=100;
        double expY=0;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Weapon Weapon = new Weapon(xWeapon, yWeapon, initialHealth, "Weapon", 1, rWeapon, momentum);

        IProjectile projectile = causeImpact(xOrig, yOrig, direction,
                momentum, Weapon, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of Weapon incorrect",
                expHealth, Weapon.getHealth(), delta);
    }
    @Test
    public void testOnImpact3() {
   
        System.out.println("onImpact 3");
        double rWeapon = 10; //radius of Weapon
        
        double initialHealth = 100; //initial health of Weapon
        double expHealth=100 - (80 / Math.sqrt(2));

        //coordinates for Weapon
        double xWeapon = 10/Math.sqrt(2);
        double yWeapon = -100-(10/Math.sqrt(2));

        double momentum = 80;//momentum of incoming projectile
        double expMomentum=80;
        
        
        double direction=3*(3.141592653589793/2);
        double expDirect=3.141592653589793;
        double xOrig = 0;
        double expX=0;
        double expY=-100;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Weapon Weapon = new Weapon(xWeapon, yWeapon, initialHealth, "Weapon", 1, rWeapon, momentum);

        IProjectile projectile = causeImpact(xOrig, yOrig, direction,
                momentum, Weapon, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of Weapon incorrect",
                expHealth, Weapon.getHealth(), delta);
    }
    @Test
    public void testOnImpact4() {
   
        System.out.println("onImpact 4");
        double rWeapon = 10; //radius of Weapon
        
        double initialHealth = 100; //initial health of Weapon
        double expHealth=100 -(80/2);

        //coordinates for Weapon
        double xWeapon = 10*(Math.sqrt(3))/2;
        double yWeapon = -100-(10/2);

        double momentum = 80;//momentum of incoming projectile
        double expMomentum=80;
        
       
        double direction=3*(3.141592653589793/2);
        double expDirect=7*3.141592653589793/6;
        double xOrig = 0;
        double expX=0;
        double expY=-100;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Weapon Weapon = new Weapon(xWeapon, yWeapon, initialHealth, "Weapon", 1, rWeapon, momentum);

        IProjectile projectile = causeImpact(xOrig, yOrig, direction,
                momentum, Weapon, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of Weapon incorrect",
                expHealth, Weapon.getHealth(), delta);
    }

    @Test
    public void testOnImpact5() {
   
        System.out.println("onImpact 5, test health below zero");
        double rWeapon = 10; //radius of Weapon
        
        double initialHealth = 100; //initial health of Weapon
        double expHealth=0;

        //coordinates for Weapon
        double xWeapon = 100+ 10*Math.sqrt(3)/2;
        double yWeapon = -10/2;

        double momentum = 120;//momentum of incoming projectile
        double expMomentum=120;
        
        double direction=0;
        double expDirect=2*3.141592653589793/3;
        double xOrig = 0;
        double expX=100;
        double expY=0;
        double yOrig = 0;

        double gameRadius = 500;//radius for game
        double delta = 0.001; // tolerance for testing real values
        Weapon Weapon = new Weapon(xWeapon, yWeapon, initialHealth, "Weapon", 1, rWeapon, momentum);

        IProjectile projectile = causeImpact(xOrig, yOrig, direction,
                momentum, Weapon, gameRadius);

        assertEquals("Angle of outgoing projectile incorrect", expDirect,
                projectile.getDirection(), delta);
        assertEquals("Momentum of outgoing projectile incorrect", expMomentum,
                projectile.getMomentum(), delta);
        assertEquals("X origin of outgoing projectile incorrect",
                expX, projectile.getOriginX(), delta);
        assertEquals("Y origin of outgoing projectile incorrect", expY,
                projectile.getOriginY(), delta);
        assertEquals("Health of Weapon incorrect",
                expHealth, Weapon.getHealth(), delta);
    }
    /**
     * Test of onFireProjectile method, of class Weapon.
     */
    @Test
    public void testOnFireProjectile1() {
        System.out.println("onFireProjectile test");
        double x=10;
        double y=25;
        double health=100;
        String name="Weapon";
        int owner=1;
        double radius=500;
        double momentum=50;
        
        Weapon instance = new Weapon(x, y, health, name, owner, radius, momentum);
        IProjectile result = instance.onFireProjectile();
        double expResultX=10;
        double resultX=result.getOriginX();
        
        double expResultY=25;
        double resultY=result.getOriginY();
        
        double expResultDirection=50;
        double resultDirection=result.getDirection();
        
        double expResultMoment=50;
        double resultMoment=result.getMomentum();
        double delta=1e-8;
        
        assertEquals("Works", expResultX, resultX, delta);
        assertEquals(expResultY, resultY, delta);
        assertEquals(expResultDirection, resultDirection, delta);
        assertEquals(expResultMoment, resultMoment, delta);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}

    /**
     * Test of setOrientation method, of class Weapon.
     */
    