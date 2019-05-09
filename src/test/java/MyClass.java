public class MyClass {

    public MyClass(String param) {
        //I can do some additional stuff here
        System.out.println("Constructor with params:" + param);
    }

    public MyClass() {
        //I can do some additional stuff here
        System.out.println("Constructor with no params");
    }

    public void print() {
        System.out.println("printed");
    }

    public String print(String parameterValue) {
        String result;
        result = parameterValue + " printed";
        return result;
    }
}
