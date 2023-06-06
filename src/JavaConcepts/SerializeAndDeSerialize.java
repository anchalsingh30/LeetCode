package JavaConcepts;

import java.io.*;
/*
Serialization in Java allows us to convert an Object to stream that
we can send over the network or save it as file
 or store in DB for later usage. Deserialization is the process of converting
 Object stream to actual Java Object to be used in our program.
 */
public class SerializeAndDeSerialize implements Serializable {
    int salary;
    String name;

    public SerializeAndDeSerialize(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }
}
class DeserializeData {

    public static void main(String[] args) {
        SerializeAndDeSerialize obj1 = new SerializeAndDeSerialize(116100, "Anchal");
        SerializeAndDeSerialize obj3 = new SerializeAndDeSerialize(120000, "Alankar");
        try {
            FileOutputStream fileWrite = new FileOutputStream("File.text");
            ObjectOutputStream out  = new ObjectOutputStream(fileWrite);

            out.writeObject(obj1);
            out.writeObject(obj3);
            out.close();
            fileWrite.close();

            System.out.println("Object has been serialized");
        }
        catch(IOException ex) {
            System.out.println("IOException is caught");
        }


        try {
            FileInputStream fileRead = new FileInputStream("File.text");
            ObjectInputStream in = new ObjectInputStream(fileRead);

            SerializeAndDeSerialize obj2 = (SerializeAndDeSerialize) in.readObject();
            SerializeAndDeSerialize obj4 = (SerializeAndDeSerialize) in.readObject();
            in.close();
            fileRead.close();

            System.out.println("Object has been deserialized ");
            System.out.println("salary = " + obj2.salary);
            System.out.println("name = " + obj2.name);
            System.out.println("salary = " + obj4.salary);
            System.out.println("name = " + obj4.name);
        }
        catch(IOException ex) {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}
