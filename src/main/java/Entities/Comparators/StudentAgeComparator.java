package Entities.Comparators;

import Entities.Student;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student stu1, Student stu2) {
        return Integer.compare(stu1.getAge(), stu2.getAge());
    }
}
