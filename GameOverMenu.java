package cargame;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Christian Abuda
 */
public class GameOverMenu{
    int gameOverMenuX = 100;
    int gameOverMenuY = 200;
    
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 80));
        g.drawString("GAME OVER", gameOverMenuX, gameOverMenuY + 110);
    }
}
