package javaspec.matcher;

public final class Students {
  private Students() {
  }

  public static Student findByAge(Student[] students) {
    for (int i=0; i<students.length; i++)
      if (students[i].getAge() == 18)
        return students[i];
    return null;
  }
}
