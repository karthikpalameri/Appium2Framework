package learn.designpattern.builderdesignpattern;

public class CollegeStudentBuilder extends StudentBuilder {

  @Override
  public EngineeringStudentBuilder setSubjects() {
    subjects.add("schoolsub1");
    return this;
  }
}
