package cargame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Christian Abuda
 */
public class LaneMarker {
    //Road Divider
    int laneMarkerX = 330;
    int laneMarkerY = -100;
    int laneMarkerWidth = 30;
    int laneMarkerHeigth = 80;
    
    double gravity = 0.5;
    double velocity = 0;
    
    public LaneMarker(int x, int y){
        this.laneMarkerX = x;
        this.laneMarkerY = y;
    }
    
    public void update(){
        velocity += gravity;
        laneMarkerY += velocity;
    }
    
    
    public void draw(Graphics g){        
        g.setColor(Color.WHITE);
        g.fillRect(laneMarkerX, laneMarkerY, laneMarkerWidth, laneMarkerHeigth);
    }
}
