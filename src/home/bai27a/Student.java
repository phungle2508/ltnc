package home.bai27a;

import java.util.List;

public class Student {
    String id, name;
    List<Course> course;

    public Student(String id, String name, List<Course> course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourse() {
        return this.course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

}
