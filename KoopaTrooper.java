import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KoopaTrooper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KoopaTrooper extends Mover

{
    private GreenfootImage right= new GreenfootImage("koopaRight.png");
    //private GreenfootImage left= new GreenfootImage("koopaLeft.png");
    private int speed;
    private boolean facingLeft;
    private boolean onGround;
    public KoopaTrooper()
    {
        speed = 1;
        setImage(right);
        facingLeft=false;
        
    }
    
    /**
     * Act - do whatever the KoopaTrooper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
    */
    public void act() 
    {   
        onGround();
        move(speed);
        moveRight(speed);
        hitObstacle();
        turn();
        moveLeft(speed);              
        atWorldEdge();
                
    }
    
     public boolean onGround()
    {
        if((getY()!=0))
        {
            setLocation(getX(),501);
            
            onGround = true;
        }
        return onGround;
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
    
   public void hitObstacle()
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
    
    private boolean atWorldEdge()  
    {  
        return (getX()==0 ||  getY()==0 || getX()==getWorld().getWidth()-1 || getY()==getWorld().getHeight()-1);  
    }
  /*  public void turn()
    {   
        turn(180);
        getImage().mirrorVertically();
    }
            else if(this.getImage() == left)
            {
                direction = -1;
                setImage(right);
                move(10);
            }
        }
       move(5*direction);
    }*/
}
