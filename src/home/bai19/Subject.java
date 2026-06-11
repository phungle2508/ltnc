package home.bai19;

public class Subject {
    String name;
    String id;
    float grade;

    public Subject(String name, String id, float grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getGrade() {
        return this.grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

}
