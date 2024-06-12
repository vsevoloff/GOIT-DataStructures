package Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class Student extends Human implements Comparable<Student> {

    private String group;

    public <T extends Number> Student(String name, String group, T age){
        super(name,(Integer)age);
        this.group = group;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name: ").append(name)
               .append(", age: ").append(age)
                .append(", group: ").append(group)
                 .append("\n");
        return result.toString();
    }


    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }
}
