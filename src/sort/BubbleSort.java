package sort;

import com.sun.tools.javac.util.ArrayUtils;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    private int[] numbers = new int[]{12, 34, 2, 23, 45, 66, 11, 223, 66, 6, 12};

    @Test
    public void sort(){
        int len = numbers.length;
        int temp;
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < len - 1 - i; j++){
                if(numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
