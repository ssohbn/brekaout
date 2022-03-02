package components;

import java.util.ArrayList;

public class PowerUpManager {
    private static PowerUpManager INSTANCE;
    private ArrayList<PowerUp> powerUps;
    private int level = 0;

    private PowerUpManager() {
        powerUps = new ArrayList<PowerUp>();  
    }

    public static PowerUpManager getInstance() {
        if ( INSTANCE == null )
            INSTANCE = new PowerUpManager();
        return INSTANCE;
    }

    public void add(PowerUp powerUp) {
        powerUps.add(powerUp);
    }


}
