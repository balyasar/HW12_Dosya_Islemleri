package com.yasar;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Student implements Serializable {
    private Long id;
    private String name;
    private double average;
    private EState state;
    private LocalDate birthDay;

    public Student(String name, double average, LocalDate birthDay) {
        this.id = new Random().nextLong();
        this.name = name;
        this.average = average;
        this.birthDay = birthDay;
        this.state = EState.KALDI;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public EState getState() {
        return state;
    }

    public void setState(EState state) {
        this.state = state;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }


    public void durumBelirle() {
        if (this.average > 59) {
            this.state = EState.GECTI;
        }
        this.state = EState.KALDI;
    }
}
