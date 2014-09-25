import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class grass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class grass extends AddableObjects
{
    public boolean onGround;
    /**
     * Act - do whatever the grass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        onGround();
    }
    
     public boolean onGround()
    {
        if(getY()>505)
        {
            setLocation(getX(), 509);
            onGround=true;
        }
        return onGround;
    }
}
