package com.kitri.springbasicboot.lesson.mapping;

public class Student {
    long id;
    String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
