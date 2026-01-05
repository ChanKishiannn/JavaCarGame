package cargame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameOverMenu {
    //Game Over Pop up Attributes    
    int buttonMenuX = 100;
    int buttonMenuY = 200;

    //Restart Pop up Attributes
    int restartWidth = 200;
    int restartHeight = 40;

    // Restart button position
    int restartX = buttonMenuX + 150;
    int restartY = buttonMenuY + 170;
    
    //Exit Button Size
    int exitButtonWidth  = 200;
    int exitButtonHeigth = 40;
    
    
    //Exit Button Detector Code
    public boolean isExitClicked(int mouseX, int mouseY){
        int exitbuttonX = buttonMenuX + 150;
        int exitbuttonY = buttonMenuY + 220;
        
        return mouseX >= exitbuttonX &&
               mouseX <= exitbuttonX + exitButtonWidth &&
               mouseY >= exitbuttonY &&
               mouseY <= exitbuttonY + exitButtonHeigth;
    }

    //Restart Button spawn point
    public boolean isRestartClicked(int mouseX, int mouseY){
        return mouseX >= restartX &&
               mouseX <= restartX + restartWidth &&
               mouseY >= restartY &&
               mouseY <= restartY + restartHeight;
    }

    //Game Over Pop up
    public void draw(Graphics g){
        // GAME OVER text
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 80));
        g.drawString("GAME OVER", buttonMenuX, buttonMenuY + 110);

        // Restart button box
        g.setColor(Color.WHITE);
        g.drawRect(restartX, restartY, restartWidth, restartHeight);

        // Restart text
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Restart", restartX + 40, restartY + 30);
        
        // Exit Button Box
        g.setColor(Color.WHITE);
        g.drawRect(buttonMenuX + 150, buttonMenuY + 220, exitButtonWidth, exitButtonHeigth);
        
        // Exit text
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Exit Game", buttonMenuX + 180, buttonMenuY + 250);
    }
}
