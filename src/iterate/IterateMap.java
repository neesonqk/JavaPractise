package iterate;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateMap {
    private Map<String, Integer> students = new HashMap<>(); //Name <-> Code

    public IterateMap(){
        students.put("Neeson", 200910001);
        students.put("Niki", 200910002);
        students.put("Jack", 200910003);
    }

    //Java 1.5+
    @Test
    public void iterateStudents(){
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    @Test
    public void iterateStudents2() {
        Iterator iterator = students.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}
