package learn.designpattern.builderdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder {

  @Override
  public StudentBuilder setSubjects() {
    List<String> subs = new ArrayList<>();
    subs.add("enggsub1");
    this.subjects = subs;
    return this;
  }
}
