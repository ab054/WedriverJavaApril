import org.testng.annotations.Test;

public class Day1 {

    @Test
    public void testName001() {
        System.out.println("This will be printed");
    }

    @Test
    public void testName002() {
        System.out.println("Hello, World!");
    }



    @Test
    public void testName() {
        int myNumber;
        myNumber = 5;
        System.out.println(myNumber);
    }

    @Test
    public void methodName001() {
        int myNumber;
        myNumber = 5;
        System.out.println(myNumber);

    }


    @Test
    public void test005() throws Exception {
        String errorMessage = "Error ";
        String errorMessage2 = "Element is not present";
        String messageFromBrowser = errorMessage + errorMessage2 + 2000;

        System.out.println(errorMessage2 + messageFromBrowser);
    }

    @Test
    public void test006() throws Exception {
        boolean b = false;
        b = true;

        boolean toBe = false;
        b = toBe || !toBe;
        if (b) {
            System.out.println(toBe);
        }
    }

    @Test
    public void test007() throws Exception {

        int a = 5;
        boolean b = a == 3;

        if (b) {
            System.out.println("It's true!");
        }

    }

    @Test
    public void test008() throws Exception {
        boolean elementAisVisible = true;
        boolean elementBisVisible = false;


        if (elementAisVisible == true)
            System.out.println("element A is visible");
        else
            System.out.println("element B is visible");
    }

    @Test
    public void test009() throws Exception {
        int[] array;

        array = new int[10];

        array[0] = 4;
        array[1] = 3;
        array[2] = 6;

        String messageStart = "a[i]=";
        String messageEND = " i=";

        int i = 1;
        System.out.println(messageStart + array[i] + messageEND +  i);


        int[] arr = {1, 2, 3, 4, 5};

        i = 3;

        if(i == 3) {
            System.out.println(messageStart + array[i] + messageEND + i);
        }

    }

    @Test
    public void test010() throws Exception {
        String[] arrayOfStrings = {"String1", "String2", "String3"};

        System.out.println(arrayOfStrings[2]);
    }
}