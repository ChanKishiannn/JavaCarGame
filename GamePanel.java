package cargame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Christian Abuda
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener{
    //Screen Code
    final int screenWidth = 700;
    final int screenHeight = 1000;
    
    //FPS Timer ~60 FPS
    Timer timer = new Timer(16, this);
    
    //Map Code
    MapClass map = new MapClass();
    
    //Player Code
    PlayerCar playerCar = new PlayerCar();
    
    //Start Game Menu
    StartMenu startGameMenu = new StartMenu();
    boolean startGame = false;
    boolean exitGame = false;
    
    //Game Over Menu
    GameOverMenu gameOverMenu = new GameOverMenu();
    boolean gameOver = false;
    
    
    //=================================Game Main Logic Code Here============================================//
    //Start Code Here
    public void startGame(){
        startGame = true;
        gameOver = false;
        exitGame = false;
        
        map = new MapClass();
        playerCar = new PlayerCar();
        
        timer.start();
    }
    
    //Exit Code Here
    public void exitGame(){
        System.exit(0);
        
    }
    
    //Restart Code Here
    public void restartGame(){
        gameOver = false;
        startGame = true;
        exitGame = false;
        
        map = new MapClass();
        playerCar = new PlayerCar();
        
        timer.start();
    }
    
    //GamePanel Code
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        setFocusable(true);
        addKeyListener(this);
        timer.start();
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                handleMouseClick(e.getX(), e.getY());
            }
        });
    }
    
    //Mouse Click Detector
    public void handleMouseClick(int mouseX, int mouseY) {
        //GameStart Button Detector
        if(!startGame && startGameMenu.isStartClicked(mouseX, mouseY)){
            startGame();
        }
        //GameExit Button Detector
        if(!exitGame && startGameMenu.isExitClicked(mouseX, mouseY)){
            exitGame();
        }
        //Restart Button Detector
        if(gameOver && gameOverMenu.isRestartClicked(mouseX, mouseY)){
            restartGame();
        }
        //Exit Button Detector in Game Over
        if(gameOver && gameOverMenu.isExitClicked(mouseX, mouseY)){
            exitGame();
        }
    }
    
    
    //Game Logic Code
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        map.draw(g);
        playerCar.draw(g);
        
        if(!startGame){
            startGameMenu.draw(g);
        }
        if(gameOver){
            gameOverMenu.draw(g);
        }
    }
    
    //Player Car Function
    @Override
    public void actionPerformed(ActionEvent e){
        if(startGame && !gameOver){
            map.update();
            playerCar.update();
            
            if(map.checkCollitionCar(playerCar)){
                gameOver = true;
                timer.stop();
            }
            map.checkCollitionOffLimit(playerCar);
        }
        repaint();
    }
    
    //Player Input Code Here
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
