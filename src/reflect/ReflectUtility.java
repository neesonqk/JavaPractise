package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtility {

    public void createObj() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //Method 1
        Person person = Person.class.newInstance();

        //Method 2
        Person person2 = Person.class.getDeclaredConstructor(Person.class).newInstance();
    }

    //get value
    @Test
    public void getValue() throws IllegalAccessException, InstantiationException {
        Person person = new Person("Neeson", 99, 1);
        Class<?> clazz = Person.class;
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.get(person));
        }
    }

    //set value
    @Test
    public void setValue() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Person person = Person.class.newInstance();
        Class<Person> clazz = Person.class;
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if(field.get(person) == null) {
                Constructor<?> c = field.getType().getDeclaredConstructor();
                c.setAccessible(true);
                field.set(person, c.newInstance());
            }
        }
    }

    @Test
    public void invokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person("Neeson", 99, 1);
        Class<Person> clazz = Person.class;
        Method method = clazz.getDeclaredMethod("toString");
//        method.setAccessible(true);
        System.out.println(method.invoke(person));
    }
}
