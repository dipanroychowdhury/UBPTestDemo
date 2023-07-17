package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome in UBP Insert Demo!");

//             for (int i = 1 ; i<= 100; i++) {
//                 Random random = new Random();
//                 int randomNum =  random.nextInt(2000);
//                 List<Integer> randoms = random.ints(randomNum)
//                         .boxed()
//                         .collect(Collectors.toList());
//                 System.out.println("random == " + randoms.toString());
//                 System.out.println("Size []  " + randoms.size());
//             }

        VectorInsertDemo vectorInsertDemo = new VectorInsertDemo();
        vectorInsertDemo.VectorDBInsert();
    }
}