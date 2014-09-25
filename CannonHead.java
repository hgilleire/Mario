import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CannonHead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CannonHead extends Actor
{
    private long startTime;
    private int repeat;
    /**
     * Act - do whatever the CannonHead wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move(-5);
       
       if(this != null)
       {
           if(atWorldEdge())
           {
               turn(180); 
               getImage().mirrorVertically();
            }   
        }  
        
        
    }    
    
   private boolean atWorldEdge()  
    {  
        return (getX()==0 ||  getY()==0 || getX()==getWorld().getWidth()-1 || getY()==getWorld().getHeight()-1);  
    }
        
    
}
    
    

