package staticDataInitialization;

import org.junit.Test;

/**
 * 5/19/16.
 * Never forget your dream
 */
public class Tester {
    @Test
    public void testMethod1(){
        Bowl bowl1 = new Bowl();
        bowl1.price = 19;
        System.out.println("Bowl1 price is : " + bowl1.price);

        Bowl bowl2 = new Bowl();
        bowl2.price = 29;

        System.out.println("Bowl1 price is : " + bowl1.price);
    }
}
