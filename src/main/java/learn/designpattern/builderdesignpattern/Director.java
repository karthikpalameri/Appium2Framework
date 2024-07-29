package learn.designpattern.builderdesignpattern;

public class Director {
  StudentBuilder studentBuilder;

  public Director(StudentBuilder studentBuilder) {
    this.studentBuilder = studentBuilder;
  }

  public Studentt createStudent() {
    if (studentBuilder instanceof EngineeringStudentBuilder) {
      return createEngineeringStudent();
    } else if (studentBuilder instanceof MbaStudentBuilder) {
      return createCollegeStudentBuilder();
    }
    return null;
  }

  private Studentt createCollegeStudentBuilder() {
    return studentBuilder.setId(2).setName("xyz").setSubjects().build();
  }

  private Studentt createEngineeringStudent() {
    return studentBuilder.setId(1).setName("Abc").setSubjects().build();
  }
}
