package com.yasar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teacher {
    private Long id;
    private String name;
    private List<Student> studentList;
    private Manager manager;
    private BufferedReader reader;

    public Teacher(String name, List<Student> studentList) {
        this.id = new Random().nextLong();
        this.name = name;
        this.studentList = new ArrayList<>();
        this.manager = new Manager();
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Teacher notlariOku() {
        try {
            reader = new BufferedReader(new FileReader(manager.getPath() + manager.getFile()));
            this.studentList = manager.dosyadanVeriOku(this.name, reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Teacher(this.name, studentList);
    }

    public void dosyaOlustur() {
        manager.ogretmenDosyasiOlustur(this.studentList, this.name);

    }

    public List<Student> dosyadanOgrencileriGetir() {
        return manager.ogrencileriGetir(this.name);
    }
}
