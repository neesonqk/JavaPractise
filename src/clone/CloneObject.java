package clone;

import org.junit.Test;

import java.io.*;

public class CloneObject {
    Person person = new Person("Neeson", 99, 1);

    @Test
    public void clonePerson() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(person);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Person clonedPerson = (Person) objectInputStream.readObject();

        System.out.println(clonedPerson.toString());
        System.out.println(clonedPerson.equals(person));
    }
}
