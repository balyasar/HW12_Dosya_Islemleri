package com.yasar;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Manager {
    private Long id;
    public String file;
    private String path;

    public Manager() {
        this.id = new Random().nextLong();
        this.file = "ogrenciler.txt";
        this.path = "src/main/resources/";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Student> dosyadanVeriOku(String teacherName, BufferedReader bufferedReader) {
        List<Student> studentList = new ArrayList<>();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                String studentName = values[0];
                double not1 = Double.parseDouble(values[1]);
                double not2 = Double.parseDouble(values[2]);
                double not3 = Double.parseDouble(values[3]);
                String date = values[4];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
                LocalDate birthDay = LocalDate.parse(date, formatter);

                Student student = new Student(studentName, ((not1 + not2 + not3) / 3), birthDay);
                student.durumBelirle();
                studentList.add(student);
                System.out.println(teacherName + " isimli öğretmen " + studentName + " öğrencinin notlarını okudu.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return studentList;
    }


    public void ogretmenDosyasiOlustur(List<Student> studentList, String teacherName) {
        ObjectOutputStream write = null;
        try {
            write = new ObjectOutputStream(new FileOutputStream(this.path + teacherName + ".txt"));
            write.writeObject(studentList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                write.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Student> ogrencileriGetir(String teacherName) {
        List<Student> studentList = new ArrayList<>();
        ObjectInputStream read = null;

        try {
            read = new ObjectInputStream(new FileInputStream(this.path + teacherName + ".txt"));
            studentList.add((Student) read.readObject());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }
}
