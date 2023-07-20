package org.example;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateRandomNumber {

    public List<Integer> generateRandomNumbers(){
        Random random = new Random();
        int randomNum =  random.nextInt(100);

        List<Integer> randoms = random.ints(randomNum)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Random Numbers :: "+randoms);
        return randoms;
    }

}
