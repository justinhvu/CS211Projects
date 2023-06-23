import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Exam {

    public static void fruitSort(Fruit[] fruitArray) {
        // ArrayList<Fruit> tempFruits = new ArrayList<Fruit>();
        // for (Fruit fruit : fruitArray) {
        //     tempFruits.add(fruit);
        // }
        // Collections.sort(tempFruits);
        // for (int i = 0; i < fruitArray.length; i++) {
        //     fruitArray[i] = tempFruits.get(i);
        // }

        Arrays.sort(fruitArray);

        // for (int i = 0; i < fruitArray.length; i++) {
        //     System.out.println(fruitArray[i].toString());
        // }
    }

    public static ArrayList<Fruit> find(Fruit[] fruitArray, int lowestCode, int highestCode) {
        ArrayList<Fruit> result = new ArrayList<Fruit>();
        for (Fruit fruit : fruitArray) {
            if (fruit instanceof Gala && fruit.getCode() >= lowestCode && fruit.getCode() <= highestCode) {
                result.add(fruit);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int numApples = 0;
        int numBananas = 0;
        int numGalas = 0;
        int arrayLength = 0;

        if (args.length != 0 && args.length != 3) {
            throw new IllegalArgumentException();
        }

        if(args.length == 0) {
            arrayLength = 6;
            numApples = 2;
            numBananas = 2;
            numGalas = 2;
        }

        else if (args.length == 3) {

            for (int i = 0; i < args.length; i++) {
                if (Integer.parseInt(args[i]) < 0) {
                    throw new IllegalArgumentException();
                }
                arrayLength += Integer.parseInt(args[i]);
            }
            numApples = Integer.parseInt(args[0]);
            numBananas = Integer.parseInt(args[1]);
            numGalas = Integer.parseInt(args[2]);

        }

        ArrayList<Fruit> tempFruits = new ArrayList<Fruit>();

        while (numApples > 0) {
            //System.out.println("Enter a code for an apple: ");
            Scanner scnr = new Scanner(System.in);
            int code = scnr.nextInt();
            Apple apple = new Apple(code, true, 10, 100);
            tempFruits.add(apple);
            numApples--;
        }

        while (numBananas > 0) {
            //System.out.println("Enter a code for a banana: ");
            Scanner scnr = new Scanner(System.in);
            int code = scnr.nextInt();
            Banana banana= new Banana(code, true, "Vietnam");
            tempFruits.add(banana);
            numBananas--;
        }

        while (numGalas > 0) {
            //System.out.println("Enter a code for a gala: ");
            Scanner scnr = new Scanner(System.in);
            int code = scnr.nextInt();
            Gala gala = new Gala(code, true, 10, 100);
            tempFruits.add(gala);
            numGalas--;
        }

        Fruit[] fruits = new Fruit[arrayLength];
        int index = 0;
        for (Fruit fruit : tempFruits) {
            fruits[index] = fruit;
            index++;
        }

        fruitSort(fruits);

        ArrayList<Fruit> afterFind = find(fruits, 0, 99999);

        // System.out.println();
        // System.out.println("Before sort");
        // for (Fruit fruit : tempFruits) {
        //     System.out.println(fruit.toString());
        // }

        // System.out.println();
        // fruitSort(fruits);
        // System.out.println("After sort");
        // for (Fruit fruit : tempFruits) {
        //     System.out.println(fruit.toString());
        // }

        // System.out.println();
        // ArrayList<Fruit> afterFind = find(fruits, 0, 99999);
        // System.out.println("After find");
        // for (Fruit fruit : afterFind) {
        //     System.out.println(fruit.toString());
        // }
    }
}