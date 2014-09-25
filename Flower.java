import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flower extends AddableObjects
{
    public static int flowers = 1;
    /**
     * Act - do whatever the Flower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public Flower()
    {
       flowers = 1;
    }
    
    public void act() 
    {
        
        hitMario();
        
    }
    
    public void hitMario()
    {
        Actor mario = getOneIntersectingObject(Mario.class);
        if(mario != null)
        {
            getWorld().removeObject(this);
            flowers = 0;
        }
    }
    
    
}


