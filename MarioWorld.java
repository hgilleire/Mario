import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MarioWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MarioWorld extends World
{
    public int x =0;
    private int threshold = 100;
    private Mario mario;
    public static ScoreBoard newBoard;
    public GameOver gameOver;
    public static int number;
   
    /**
     * Constructor for objects of class MarioWorld.
     *
     */
    public MarioWorld()
    {
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(2000,600, 1);
        mario = new Mario();
        Greenfoot.setSpeed(50);
        //Greenfoot.start();       
        prepare();
        populate();
        setPaintOrder(HitBlock.class, Mario.class);

    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    protected void prepare()
    {
        Ground ground = new Ground(1);
        addObject(ground, 184, 563);
        Ground ground2 = new Ground(1);
        addObject(ground2, 983, 563);
        
        addObject(mario, 39,479);
        newBoard = new ScoreBoard();
        addObject(newBoard, 100, 70);


    }

    public void act()
    {
        checkMario();
        x++;
        if(x%threshold==0)
        {
            populate();
        }

    }
    
    public void checkMario()    
    {
       if(newBoard.getLives()==0)
       {
           removeObjects(getObjects(Mario.class));
       }
       if(getObjects(Mario.class).isEmpty())
        {
            
            removeObjects(getObjects(null));             
            addObject(new GameOver(), 500, 250);
            Greenfoot.playSound("game-over.mp3");
            Greenfoot.stop();
            return; 
        }
    }

    private void populate()
    {

        int y = 330;
        int x = Greenfoot.getRandomNumber(getWidth());

        Coin coin = new Coin();
        addObject(coin,x,y);

    }

}
