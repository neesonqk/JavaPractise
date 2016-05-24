package accessControl;

import accessControl.package1.Cake;
import accessControl.package1.MoonCake;

/**
 * 5/24/16.
 * Never forget your dream
 */
public class OutPackageDinner {
    public void takeDinner(){
        Cake cake = new Cake();
        //cake.bite();

        MoonCake moonCake = new MoonCake();
        //moonCake.bite();
    }
}
