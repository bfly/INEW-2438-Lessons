package edu.dcccd;

import java.util.Arrays;

public class Main {
    private void go() {
        Model model = new Model();

        model.getCourses().forEach(System.out :: println);

        model.getStudents().forEach(System.out :: println);

        System.out.printf("Students enrolled in %s: %s\n",
                model.getCourses().get(0).getCourseId(),
                model.getCourses().get(0).getCourseName());
        String[] studentNames =
                model.getEnrollments().stream()
                .map(EnrollmentCombo :: getName)
                .toArray(String[] ::new);
        System.out.println(Arrays.toString(studentNames));

    }

    public static void main(String[] args) {
        new Main().go();
    }
}
