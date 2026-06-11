package home.bai19;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManage {
    List<Student> students;

    public StudentManage(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByIdAndName(String id, String name) {
        for (Student student : students) {
            if (student.getId().equals(id) & student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> printListStudentSortAscByNameDescByGradeComparator() {
        students.sort(Comparator.comparing((Student s) -> s.getName()).thenComparing(((Student s) -> s.calAvg()),
                Comparator.reverseOrder()));
        return students;
    }

    public List<Student> printListStudentSortAscByNameDescByGradeComparatorA() {
        Collections.sort(students, new StudentComparator());
        return students;
    }

    public List<Student> printListStudentSortAscByNameDescByGradeComparatorB() {
        Collections.sort(students);
        return students;
    }

    public double calAvg(Student student) {

        return student.calAvg();
    }
}
