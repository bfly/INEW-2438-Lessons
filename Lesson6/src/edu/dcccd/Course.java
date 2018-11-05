package edu.dcccd;

import lombok.Data;

@Data
public class Course {
    private long id;
    private String courseId;
    private String courseName;
    private String instructor;
    private String term;
    private String classPeriod;
    private int credits;

    private static long nextId = 0;

    public Course(String[] strings) {
        this.id = ++nextId;
        this.courseId = strings[0];
        this.courseName = strings[1];
        this.instructor = strings[2];
        this.term = strings[3];
        this.classPeriod = strings[4];
        this.credits = Integer.parseInt(strings[5]);
    }
}
