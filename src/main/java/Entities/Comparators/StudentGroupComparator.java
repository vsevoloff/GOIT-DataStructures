package Entities.Comparators;

import Entities.Student;

import java.util.Comparator;

public class StudentGroupComparator implements Comparator<Student> {

    @Override
    public int compare(Student stu1, Student stu2) {
        return stu1.getGroup().compareTo(stu2.getGroup());
    }
}
