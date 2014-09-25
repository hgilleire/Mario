import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MarioRight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Mover

{
    
    private GreenfootImage right = new GreenfootImage("MarioRight.png");
    private GreenfootImage left = new GreenfootImage("marioLeft.png");
    private GreenfootImage clear = new GreenfootImage("nothing.png");
    private GreenfootImage fire = new GreenfootImage("FireMarioJump.png");
    private GreenfootImage fireleft = new GreenfootImage("FireMarioJump_left.png");
    private GreenfootImage groundHeight = new GreenfootImage("New Background.png");
    private int speed;
    private boolean superjump;
    
    private GreenfootImage[] right_images = new GreenfootImage[3]; 
    private GreenfootImage[] left_images = new GreenfootImage[3]; 
    
    private GreenfootImage[] right_imagesFire = new GreenfootImage[3]; 
    private GreenfootImage[] left_imagesFire = new GreenfootImage[3]; 
    
    private int x = 0;
    private int threshold = 300;
    private int vSpeed = 0;
    private int acceleration = 2;
    private boolean jumping;
    private int jumpStrength = -25;
    private int atime = 0;
    private int marioBottomCenter;
    private boolean facingLeft=false; 
    private boolean isKeyPressed;
    private boolean exists=true;
    private boolean onGround;
    private boolean onBlock;
    private boolean fireMario;
    /**
     * Act - do whatever the MarioRight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Mario()
    {
        
        right_images[0] = new GreenfootImage( "MarioRight.png" ); 
        right_images[1] = new GreenfootImage( "mario_walk_right.png" );  
        right_images[2] = new GreenfootImage( "mario_run_right.png" );  
        
        left_images[0] = new GreenfootImage( "marioLeft.png" ); 
        left_images[1] = new GreenfootImage( "mario_walk_left.png" );  
        left_images[2] = new GreenfootImage( "mario_run_left.png" );          
               
        right_imagesFire[0] = new GreenfootImage( "Firemario_walk.png" ); 
        right_imagesFire[1] = new GreenfootImage( "FireMarioJump.png" );  
        right_imagesFire[2] = new GreenfootImage( "FireMarioLeapingRight.png" );  
        
        left_imagesFire[0] = new GreenfootImage( "Firemario_walk_left.png" ); 
        left_imagesFire[1] = new GreenfootImage( "FireMarioJump_left.png" );  
        left_imagesFire[2] = new GreenfootImage( "FireMarioLeapingLeft.png" );  
        
        
        setImage(right_images[0]);       
        setSpeed(5);
        superjump = false;
        jumping = false;
        fireMario = false;
                
    }
    
    public void setSpeed(int valueIn)
    {
        speed = valueIn;
    }
    
    public void act() 
    {      
          checkKeys();                         
          checkFall();
          animation();
          animationFireMario();
          if(getWorld()!=null && !hitGround())
            {
               fall();
        
            }
            else
            {
                jumping = false;
            }       
            hitCoin();
            hitKoopaTrooper();           
            hitBlock();
            hitQBlock();
            hitOldQBlock();
            hitFlower();
            hitCannon();
            hitMushroom();
            hitBadMushroom();
            hitGround();
            
       
    } 
    
    public void animation()  
    { 
        if(!fireMario)
        {
            if (Greenfoot.isKeyDown("left")) facingLeft = true;  
            if (Greenfoot.isKeyDown("right")) facingLeft = false;  
            
            if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")) atime = atime + 1;  
            if(atime==12)
            atime=0;
            
            if ((atime%4==0)&&(Greenfoot.isKeyDown("right") ))
            {
               
                setImage( right_images[atime/4] ); 
              
            }
            
            if ((atime%4==0)&&(Greenfoot.isKeyDown("left") ))
            {
               
                setImage( left_images[atime/4] ); 
               
            }
            
            if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right"))
            {      
                if (facingLeft)
                    setLocation (getX() - speed, getY());   
                if (!facingLeft)
                    setLocation (getX() + speed, getY());
            }
    }
        
    }  
    
     public void animationFireMario()  
    { if(fireMario)
        {
            if (Greenfoot.isKeyDown("left")) facingLeft = true;  
            if (Greenfoot.isKeyDown("right")) facingLeft = false;  
            
            if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")) atime = atime + 1;  
            if(atime==12)
            atime=0;
            
            if ((atime%4==0)&&(Greenfoot.isKeyDown("right") ))
            {
               
                setImage( right_imagesFire[atime/4] ); 
               
            }
            
            if ((atime%4==0)&&(Greenfoot.isKeyDown("left") ))
            
               
                setImage( left_imagesFire[atime/4] ); 
               
            }
            
      if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right"))
            {      
                if (facingLeft)
                    setLocation (getX() - speed, getY());   
                if (!facingLeft)
                    setLocation (getX() + speed, getY());
            }
    }
      
     
     /**
     * Check what keys are pressed to control Mario
     */ 
    public void checkKeys()
    {    
         if ((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right")) && ((Greenfoot.isKeyDown(" ")) && jumping == false ))
        {
           
            jump();
        }
        
         else if (Greenfoot.isKeyDown(" ") && jumping == false)  
        {
            jump();
        }
        
        if ("z".equals(Greenfoot.getKey()))
            
        {
            shoot();
        }
    }
    
    /**
     * Apply gravity to make Mario fall
     */
    public void fall()
    {
        setLocation(getX(), getY() +vSpeed);
        vSpeed = vSpeed + acceleration;
        jumping = true;
        hitGround();
        
        
    }
   
    public void jump()
    {
        if(superjump)
        {
         jumpStrength = -35;
        }
        else
        {
         jumpStrength = -25;
         }
         vSpeed = vSpeed + jumpStrength;
         Greenfoot.playSound("mario_jumps.wav"); 
         fall();
            
    }
             
    public void checkFall()
    {
         
         if(hitGround())
         {
             vSpeed = 0;
             jumping = false;
         }
         else
         {
             fall();
            
         }
             
     }
    
    
    public void hitCoin()
    {
        Actor coin = getOneIntersectingObject(Coin.class);  
        if (coin != null)  
        {  
           Greenfoot.playSound("collect_coin.wav");
           getWorld().removeObject(coin);
           MarioWorld.newBoard.updateScore(2,0);
        }  
    }  
      
    public void shoot()
    {
       if(fireMario && !facingLeft)
       {
           Fireball fire = new Fireball();
           getWorld().addObject(fire, getX(), getY());
       }
       
       if(fireMario && facingLeft)
       {
           Fireball fire = new Fireball();
           getWorld().addObject(fire, getX(), getY());
           fire.setRotation(180);
       }
    }
    
    public  void  hitKoopaTrooper()
    {
        Actor KoopaTrooper = getOneIntersectingObject(KoopaTrooper.class);
           
        if (KoopaTrooper !=null)
        {
            if(getY() >470 && getY() <490){
              hitEnemy();
              }
               else 
               {
                  getWorld().removeObject(KoopaTrooper);
                 
               }
           }
       }
     
   public boolean  hitGround()
    {
        Actor block1 = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
        Actor block = getOneObjectAtOffset(0, getImage().getHeight()/-2,Ground.class);        
        Actor block3 = getOneObjectAtOffset(getImage().getWidth()/-2,0,Ground.class);
        Actor block4 = getOneObjectAtOffset(getImage().getHeight()/2,0, Ground.class);
       if(block1 != null)
        {
          vSpeed = 1;
          moveToGround(block1);         
        }
       else 
       if(block != null)
        {
            vSpeed = 1;
            bopHead(block);
        }
        else if(block3 != null)
        {
            stopAtLeftWall(block3);
        }
        else if(block4 != null)
        {
            stopAtRightWall(block4);
        }
        return block != null || block3 != null || block4 != null ;
    }
    
   public boolean  hitBlock()
    {
        Actor block = getOneObjectAtOffset(0, getImage().getHeight()/-2,Block.class);
        Actor block1 = getOneObjectAtOffset(0, getImage().getHeight()/2, Block.class);
        Actor block3 = getOneObjectAtOffset(getImage().getWidth()/-2,0,Block.class);
        Actor block4 = getOneObjectAtOffset(getImage().getHeight()/2,0, Block.class);
       if(block != null)
        {
          vSpeed = 1;
          bopHead(block);
        }
        
       if(block1 != null)
        {
            vSpeed = 1;
            moveToGround(block1);
        }
        
       if(block3 != null)
        {
            stopAtLeftWall(block3);
        }
        
       if(block4 != null)
        {
            stopAtRightWall(block4);
        }
        return block1 != null || block3 != null || block4 != null ;
    }
    
   public void bopHead(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() + (groundHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
    }      
                 
  public boolean  hitQBlock()
    {
        Actor block = getOneObjectAtOffset(0, getImage().getHeight()/-2,QBlock.class);
        Actor block1 = getOneObjectAtOffset(0, getImage().getHeight()/2, QBlock.class);
        Actor block3 = getOneObjectAtOffset(getImage().getWidth()/-2,0,QBlock.class);
        Actor block4 = getOneObjectAtOffset(getImage().getHeight()/2,0, QBlock.class);
       if(block != null)
        {
          vSpeed = 1;
          bopHead(block);
        }
       else 
       if(block1 != null)
        {
            vSpeed = 1;
            moveToGround(block1);
        }
        else if(block3 != null)
        {
            stopAtLeftWall(block3);
        }
        else if(block4 != null)
        {
            stopAtRightWall(block4);
        }
        return block1 != null || block3 != null || block4 != null ;
    }
    
    public boolean  hitOldQBlock()
    {
        Actor block = getOneObjectAtOffset(0, getImage().getHeight()/-2,HitBlock.class);
        Actor block1 = getOneObjectAtOffset(0, getImage().getHeight()/2, HitBlock.class);
        Actor block3 = getOneObjectAtOffset(getImage().getWidth()/-2,0,HitBlock.class);
        Actor block4 = getOneObjectAtOffset(getImage().getHeight()/2,0, HitBlock.class);
       if(block != null)
        {
          vSpeed = 1;
          bopHead(block);
        }
       else 
       if(block1 != null)
        {
            vSpeed = 1;
            moveToGround(block1);
        }
        else if(block3 != null)
        {
            stopAtLeftWall(block3);
        }
        else if(block4 != null)
        {
            stopAtRightWall(block4);
        }
        return block1 != null || block3 != null || block4 != null ;
    }
    
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
        jumping = false;
    }
    
    public boolean checkRightWall()
    {
        //Actor ground = getOneObjectAtOffset(getImage().getWidth()/2, 0, Ground.class);
        Actor block = getOneObjectAtOffset(getImage().getWidth()/2, 0, Block.class);
        Actor hitblock = getOneObjectAtOffset(getImage().getWidth()/2, 0, HitBlock.class);
       /* if(ground != null)
        {
           stopAtRightWall(ground);
        }*/
        if(block != null)
        {
            stopAtRightWall(block);
        }
        if(hitblock != null)
        {
            stopAtRightWall(hitblock);
        }
       return block != null|| hitblock != null;
    }
    
     public void stopAtRightWall(Actor rightWall)
    {
        int wallWidth = rightWall.getImage().getWidth() + 5;
        int newX = rightWall.getX() - (wallWidth + getImage().getHeight())/2;
        
        setLocation(newX, getY());
    }
    
     public boolean checkLeftWall()
    {
        //Actor ground = getOneObjectAtOffset(getImage().getWidth()/-2, 0, Ground.class);
        Actor block = getOneObjectAtOffset(getImage().getWidth()/-2, 0, Block.class);
        Actor hitblock = getOneObjectAtOffset(getImage().getWidth()/-2, 0, HitBlock.class);/*
        if(ground != null)
        {
           stopAtLeftWall(ground);
        }*/
        if(block != null)
        {
            stopAtLeftWall(block);
        }
        if(hitblock != null)
        {
            stopAtLeftWall(hitblock);
        }
        return block != null|| hitblock != null;
    }
    
    public void stopAtLeftWall(Actor leftWall)
    {
        int wallWidth = leftWall.getImage().getWidth() - 5;
        int newX = leftWall.getX() + (wallWidth + getImage().getHeight())/2;
        
        setLocation(newX, getY());
    }
      
    public void  hitMushroom()
    {
        Actor mushroom = getOneIntersectingObject(Mushroom.class);
        if (mushroom !=null)
        {
            superjump = true; 
            MarioWorld.newBoard.updateScore(2,0);
            getWorld().removeObject(mushroom);
        }
    }
    
    public  void  hitBadMushroom()
    {
        Actor BadMushroom = getOneIntersectingObject(BadMushroom.class);
           
        if (BadMushroom !=null)
        {
            if(getY() >470 && getY() <490){
              hitEnemy();
              }
               else 
               {
                  getWorld().removeObject(BadMushroom);
                 
               }
           }
       }
    
    public void hitEnemy()
    {
         Greenfoot.playSound("mario_touch_enemy.wav");
         MarioWorld.newBoard.updateScore(0,-1); 
         superjump = false;
         if(fireMario)
         {
             fireMario = false;                         
             if(!facingLeft)
              setImage(right);
              if(facingLeft)
              setImage(left);
         }
               setLocation(39, 379);
    }
    
    public void  hitFlower()
      {
           Actor flower = getOneIntersectingObject(Flower.class);
           if (flower!=null)
           { fireMario=true;
              if(!facingLeft)
              setImage(fire);
              if(facingLeft)
              setImage(fireleft);
           }
       }
     
   
     public void hitCannon()
    {
        Actor cannon = getOneIntersectingObject(CannonHead.class);
        if(cannon != null)
        {
            if(getY()+getImage().getHeight()/2 < cannon.getY()+2 )
            {
                getWorld().removeObject(cannon);
                MarioWorld.newBoard.updateScore(5,0);
            }
            else
            {
                setLocation(39, 379);
                getWorld().removeObject(cannon);
                MarioWorld.newBoard.updateScore(-10,-1);
            }
        }
    }
}
