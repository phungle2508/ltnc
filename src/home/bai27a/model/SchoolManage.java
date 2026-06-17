package home.bai27a.model;

import java.util.ArrayList;
import java.util.List;

public class SchoolManage {
    List<Student> students;

    public SchoolManage(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String[] getAllCourseName() {
        List<String> courseNames = new ArrayList<>();
        for (Student student : students) {
            for (Course course : student.getCourses()) {
                if (!courseNames.contains(course.getName())) {
                    courseNames.add(course.getName());
                }
            }
        }
        return courseNames.toArray(new String[0]);
    }

    public Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(studentID)) {
                return student;
            }
        }
        return null;
    }

    public boolean addAtCoursePanel(String courseID, String courseName, String studentID, String studentName) {
        for (int i = 0; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            for (int j = 0; j < currentStudent.getCourses().size(); j++) {
                Course currentCourse = currentStudent.getCourses().get(i);
                if (currentCourse.getId().equals(courseID)) {
                    return false;
                }
            }
            Course newCourse = new Course(courseID, courseName, 0);
            List<Course> courses = currentStudent.getCourses();
            courses.add(newCourse);
            currentStudent.setCourses(courses);
            students.set(i, currentStudent);
        }

        Course newCourse = new Course(courseID, courseName, 0);
        List<Course> courses = new ArrayList<>();
        courses.add(newCourse);
        Student newStudent = new Student(studentID, studentName, courses);
        students.add(newStudent);
        return true;
    }

    public boolean addGrade(String studentID, String courseName, String grade) {
        for (int i = 0; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            for (int j = 0; j < currentStudent.getCourses().size(); j++) {
                Course currentCourse = currentStudent.getCourses().get(i);
                if (currentCourse.getName().equals(courseName)) {
                    currentCourse.setGrade(Float.parseFloat(grade));
                    List<Course> courses = currentStudent.getCourses();
                    courses.set(j, currentCourse);
                    currentStudent.setCourses(courses);
                    students.set(i, currentStudent);
                    return true;
                }
            }
            Course newCourse = new Course((currentStudent.getCourses().size() + 1) + "", courseName,
                    Float.parseFloat(grade));
            List<Course> courses = currentStudent.getCourses();
            courses.add(newCourse);
            currentStudent.setCourses(courses);
            students.set(i, currentStudent);
            return true;
        }
        return false;

    }

}
