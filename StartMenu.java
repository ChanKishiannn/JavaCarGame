package cargame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Christian Abuda
 */
public class StartMenu {
    //Start Menu Pop up Attribute
    int buttonMenuX = 100;
    int buttonMenuY = 200;
    
    //Start Button Size
    int startButtonWidth = 200;
    int startButtonHeigth = 40;
    
    //Exit Button Size
    int exitButtonWidth  = 200;
    int exitButtonHeigth = 40;
    
    //Start Button Detector Code
    public boolean isStartClicked(int mouseX, int mouseY){
        int startbuttonX = buttonMenuX + 150;
        int startbuttonY = buttonMenuY + 150;
        
        return mouseX >= startbuttonX &&
               mouseX <= startbuttonX + startButtonWidth &&
               mouseY >= startbuttonY &&
               mouseY <= startbuttonY + startButtonHeigth;
    }
    
    //Exit Button Detector Code
    public boolean isExitClicked(int mouseX, int mouseY){
        int exitbuttonX = buttonMenuX + 150;
        int exitbuttonY = buttonMenuY + 200;
        
        return mouseX >= exitbuttonX &&
               mouseX <= exitbuttonX + exitButtonWidth &&
               mouseY >= exitbuttonY &&
               mouseY <= exitbuttonY + exitButtonHeigth;
    }
    
    public void draw (Graphics g){
        //Game Name Pop up
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 80));
        g.drawString("Car Rush!", buttonMenuX + 50, buttonMenuY + 110);
        
        // Start button box
        g.setColor(Color.WHITE);
        g.drawRect(buttonMenuX + 150, buttonMenuY + 150, startButtonWidth, startButtonHeigth);

        // Start text
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Start Game", buttonMenuX + 170, buttonMenuY + 180);
        
        // Exit Button Box
        g.setColor(Color.WHITE);
        g.drawRect(buttonMenuX + 150, buttonMenuY + 200, exitButtonWidth, exitButtonHeigth);
        
        // Exit text
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Exit Game", buttonMenuX + 180, buttonMenuY + 230);
    }
}
