package learn.java.basics;

public class Student {
    int id;
    String name;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    int priority;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
