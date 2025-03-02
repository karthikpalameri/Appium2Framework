package learn.designpattern.builderdesignpattern;

public class Studentt {
  int id;
  String name;

  public Studentt(StudentBuilder studentBuilder) {
    this.id = studentBuilder.id;
    this.name = studentBuilder.name;
  }

  @Override
  public String toString() {
    return "Studentt{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
