package learn.java.basics;

public class GenericClassDemo<T, U> {
    private final U age;
    private final T name;

    @Override
    public String toString() {
        return "GenericClassDemo{" +
                "age=" + age +
                ", name=" + name +
                '}';
    }

    public GenericClassDemo(T name, U age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        GenericClassDemo<String, Integer> kk = new GenericClassDemo<>("kk", 10);
        GenericClassDemo<String, String> kk1 = new GenericClassDemo<>("kk", "ten");
        System.out.println(kk);

        System.out.println(kk1);
    }
}

