import greenfoot.*;
import java.awt.*; 
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends NotAddableObjects
{
    private int points;
    private int lives;
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ScoreBoard() 
    {
       points = 0;
       lives = 3;
       setImage(new GreenfootImage("Score = 0 "+"Lives = 3", 30,Color.BLACK,null));
      
    }
    
        
    public void updateScore(int num, int num2)
    {
        points = points+num;
        lives = lives+num2;
                  
        setImage(new GreenfootImage("Score = "+points+" Lives = "+lives, 30,Color.BLACK,null));
       
    }
    
    public int getPoints()
    {
        return points;
    }
    
     public int getLives()
    {
        return lives;
    }
    
   
}
