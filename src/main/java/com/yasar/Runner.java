package com.yasar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        new Thread(()->{
            Teacher teacher = new Teacher("Yaşar BAL", new ArrayList<>());
            teacher.notlariOku();
            teacher.dosyaOlustur();
            teacher.dosyadanOgrencileriGetir();
        }).start();
        
    }
}
