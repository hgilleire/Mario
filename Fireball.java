import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
               
             move(7);
             hitKoopaFire();
             if(hitKoopaFire())
             {
                 getWorld().removeObject(this);
                 return;
             }
             if(atWorldEdge())
             {
                 getWorld().removeObject(this);  
                 return;
             }
             
    } 
    
    public boolean hitKoopaFire()
    {
        boolean hit;
        
        Actor koopa = getOneIntersectingObject(KoopaTrooper.class);
               
                if(koopa != null)
                {
                    hit = true;
                    getWorld().removeObject(koopa);                     
                }
                else
                {
                    hit = false;    
                }
        return hit;
    }
    
    private boolean atWorldEdge()  
    {  
        return (getX()==0 ||  getY()==0 || getX()==getWorld().getWidth()-1 || getY()==getWorld().getHeight()-1);  
    }
}
