package learn.java.ds.arrays;

public class PrintJavaVersionAndPath {
  public static void main(String[] args) {
    System.out.println("System.getProperty(\"java.version\") = " +
        System.getProperty("java.version"));
    System.out.println("System.getProperty(\"java.home\") = " +
        System.getProperty("java.home"));
  }
}
