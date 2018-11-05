package edu.dcccd;

import java.util.List;

public interface ModelInterface {
    List<Course> getCourses();      // returns a list of course objects

    List<Student> getStudents();    // returns a list of student objects

    List<EnrollmentCombo> getEnrollments(); // returns a list of enrollmentCombo objects

    Student findStudent(long studentId);    // finds a student by id

    Course findCourse(long courseId);       // finds a course by id
}
