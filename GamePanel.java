package cargame;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Christian Abuda
 */
public class GamePanel extends JPanel{
    //Screen Code
    final int screenWidth = 700;
    final int screenHeight = 1000;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.GRAY);
        this.setLayout(null);
    }
}
