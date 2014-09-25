import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends AddableObjects
{
    private GreenfootImage block = new GreenfootImage("block.png");
    private boolean onGround;
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(block);
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
