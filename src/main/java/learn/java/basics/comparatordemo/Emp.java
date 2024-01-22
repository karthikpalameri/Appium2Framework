package learn.java.basics.comparatordemo;

public class Emp {
    String name;
    int age;

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Emp(String name, int age) {
        this.name = name;
        this.age = age;
    }
}