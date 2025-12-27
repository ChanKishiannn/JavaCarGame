package cargame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Christian Abuda
 */
public class PlayerCar {
    //Player Car Properties
    int playerCarX = 330;
    int playerCarY = 850;
    int playerCarWidth = 50;
    int playerCarHeigth = 100;
    
    //Player Car Movement
    boolean moveLeft = false;
    boolean moveRight = false;
    int speed = 8;
    
    //Player Car Code
    public void draw(Graphics g){
        //Car Wheels Left Upper
        g.setColor(Color.BLACK);
        g.fillRect(playerCarX - 10, playerCarY + 10, playerCarWidth - 10, playerCarHeigth - 75);
        
        //Car Wheels Right Upper
        g.setColor(Color.BLACK);
        g.fillRect(playerCarX + 20, playerCarY + 10, playerCarWidth - 10, playerCarHeigth - 75);
        
        //Car Wheels Left Lower
        g.setColor(Color.BLACK);
        g.fillRect(playerCarX - 10, playerCarY + 60, playerCarWidth - 10, playerCarHeigth - 75);
        
        //Car Wheels Right Lower
        g.setColor(Color.BLACK);
        g.fillRect(playerCarX + 20, playerCarY + 60, playerCarWidth - 10, playerCarHeigth - 75);
        
        //Car Body
        g.setColor(Color.YELLOW);
        g.fillRect(playerCarX, playerCarY, playerCarWidth, playerCarHeigth);
        
        //Car Window
        g.setColor(Color.BLACK);
        g.fillRect(playerCarX + 5, playerCarY + 15, playerCarWidth - 10, playerCarHeigth - 85);
    }
    
    //Car Movement Code Update
    public void update(){
        //Player Movement
        if(moveLeft){
            playerCarX -= speed;
        }
        
        if(moveRight){
            playerCarX += speed;
        }
    }
}
