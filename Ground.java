import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Mover
{
    private final GreenfootImage levelGround = new GreenfootImage("New Background.png");
    private final GreenfootImage platform = new GreenfootImage("floating-platform.gif");
    private final GreenfootImage block = new GreenfootImage("block.png");
    private int select;
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ground(int select)
    {
        this.select = select;
        if(select==1)
        {
            setImage(levelGround);
            
        }
        else if((select==2)||(select==3))
        {
            setImage(platform);
            platform.scale(120,30);
        }
        else if(select==4)
        {
            setImage(block);
        }
    }
    
    public void act() 
    {
       if(select==1)
        {
            
            
        }
        else if(select==2)
        {
           
        }
        else if(select==3)
        {
           movementCounter ++;
           movePlatformX();
        } 
         else if(select==4)
        {
            setImage(block);
        }
    }    
}
