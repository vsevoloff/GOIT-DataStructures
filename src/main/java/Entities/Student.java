package Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class Student extends Human implements Comparable<Student>{

    private String group;

    public <T extends Number> Student(String name, String group, T age){
        super(name,(Integer)age);
        this.group = group;
    }

    @Override
    public int compareTo(Student student) {
        return  name.compareTo(student.name);
    }




}
