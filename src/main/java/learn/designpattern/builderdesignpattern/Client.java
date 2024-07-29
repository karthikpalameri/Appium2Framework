package learn.designpattern.builderdesignpattern;

public class Client {
  public static void main(String[] args) {
    Director directorObj1 = new Director(new EngineeringStudentBuilder());
    Director directorObj2 = new Director(new MbaStudentBuilder());
    Studentt enggStudent = directorObj1.createStudent();
    Studentt collegeStudent = directorObj2.createStudent();

    System.out.println("enggStudent = " + enggStudent);
    System.out.println("collegeStudent = " + collegeStudent);
  }
}
