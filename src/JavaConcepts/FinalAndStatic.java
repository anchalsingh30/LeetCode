package JavaConcepts;

public class FinalAndStatic {
    static int x = 10;
    int y = 5;

    final int r = 0;
    public static void print() {
        //static int z = 0; // static var cant be initialized in method
        final int z = 0; // final var can be initialized everywhere at global and local level

    }

    public static void main(String[] args) {
        FinalAndStatic f = new FinalAndStatic();
        f.x = 20;
        f.y = 30;

        FinalAndStatic f1 = new FinalAndStatic();
        // both static and instance variable will be printing the latest value
        System.out.println("print x with first object : " + f.x + " and y : " + f.y);
        // second object f1 will give you the initial value for variable y and static variable will be returning the latest value only
        System.out.println("print x with second object: "+ f1.x + " and y : "+ f1.y);
    }
}
