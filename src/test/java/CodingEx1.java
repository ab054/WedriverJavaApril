import org.testng.annotations.Test;

import java.util.Arrays;

public class CodingEx1 {

    @Test
    public void swapTwoNumbersInArray() {
        int[] array = {1, 2, 3, 4};
        swap(array, 1, 2);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void swapTwoNumbersInArray001() {
        int[] array = {1};
        swap(array, 1, 2);
        System.out.println(Arrays.toString(array));
    }


    private void swap(int[] array, int indexL, int indexR) {
        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR] = temp;
    }

    @Test
    public void testCountLetters0001() {
        String input = "hello world";
        int result = getNumberOfLetters(input, 'l');
        System.out.println(result);
    }

    @Test
    public void testCountLetters0002() {
        String input = "another string input";
        int result = getNumberOfLetters(input, 't');
        System.out.println(result);
    }

    private int getNumberOfLetters(String input, char letter) {
        int result = 0;
        for (char eachChar : input.toCharArray()) {
            if (eachChar == letter) result++;
        }
        return result;
    }


    @Test
    public void testActorClass() {
        String first = "Arnold";

        Actor actor = new Actor(first, "Schwarzenegger", false);


    }
}
