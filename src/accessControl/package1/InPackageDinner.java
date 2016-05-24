package accessControl.package1;

/**
 * 5/24/16.
 * Never forget your dream
 */
public class InPackageDinner {
    void takeDinner(){
        Cake cake = new Cake();
        cake.bite();
        cake.bigBite();

        MoonCake moonCake = new MoonCake();
        moonCake.bite();
        moonCake.bigBite();
    }
}