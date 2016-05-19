package shiftOperators;

import org.junit.Test;

/**
 * 5/17/16.
 * Never forget your dream
 */
public class Example {

    @Test
    public void leftShift(){
        int i = 100;
        System.out.println(Integer.toBinaryString(i));
        i <<= 10;
        System.out.println(Integer.toBinaryString(i));
    }

    @Test
    public void rightShift(){
        int i = 100;
        System.out.println(Integer.toBinaryString(i));
        i >>= 1;
        System.out.println(Integer.toBinaryString(i));
    }
}
