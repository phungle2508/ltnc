package home.bai19;

import java.util.Date;
import java.util.List;

// Sinh viên(Student)chứa thông tin:tên sinh viên,mã số sinh viên,ngày tháng năm,danh sách điểm
public class Student implements Comparable<Student> {
    String name;
    String id;
    Date dateOfBirth;
    List<Subject> subjects;

    public Student(String name, String id, Date dateOfBirth, List<Subject> subjects) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
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

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public double calAvg() {
        double result = 0;
        for (Subject subject : getSubjects()) {
            result += subject.getGrade();
        }
        return result /= getSubjects().size();
    }

    @Override
    public int compareTo(Student other) {
        int compareName = this.getName().compareToIgnoreCase(other.getName());
        if (compareName != 0) {
            return compareName;
        }
        return Double.compare(other.calAvg(), this.calAvg());
    }

}
