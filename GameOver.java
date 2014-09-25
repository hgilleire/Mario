import greenfoot.*;  
import java.awt.Color;  
      
public class GameOver extends NotAddableObjects 
{  
    String gameOver = "GAME OVER. YOUR SCORE IS: " + MarioWorld.newBoard.getPoints()+"\n"+"Click reset if you want to play again"; 
      
    public GameOver()  
    {  
        updateImage();  
    }  
    
    private void updateImage()  
    {  
         GreenfootImage image = new GreenfootImage(1000, 700); 
         image.setColor(Color.yellow); 
         image.fill();  
         GreenfootImage text = new GreenfootImage(gameOver, 48, Color.black, new Color(0, 0, 0, 0));  
         image.drawImage(text, 300, 250);  
         setImage(image);  
    }  
}  