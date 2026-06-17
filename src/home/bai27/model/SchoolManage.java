package home.bai27.model;

import java.util.ArrayList;
import java.util.List;

public class SchoolManage {
    public List<Student> students;

    public SchoolManage(List<Student> students) {
        this.students = students;
    }

    public String[] findALLCurrentCourse() {
        List<String> courseNames = new ArrayList<>();
        if (students.isEmpty()) {
            return new String[0];
        }
        for (Student student : students) {
            for (Course course : student.getCourses()) {
                if (!courseNames.contains(course.getName())) {
                    courseNames.add(course.getName());
                }
            }
        }

        return courseNames.toArray(new String[0]);
    }

    public void addStudent(Student student) {
        students.add(student);

    }

    public void addCourse(String studentID, Course course) {
        for (Student student : students) {
            if (studentID.equals(student.getId())) {
                student.addCourse(course);
            }
        }
    }

    public void addGrade(String studentID, Course course) {
        for (Student student : students) {
            if (studentID.equals(student.getId())) {
                for (int i = 0; i < student.getCourses().size(); i++) {
                    if (student.getCourses().get(i).getId().equals(course.getId())) {
                        student.getCourses().set(i, course);
                    }
                }
            }
        }
    }

    public Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(studentID.trim())) {
                return student;
            }
        }
        return null;
    }
}
