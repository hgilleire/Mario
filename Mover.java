import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends AddableObjects
{
    protected int speed;
    protected int animation;
    protected int select;
    protected int movementCounter;
    /**
     * Act - do whatever the Mover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    protected void moveRight()
    {
        setLocation(getX()+speed, getY());
    }
    
    protected void moveLeft()
    {
        setLocation(getX()-speed, getY());
    }
    
    protected void movePlatformX()
    {
        speed = 2;
        if(movementCounter<=150)
        {
            setLocation(getX(), getY() - 1);
            Actor Mario = getOneIntersectingObject(Mario.class);
            setLocation(getX(), getY() + 1);
            moveLeft();
            if(Mario!=null)
            {
                Mario.setLocation(Mario.getX()-speed, Mario.getY());
            }
        }
        else if(movementCounter<=300)
        {
             setLocation(getX(), getY() - 1);
            Actor Mario = getOneIntersectingObject(Mario.class);
            setLocation(getX(), getY() + 1);
            moveRight();
            if(Mario!=null)
            {
                Mario.setLocation(Mario.getX()+speed, Mario.getY());
            }
        }
        movementCounter++;
         if(movementCounter>=300)
        {
           movementCounter=0;
        }
       
    }
    
}
