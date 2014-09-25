import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QBlock extends AddableObjects
{
    /**
     * Act - do whatever the QBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage hitqblock = new GreenfootImage("hitblock.png");
    public QBlock()
    {
        setImage("Qblock.png");
    }
    
        
    public void act() 
    {
       hitMario();
    } 
    
    public void  hitMario()
    {
        Actor mario = getOneObjectAtOffset(0, getY() + getImage().getHeight()/2 + 5, Mario.class);
        
        HitBlock hitblock = new HitBlock();
        Flower flower = new Flower();
        Mushroom shroom = new Mushroom();
        if (mario !=null)
        {
            int random = Greenfoot.getRandomNumber(10);
            if(random%2 == 0)
            {
                getWorld().addObject(flower, getX(), getY()-getImage().getHeight()-5);
                getWorld().addObject(hitblock, getX(), getY());
                getWorld().removeObject(this);
            }
            else 
            {
                getWorld().addObject(shroom, getX(), getY()-getImage().getHeight()-5);
                getWorld().addObject(hitblock, getX(), getY());
                getWorld().removeObject(this);
            }
            
        }
    }
    
    
}

