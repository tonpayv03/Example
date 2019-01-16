package com.company;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;

public class Main {

    static Connection connection = null;
    static Statement s = null;

    static String username = "root";
    static String password = "rootpassword";

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList();
        ReadFile();
    }

    public static void ArrayList() {
        ArrayList<DemoArrayList> names = new ArrayList<DemoArrayList>();

        names.add(new DemoArrayList("John", 20));
        names.add(new DemoArrayList("Joe", 15));
        names.add(new DemoArrayList("Anna", 18));
        names.add(new DemoArrayList("John", 14));
        names.add(new DemoArrayList("Anna", 13));
        names.add(new DemoArrayList("Sam", 15));
        names.add(new DemoArrayList("Joe", 13));

        System.out.println("\nExample Output");

        // Question 2 : Example Output
        for (int i = 0; i < names.size(); i++) { // i = 0 i < names.size จบ loop i++ ทีละ1
            DemoArrayList current = names.get(i);
            for (int j = i + 1; j < names.size(); j++) {
                DemoArrayList compare = names.get(j);
                if (current.getName().equals(compare.getName())) {
                    current.setScore(current.getScore() + compare.getScore());
                    names.remove(compare);
                    j--; // ลบ j ที่เป็นจริงออกจาก arraylist
                }
            }
        }
        for (DemoArrayList namelist : names) {
            System.out.println(namelist.toString());
        }

        System.out.println("\nSort The Students By Name: ");

        // Question 2.1 : Sort The Students By Name
        Collections.sort(names, new Comparator<DemoArrayList>() {
            @Override
            public int compare(DemoArrayList o1, DemoArrayList o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (DemoArrayList name : names)
            System.out.println(name.toString());
    }


    public static void ReadFile() throws FileNotFoundException {

        System.out.println("\nRead The File: ");

        // Question 2.2 : Read The File
        Scanner input = new Scanner(new File("D:\\Score.txt"));

        ArrayList<DemoArrayListFile> arr = new ArrayList<DemoArrayListFile>();

        while (input.hasNext()) {
            String nameRead = input.next();
            int scoreRead = input.nextInt();

            DemoArrayListFile data = new DemoArrayListFile(nameRead, scoreRead);
            arr.add((data));
        }
        for (DemoArrayListFile file : arr) {
            System.out.println(file.toStringSecond());
        }
        System.out.println("\nRead The File and Sum Score: ");

        //Question 2.2 : Read The File and Sum Score
        for (int n = 0; n < arr.size(); n++) {
            DemoArrayListFile first = arr.get(n);
            for (int m = n + 1; m < arr.size(); m++) {
                DemoArrayListFile second = arr.get(m);
                if (first.getNameRead().equals(second.getNameRead())) {
                    first.setScoreRead(first.getScoreRead() + second.getScoreRead());
                    arr.remove(second);
                    m--;
                }
            }
        }
        for (DemoArrayListFile filesecond : arr) {
            System.out.println(filesecond.toStringSecond());
        }
        System.out.println("\nRecord to Database: ");

        // Question 2.2 : Read the file into your data structure
        for (DemoArrayListFile filesscond : arr) {
            //Connect
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ilibrary?useSSL=false",username,password);

                s = connection.createStatement();

                String[] arrfile = filesscond.toStringSecond().split(" ");
                String sql = "INSERT INTO istudent" + "(student_name,student_score)" + "VALUES('" + arrfile[0] + "','" + arrfile[1] + "')";

                s.execute(sql);

                System.out.println("Record Inserted Success");

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // Close
            try {
                if (connection != null) {
                    s.close();
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
