package org.example;

import org.example.model.Music;
import org.example.service.MusicService;
import org.example.service.StudentService;
import org.postgresql.ds.PGSimpleDataSource;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MusicService service;
        try {
            DataSourceManager manager = DataSourceManager.getInstance();
            service = new MusicService(manager.getDataSource());
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        service.clearMusic();
        System.out.println("Task 1:");
        service.findAll().orElse(new ArrayList<>()).forEach(System.out::println);
        System.out.println("\nTask 2");
        service.findByNotAlikeTwoLetters("t","m").orElse(new ArrayList<>()).forEach(System.out::println);
        System.out.println("\nTask 3");
        service.addNewMusic(new Music(21,"Bury the Light"));
        service.findAll().orElse(new ArrayList<>()).forEach(System.out::println);
        service.clearMusic();
        StudentService serviceS;
        try {
            DataSourceManager manager = DataSourceManager.getInstance();
            serviceS = new StudentService(manager.getDataSource());
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}