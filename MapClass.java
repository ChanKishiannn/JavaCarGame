package cargame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Christian Abuda
 */
public class MapClass{
    int [] lanes = {95, 150, 200, 250, 300, 350, 400, 450, 500, 550};
    ArrayList<LaneMarker> lineDivider = new ArrayList<>();
    
    
    ArrayList<CarClass> randomCar = new ArrayList<>();
    Random spawnCarRandom = new Random();
    
    long lastDividerSpawnTime = 0;
    long lastCarSpawnTime = 0;
    final int SPAWN_DELAY = 500;
    
    
    //Spawn Car in Lanes Code//
    public void spawnRandomCar(){
        ArrayList<Integer> freelanes = new ArrayList<>();
        
        //Check if there is a free lanes
        for(int laneX : lanes){
            boolean occupied = false;
            
            for(CarClass car : randomCar){
                if(car.carX == laneX && car.carY < 150){
                    occupied = true;
                    break;
                }
            }
            if(!occupied){
                freelanes.add(laneX);
            }
        }
        if(!freelanes.isEmpty()){
            int laneX = freelanes.get(spawnCarRandom.nextInt(freelanes.size()));
            randomCar.add(new CarClass(laneX, -200));
        }
    }
    
    //Player Car and Random Car Collition//
    public boolean checkCollition(PlayerCar player){
        for(CarClass car: randomCar){
            if(player.playerCarX < car.carX + car.carWidth &&
                player.playerCarX + player.playerCarWidth > car.carX &&
                player.playerCarY < car.carY + car.carHeigth &&
                player.playerCarY + player.playerCarHeigth > car.carY){
                
                return true;
            }
        }
        return false;
    }
    
    
    
    
    public void update(){
        long currentTime = System.currentTimeMillis();
        
        //Lane Divider Spawn Code//
        if(currentTime - lastDividerSpawnTime >= SPAWN_DELAY){
            lineDivider.add(new LaneMarker(330, -500));
            lastDividerSpawnTime = currentTime;
        }
        
        for(int i = 0; i < lineDivider.size(); i++){
            LaneMarker divider = lineDivider.get(i);  
            divider.update();
        }
        
        //Random Car Spawn Code//
        if(currentTime - lastCarSpawnTime >= SPAWN_DELAY + 500){
            spawnRandomCar();
            lastCarSpawnTime = currentTime;
        }
        
        for(int i = 0; i < randomCar.size(); i++){
            CarClass opponentCar = randomCar.get(i);
            opponentCar.update();
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(80, 0, 530, 1000);
              
        for(LaneMarker divider: lineDivider){
            divider.draw(g); 
        }
        for(CarClass opponentCar : randomCar){
            opponentCar.draw(g);
        }
    }
}
