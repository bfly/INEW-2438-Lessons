package edu.dcccd;

import lombok.Data;

@Data
public class Student {
    private long id;
    private String name;

    private static long nextId = 0;

    public Student(String name) {
        this.id = ++nextId;
        this.name = name;
    }
}
