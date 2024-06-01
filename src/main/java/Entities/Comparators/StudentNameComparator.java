package Entities.Comparators;

import Entities.Student;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student stu1, Student stu2) {
        return stu1.getName().compareTo(stu2.getName());
    }
}
