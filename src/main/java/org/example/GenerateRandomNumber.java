package org.example;

import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumber {
    public List<Integer> generateRandomNumbers(){
        int min = 1; // Minimum value of range
        int max = 100; // Maximum value of range
        int randomNumber = -1;
        List<Integer> randoms = new ArrayList<Integer>();
        // Print the min and max
        System.out.println("Random value in int from "+ min + " to " + max + ":");
        // Generate random int value from min to max
        for (int i = 1; i <= 2000; i++) {
            randomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
            // Printing the generated random numbers
//            System.out.println("Random Numbers :: "+randomNumber);
            randoms.add(randomNumber);
        }

        System.out.println(randoms);
        System.out.println(randoms.size());
        return randoms;
    }

}
