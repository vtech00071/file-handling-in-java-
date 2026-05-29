package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    static void main() {
        int attempts = 0;
        while (true) {
            attempts++;
            if (attempts > 2) {
                System.out.println("the two files have been read successfully ");
                break;
            } else {
                readFiles();
            }
        }
    }

    public static void readFiles() {
        System.out.print("which file do you want to read?: ");
        String choice = scanner.nextLine().strip().toLowerCase();
        String directory = "src/main/java/org/example/";
        directory += choice;

//        String choice = "src/main/java/org/example/config_file_development";
        try (
                FileReader file = new FileReader(directory);
                BufferedReader configFile = new BufferedReader(file);
        ) {
            HashMap<String, StringBuilder> storedFiles = new HashMap<>();
            String reader;
            StringBuilder thewords = new StringBuilder();
            while ((reader = configFile.readLine()) != null) {
                thewords.append(reader);
                thewords.append("\n");
                System.out.println(reader);
            }
            if (choice.equals("config_file_development")) {
                storedFiles.put("development", thewords);
            } else if (choice.equals("config_file_production")) {
                storedFiles.put("production", thewords);
            }
            System.out.println("enter \"production\" to get the production files ");
            System.out.println("enter \"development\" to get the development  files ");

            System.out.print("choose your choice: ");
            String getFiles = scanner.nextLine().strip().toLowerCase();
            if (getFiles.equals("production")) {
                System.out.println(storedFiles.get("production"));
            } else if (getFiles.equals("development")) {
                System.out.println(storedFiles.get("development"));
            } else {
                System.out.println("invalid input operation has been cancelled");
            }

        } catch (Exception e) {
            System.out.println("access denied cannot read the file " + e.getMessage());
        }
    }

}
