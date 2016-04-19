package reflect;

public class Person {

    private String name;
    private int age;
    private int gender;

    public Person() {
    }

    public Person(String name, int age, int gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return String.format("%s, %s, %s", this.getName(), String.valueOf(this.getAge()), this.getGender() == 0 ? "F" : "M");
    }
}
