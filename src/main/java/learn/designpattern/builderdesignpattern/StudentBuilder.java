package learn.designpattern.builderdesignpattern;

import java.util.List;

public abstract class StudentBuilder {
  int id;
  String name;
  List<String> subjects;

  public StudentBuilder setId(int id) {
    this.id = id;
    return this;
  }

  public StudentBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public abstract StudentBuilder setSubjects();

  public Studentt build() {
    return new Studentt(this);
  }
}
