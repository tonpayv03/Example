package com.company;

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList();

    }

    public static void ArrayList() throws FileNotFoundException {
        ArrayList<demoArrayList> names = new ArrayList<demoArrayList>();

        names.add(new demoArrayList("John", 20));
        names.add(new demoArrayList("Joe", 15));
        names.add(new demoArrayList("Anna", 18));
        names.add(new demoArrayList("John", 14));
        names.add(new demoArrayList("Anna", 13));
        names.add(new demoArrayList("Sam", 15));
        names.add(new demoArrayList("Joe", 13));

        System.out.println("\nExample Output");

        // Example Output
        for (int i = 0; i < names.size(); i++) { // i = 0 i < names.size จบ loop i++ ทีละ1
            demoArrayList current = names.get(i);
            for (int j = i + 1; j < names.size(); j++) {
                demoArrayList compare = names.get(j);
                if (current.getName().equals(compare.getName())) {
                    current.setScore(current.getScore() + compare.getScore());
                    names.remove(compare);
                    j--; // ลบ j ที่เป็นจริงออกจาก arraylist
                }
            }
        }
        for (demoArrayList namelist : names) {
            System.out.println(namelist.toString());
        }

        System.out.println("\nSort The Students By Name");

        // Sort The Students By Name
        Collections.sort(names, new Comparator<demoArrayList>() {
            @Override
            public int compare(demoArrayList o1, demoArrayList o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (demoArrayList name : names)
            System.out.println(name.toString());

        System.out.println("\nRead The File");

        // Read The File
        Scanner input = new Scanner(new File("D:\\Score.txt"));

        ArrayList<demoArrayListFile> arr = new ArrayList<demoArrayListFile>();

        while (input.hasNext()) {
            String NameRead = input.next();
            int ScoreRead = input.nextInt();

            demoArrayListFile data = new demoArrayListFile(NameRead,ScoreRead);
            arr.add(data);
        }
        for (demoArrayListFile file : arr) {
            System.out.println(file.toString());
        }

 /*       try {
            Path file = Paths.get("D:\\Score.txt");
            BufferedReader reader = Files.newBufferedReader(file , StandardCharsets.UTF_8);
            String line;
            while ((line = reader.readLine()) != null) {
                arr.add(line);
            }
            reader.close();
        }
        catch (IOException e) {
            System.err.println("IOException : " + e.getMessage());
        }
        System.out.println(arr); */
    }
}
