package home.bai27a;

import java.util.ArrayList;
import java.util.List;

public class SchoolManage {

    public SchoolManage(List<Student> students) {
        this.students = students;
    }

    List<Student> students;

    public String[] getAllCoursesName() {
        List<String> coursesName = new ArrayList<>();
        for (Student student : students) {
            for (Course course : student.getCourse()) {
                if (!coursesName.contains(course.getName())) {
                    coursesName.add(course.getName());
                }
            }
        }
        return coursesName.toArray(new String[0]);
    }

    public Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(studentID)) {
                return student;
            }
        }
        return null;
    }

    public boolean studentAddOrCourseAdd(String studentID, String studentName,
            String courseID, String courseName) {
        for (int i = 0; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            if (currentStudent.getId().equals(studentID)) {
                for (int j = 0; j < currentStudent.getCourse().size(); j++) {
                    Course currentCourse = currentStudent.getCourse().get(j);
                    if (currentCourse.getId().equals(courseID)) {
                        return false;
                    }

                }
                List<Course> courses = currentStudent.getCourse();
                courses.add(new Course(courseID, courseName, 0f));
                currentStudent.setCourse(courses);
                students.set(i, currentStudent);
                return true;
            }
        }
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(courseID, courseName, 0f));
        Student newStudent = new Student(studentID, studentName, courses);
        students.add(newStudent);
        return true;
    }

    public boolean addGrade(String studentID, String courseName, String grade) {
        for (int i = 0; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            if (currentStudent.getId().equals(studentID)) {
                for (int j = 0; j < currentStudent.getCourse().size(); j++) {
                    Course currentCourse = currentStudent.getCourse().get(j);
                    if (currentCourse.getName().equals(courseName)) {
                        List<Course> courses = currentStudent.getCourse();
                        currentCourse.setGrade(Float.parseFloat(grade));
                        courses.set(j, currentCourse);
                        currentStudent.setCourse(courses);
                        students.set(i, currentStudent);
                        return true;
                    }

                }

                List<Course> courses = currentStudent.getCourse();
                courses.add(new Course(studentID, courseName, Float.parseFloat(grade)));
                currentStudent.setCourse(courses);
                students.set(i, currentStudent);
                return true;
            }
        }

        return false;

    }

}
