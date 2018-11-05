package edu.dcccd.optional;

import java.util.List;
import java.util.Optional;

public class OptionalMain {
    private void go() {
        List<Student> studentList = createStudentList();
        printStudentName(studentList, "Mary");
        printStudentName(studentList, "Bill");
        System.out.println(findStudent(studentList, "Bill").get());
    }

    private void printStudentName(List<Student> studentList, String name ) {
        Optional<Student> studentOpt = findStudent(studentList, name);
        System.out.printf("Student name: %s ", name);
        System.out.println(studentOpt.isPresent() ? "found." : "not found.");
//        if ( studentOpt.isPresent() )
//            System.out.printf("Student name: %s found.\n", studentOpt.get().getName());
//        else
//            System.out.printf("Student name: %s not found.\n", name);
    }

    private Optional<Student> findStudent(List<Student> studentList, String name) {
        return studentList.stream().filter(student -> student.getName().equals(name)).findFirst();
    }

    private List<Student> createStudentList() {
        return List.of(
            new Student("John",    81),
            new Student("Martin",  82),
            new Student("Mary",    91),
            new Student("Stephan", 78),
            new Student("Gary",    86)
        );
    }

    public static void main(String[] args) {
        new OptionalMain().go();
    }
}