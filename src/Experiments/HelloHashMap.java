package Experiments;

import java.util.HashMap;
import java.util.Scanner;

public class HelloHashMap {

    public static void main(String[] args) {
        int[] numbers = new int[] { 10,20,30,40,50};
        System.out.println(numbers[2]);

        HashMap<String, String> fruitToColour = new HashMap<>();
        fruitToColour.put( "banana", "yellow");
        fruitToColour.put( "pumpkin", "orange");
        fruitToColour.put("apple", "red");
        fruitToColour.put("apple", "green");
        fruitToColour.put("tomato", "red");

        //index in an array
        //int x =numbers[index
        //lookup in hashMap
        //String colour = fruitToColour.get("banana")
        //prompt the user to enter a fruit
        System.out.println(" Enter a name of a fruit");
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()){

            String fruit = input.nextLine();
            if (fruit.equalsIgnoreCase( "q")) break;
            String colour = fruitToColour.get(fruit);
            System.out.println(colour);


        }
    }
}
