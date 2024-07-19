package lk.ijse;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class Main {

    public static void main(String[] args) {
        Student student = new Student("Kamal", 21);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Serialization successful: " + student);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedPerson = (Student) ois.readObject();
            System.out.println("Deserialization successful: " + deserializedPerson);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
}