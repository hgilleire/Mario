import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mushroom3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadMushroom extends AddableObjects{

    private GreenfootImage evilMushroom = new GreenfootImage("evilMushroom1.png");
    private int vSpeed = 0;
    private boolean onGround;
    private int acceleration = 2;
    private boolean facingLeft;
    private int speed;
     public BadMushroom()
    {
        speed = 1;
        setImage(evilMushroom);
        facingLeft=false;
        
    }
   
    public void act() 
    {
        checkFall();  
        if(atWorldEdge())
          {
              turn(180);
              getImage().mirrorVertically();
          }
         move(speed);
          moveRight(speed);
          turn();
          moveLeft(speed);   
        
    } 
    
    public void moveRight(int speed)
    {
       if (!facingLeft)
         setLocation (getX() + speed, getY());
    }
    
    public void moveLeft(int speed)
    {
          if (facingLeft)
              setLocation (getX() - speed, getY());   
          
    }
    
   
    public void turn()
    {
    
        if (atWorldEdge())//||(getOneIntersectingObject(grass.class)!=null)||(getOneIntersectingObject(Block.class)!=null))
        {
          
            turn(180);            
            getImage().mirrorVertically();
            
            
        }
        facingLeft =!facingLeft;
        move(speed);
     
    }
    
    
    /*public void  hitMario()
    {
        Actor mario = getOneIntersectingObject(Mario.class);
        if (mario !=null)
        {
            getWorld().removeObject(this);
            
        }
    }*/
    
    public boolean onGround()
    {
        Actor ground = getOneIntersectingObject(Ground.class);
        if(ground != null)
        {
            onGround = true;
        }
        else
        {
            onGround = false;
        }
        return onGround;
    } 
    
    public void fall()
    {
        setLocation(getX(), getY() +vSpeed);
        vSpeed = vSpeed + acceleration;
        
    }
    
    public void checkFall()
    {
         if(onGround())
         {
             vSpeed = 0;
         }
         else
         {
             fall();
         }
    }
    
    /*public void hitObstacle()
    {
        {
        Actor grass = getOneIntersectingObject(grass.class);
        Actor block = getOneIntersectingObject(Block.class);
       
        if ((grass!=null)&&(facingLeft))
        {   
            setLocation(grass.getX()+getImage().getWidth()-1,getY());
            getImage().mirrorVertically();
            turn(180);
            
            move(speed);
        }
        
        else if ((block!=null)&&(facingLeft))
        {   
            setLocation(block.getX()+getImage().getWidth()-1,getY());
            getImage().mirrorVertically();
            turn(180);
            
            move(speed);
        }
        else if ((grass!=null)&&(!facingLeft))
        {   
            setLocation(grass.getX()-getImage().getWidth(),getY());
            getImage().mirrorVertically();
            turn(180);
            
            move(speed);
        }
        
        else if ((block!=null)&&(!facingLeft))
        {   
            setLocation(block.getX()-getImage().getWidth(),getY());
            getImage().mirrorVertically();
            turn(180);
            
            move(speed);
        }
        
      }
    }*/
    private boolean atWorldEdge()  
    {  
        return (getX()==0 ||  getY()==0 || getX()==getWorld().getWidth()-1 || getY()==getWorld().getHeight()-1);  
    }
}