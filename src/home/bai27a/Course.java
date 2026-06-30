package home.bai27a;

public class Course {
    String id, name;
    Float grade;

    public Course(String id, String name, Float grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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

    public Float getGrade() {
        return this.grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

}
