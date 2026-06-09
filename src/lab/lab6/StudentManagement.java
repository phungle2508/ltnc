package lab.lab6;

import java.util.ArrayList;
import java.util.Collections;

public class StudentManagement {

	private ArrayList<Student> students;

	private class Student implements Comparable<Student>{
		private String name;
		private String id;
		private String dateOfBirth;
		private ArrayList<Subject> subjects = new ArrayList<Subject>();

		public Student(String name, String id) {
			super();
			this.name = name;
			this.id = id;
		}

		private double calAvgGrade() {
			double avgGrade = 0;
			for (Subject subject : subjects) {
				avgGrade += subject.grade;
			}
			return avgGrade = avgGrade / subjects.size();
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", id=" + id + ", avgGrade=" + calAvgGrade() + "]";
		}


		@Override
		public int compareTo(Student other) {
		    int cmp = this.name.compareToIgnoreCase(other.name);
		    if (cmp != 0) return cmp;

		    return Double.compare(this.calAvgGrade(), other.calAvgGrade());
		}

	}

	private class Subject {
		private String name;
		private String id;
		private double grade;
	}

	private void addStudent(Student student) {
		students.add(student);
	}

	private void addStudent(String name, String id) {
		Student student = new Student(name, id);
		students.add(student);
	}

	private void addGradeForStudentById(String id,Subject subject) {
		for (Student student : students) {
			if (student.id.equals(id)) {
			student.subjects.add(subject);
			}
		}
	}

	private double calAvgGrade(Student student) {
		return student.calAvgGrade();
	}
	
	private void printStudentList() {
		Collections.sort(students);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	public static void main(String[] args) {
	    StudentManagement sm = new StudentManagement();
	    sm.students = new ArrayList<>(); // initialize list

	    // Add students
	    sm.addStudent("Alice", "S01");
	    sm.addStudent("Bob", "S02");
	    sm.addStudent("alice", "S03"); // test compareIgnoreCase

	    // Create subjects
	    Subject math = sm.new Subject();
	    math.name = "Math";
	    math.grade = 8.5;

	    Subject physics = sm.new Subject();
	    physics.name = "Physics";
	    physics.grade = 7.5;

	    Subject chemistry = sm.new Subject();
	    chemistry.name = "Chemistry";
	    chemistry.grade = 9.0;

	    // Add grades
	    sm.addGradeForStudentById("S01", math);
	    sm.addGradeForStudentById("S01", physics);

	    sm.addGradeForStudentById("S02", chemistry);

	    sm.addGradeForStudentById("S03", math);
	    sm.addGradeForStudentById("S03", chemistry);

	    // Print sorted list
	    sm.printStudentList();
	}
}
