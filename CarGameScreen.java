package cargame;

import javax.swing.JFrame;

/**
 *
 * @author Christian Abuda
 */
public class CarGameScreen extends JFrame {
    //JFrame Code
    public CarGameScreen(){
        JFrame screen = new JFrame();
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.add(new GamePanel());
        screen.pack();
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
        
        setTitle("Car Game");
    }       
    public static void main(String[] args) {
        new CarGameScreen();
    }
    
}
