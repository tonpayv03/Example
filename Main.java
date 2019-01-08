package com.company;

import java.util.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList();

    }

    public static void ArrayList() {

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
        for(int i = 0; i < names.size(); i++) {
            demoArrayList current = names.get(i);
            for(int j = i + 1; j < names.size(); j++) {
                demoArrayList compare = names.get(j);
                if (current.getName().equals(compare.getName())) {
                    current.setScore(current.getScore() + compare.getScore());
                    names.remove(compare);
                    j--;
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
        for (demoArrayList name : names) {
            System.out.println(name.toString());
        }
    }
}
