package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <br />
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of
 * five output “Buzz”.
 * <br />
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * Created by Bikash on 4/24/2017.
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> fizzBuzzList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean multiplesOfThree = i % 3 == 0;
            boolean multiplesOfFive = i % 5 == 0;

            if (multiplesOfThree && multiplesOfFive){
                fizzBuzzList.add("FizzBuzz");
            } else if (multiplesOfThree){
                fizzBuzzList.add("Fizz");
            } else if (multiplesOfFive){
                fizzBuzzList.add("Buzz");
            } else {
                fizzBuzzList.add(Integer.toString(i));
            }
        }
        return fizzBuzzList;
    }

    public static void main(String[] args) {
        new FizzBuzz().fizzBuzz(30).forEach(System.out::println);
    }
}
