package home.bai19;

import java.util.Comparator;

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        int compareName = s1.getName().compareToIgnoreCase(s2.getName());
        if (compareName != 0) {
            return compareName;
        }
        return Double.compare(s2.calAvg(), s1.calAvg());

    }

}