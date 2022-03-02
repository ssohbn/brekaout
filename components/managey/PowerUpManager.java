package components.managey;

import java.util.ArrayList;

import components.PowerUp;

public class PowerUpManager {
    private static PowerUpManager INSTANCE;
    private ArrayList<PowerUp> powerUps;

    private PowerUpManager() {
        powerUps = new ArrayList<PowerUp>();  
    }

    public static PowerUpManager getInstance() {
        if ( INSTANCE == null )
            INSTANCE = new PowerUpManager();
        return INSTANCE;
    }

    public ArrayList<PowerUp> getBricks() {
        return this.powerUps;
    }

    public void add(PowerUp powerUp) {
        powerUps.add(powerUp);
    }


}
