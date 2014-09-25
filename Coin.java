import greenfoot.*;
public class Coin extends AddableObjects
{
   
    private GreenfootImage coin = new GreenfootImage("coin.gif");
    /* timeOnScreen is a counter used to decide how long a coin has before
     * it disappears. Note that this time will depend on speed that the 
     * game is played at.
     */
    private int timeOnScreen;
    
    /**
     * Creates a Coin Object with a coin image and a timeOnScreen of 300
     */
    public Coin()
    {
        setImage(coin);
        timeOnScreen=300;
    }
    
   
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment. 
     * The coin's timeOnScreen is constantly reduced
     * and the Coin keeps checking to see if it is time to disappear.
     */
    public void act() 
    {
        timeOnScreen--;
        checkIfTimeToDisappear();        
    }    
    
    /**
     * Check if timeOnScreen is less than 0, 
     * if it is remove the coin from the World.
     */
    public void checkIfTimeToDisappear()
    {   
        if(timeOnScreen<0)
        {
            getWorld().removeObject(this);   
        }  
    }
    
     /**
     * return Coin's timeOnScreen.
     * @return timeOnScreen
     */
    public int getTimeOnScreen()
    {
        return timeOnScreen;
    }
    
}