package learn.designpattern.builderdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class MbaStudentBuilder extends StudentBuilder {

  @Override
  public MbaStudentBuilder setSubjects() {
    List<String> subs = new ArrayList<>();
    subs.add("mba sub1");
    this.subjects = subs;
    return this;
  }
}
