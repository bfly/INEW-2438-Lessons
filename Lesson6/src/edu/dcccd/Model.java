package edu.dcccd;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.nio.file.Files.lines;

public class Model implements ModelInterface {
    private Map<Long, Course> courses = new TreeMap<>();
    private Map<Long, Student> students = new TreeMap<>();
    private List<Enrollment> enrollments = new ArrayList<>();
    private List<EnrollmentCombo> combos = new ArrayList<>();

    public Model() {
        try {
            lines(Paths.get("courses.txt"))
                .map(s -> s.split(","))
                .map(Course ::new)
                .forEach(c -> courses.put(c.getId(), c));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            lines(Paths.get("students.txt"))
                    .map(Student ::new)
                    .forEach(s -> students.put(s.getId(), s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        students.values().forEach(s -> enrollments.add(new Enrollment(1, s.getId())));
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses.values());
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    public List<EnrollmentCombo> getEnrollments() {
        enrollments.forEach(e -> {
            Course c = findCourse(e.getCourseId());
            Student s = findStudent(e.getStudentId());
            combos.add(new EnrollmentCombo(c.getCourseId(), c.getCourseName(), c.getInstructor(),
                    c.getTerm(), c.getClassPeriod(), s.getName()));
        });
        return combos;
    }

    public Course findCourse(long courseId) {
        return courses.values().stream()
                .filter(course -> course.getId() == courseId)
                .findFirst()
                .orElse(null);
    }

    public Student findStudent(long studentId) {
        return students.values().stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElse(null);
    }
}
