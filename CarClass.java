package cargame;


import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Christian Abuda
 */
public class CarClass {
    //Car Attributes
    int carX = 330;
    int carY = 850;
    int carWidth = 50;
    int carHeigth = 100;
    
    //Car Physics Attributes
    double gravity = 0.10;
    double velocity = 0;
    
    public CarClass(int x, int y){
        this.carX = x;
        this.carY = y;
    }
    
    //Car Physics Applied
    public void update(){
        velocity += gravity;
        carY += velocity;
    }
    
    //Car Drawing
    public void draw(Graphics g){
        //Car Wheels Left Upper
        g.setColor(Color.BLACK);
        g.fillRect(carX - 10, carY + 10, carWidth - 10, carHeigth - 75);
        
        //Car Wheels Right Upper
        g.setColor(Color.BLACK);
        g.fillRect(carX + 20, carY + 10, carWidth - 10, carHeigth - 75);
        
        //Car Wheels Left Lower
        g.setColor(Color.BLACK);
        g.fillRect(carX - 10, carY + 60, carWidth - 10, carHeigth - 75);
        
        //Car Wheels Right Lower
        g.setColor(Color.BLACK);
        g.fillRect(carX + 20, carY + 60, carWidth - 10, carHeigth - 75);
        
        //Car Body
        g.setColor(Color.darkGray);
        g.fillRect(carX, carY, carWidth, carHeigth);
        
        //Car Window
        g.setColor(Color.BLACK);
        g.fillRect(carX + 5, carY + 15, carWidth - 10, carHeigth - 85);
    }
}
