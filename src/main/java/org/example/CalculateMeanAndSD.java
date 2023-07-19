package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CalculateMeanAndSD {

    public static void main(String[] args) {
        CalculateMeanAndSD calculateMeanAndSD = new CalculateMeanAndSD();
        calculateMeanAndSD.getVectorDetails();
    }

    public void getVectorDetails(){

        VectorInsertDemo vectorInsertDemo = new VectorInsertDemo();
        Map<Integer,List<String>> vectorDetailsMap = vectorInsertDemo.readTable("dipan", "XXXXXXXXXXX", "localhost");
        for (Map.Entry<Integer, List<String>> ee : vectorDetailsMap.entrySet()) {
            String key = String.valueOf(ee.getKey());
            System.out.println("keys "+key);
            List<String> values = ee.getValue();
            double[] doubleValues = toDoubleArray(values);
            double SD = calculateSD(doubleValues);
            System.out.format("Standard Deviation = %.6f", SD);

        }

    }

    public static double[] toDoubleArray(List<String> stringArray) {
        if (stringArray == null) {
            return null;
        }//from   ww  w  .j  a v a  2 s.c  om
        double[] result = new double[stringArray.size()];
        for (int i = 0; i < stringArray.size(); i++) {
            try {
                if (stringArray.get(i) != null) {
                    result[i] = Double.parseDouble(stringArray.get(i));
                } else {
                    result[i] = 0.0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                result[i] = 0;
            }
        }
        return result;
    }

    public double calculateSD(double numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        System.out.format("Mean = %.6f\n ", mean);

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
}
