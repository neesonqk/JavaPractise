package relationalOperation;

import org.junit.Test;

/**
 * 5/17/16.
 * Never forget your dream
 */
public class Tester {

    @Test
    public void runTest(){
        Dog dog1 = new Dog("spot", "Ruff!");
        Dog dog2 = new Dog("scruff", "Wurf!");

        System.out.println(dog1.getName() + ": " + dog1.getSays());
        System.out.println(dog2.getName() + ": " + dog2.getSays());

        Dog dog3 = dog1;
        System.out.println(dog1 == dog3);     //true
        System.out.println(dog1.equals(dog3));//true
        System.out.println(dog1 == dog2);     //false
        System.out.println(dog1.equals(dog2));//false
    }

    @Test
    public void runTest2(){
        Dog d1 = new Dog("spot", "Ruff!");
        Dog d2 = new Dog("spot", "Ruff!");

        System.out.println(d1 == d2);     //false
        System.out.println(d1.equals(d2));//false
    }
}
