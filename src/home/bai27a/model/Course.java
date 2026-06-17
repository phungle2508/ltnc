package home.bai27a.model;

public class Course {
    String id, name;
    float grade;

    public Course(String id, String name, float grade) {
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

    public float getGrade() {
        return this.grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

}
