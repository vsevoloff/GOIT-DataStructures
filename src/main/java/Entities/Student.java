package Entities;

public class Student extends Human implements Comparable<Student>{

    public <T> Student(String name, T age){
        super(name,(Integer)age);
    }

    @Override
    public int compareTo(Student student) {
        int result = name.compareTo(student.name);
        if (result > 0) {
            return 1;
        }
        else if(result < 0) {
            return -1;
        }
        return result;
    }

}
