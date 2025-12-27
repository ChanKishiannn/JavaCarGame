package cargame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Christian Abuda
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener{
    //FPS Timer ~60 FPS
    Timer timer = new Timer(16, this);
    
    //Map Code
    MapClass map = new MapClass();
    
    //Player Code
    PlayerCar playerCar = new PlayerCar();
    
    //Game Over Menu
    GameOverMenu gameOver = new GameOverMenu();
    
    //Screen Code
    final int screenWidth = 700;
    final int screenHeight = 1000;
    
    
    //=============================================================================//
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }
    
    
    //Game Logic Code
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        map.draw(g);
        playerCar.draw(g);
        
        if(!timer.isRunning()){
            gameOver.draw(g);
        }
    }
    
    //Player Car Function
    @Override
    public void actionPerformed(ActionEvent e){
        map.update();
        playerCar.update();
        
        //Collition Checker
        if(map.checkCollition(playerCar)){
            timer.stop();
        }
        repaint();
    }
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_A) playerCar.moveLeft = true;
        if(key == KeyEvent.VK_D) playerCar.moveRight = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) playerCar.moveLeft = false;
        if (key == KeyEvent.VK_D) playerCar.moveRight = false;
    }
    
    @Override 
    public void keyTyped(KeyEvent e) {}
}
