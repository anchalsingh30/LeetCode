package JavaConcepts;

abstract class Abstract {

        // Constructor of class 1
        Abstract()
        {
            // Print statement
            System.out.println("Base Constructor Called");
        }

        // Abstract method inside class1
        abstract void fun();
    }

    // Class 2
    class Derived extends Abstract {

        // Constructor of class2
        Derived()
        {
            System.out.println("Derived Constructor Called");
        }

        // Method of class2
        void fun()
        {
            System.out.println("Derived fun() called");
        }
    }

class GFG {

    // Main driver method
    public static void main(String args[])
    {
        // Creating object of class 2
        // inside main() method
        Derived d = new Derived();
        d.fun();
    }
}
