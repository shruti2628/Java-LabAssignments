package ObjectSerialisationDeserialisation;

import java.io.*;

public class SerializationApp {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java SerializationApp <filePath>");
            return;
        }

        String filePath = args[0];

        Employee emp = new Employee(
                101,
                "Rahul",
                new Address("Mumbai", "Maharashtra"),
                75000.50
        );

        serializeEmployee(emp, filePath);
        Employee deserializedEmp = deserializeEmployee(filePath);

        if (deserializedEmp != null) {
            System.out.println("\nDeserialized Employee Details:");
            deserializedEmp.display();
        }
    }

    //Serialisation
    private static void serializeEmployee(Employee emp, String filePath) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(filePath))) {

            oos.writeObject(emp);
            System.out.println("Employee serialized successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File path not found - " + filePath);
        } catch (IOException e) {
            System.out.println("I/O Error during serialization.");
        }
    }

    //Deserialisation
    private static Employee deserializeEmployee(String filePath) {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(filePath))) {

            return (Employee) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Serialized file not found - " + filePath);
        } catch (IOException e) {
            System.out.println("I/O Error during deserialization.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class definition not found.");
        }

        return null;
    }
}
