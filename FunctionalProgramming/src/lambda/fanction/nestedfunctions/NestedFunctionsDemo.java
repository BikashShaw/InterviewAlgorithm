package lambda.fanction.nestedfunctions;

import java.util.function.Function;

public class NestedFunctionsDemo {

    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
        Function<Integer, Function<Integer, Integer>> multiply = x -> y -> x * y;

        System.out.println("5 + 6 : " + add.apply(5).apply(6));

        System.out.println("5 * 6 : " + multiply.apply(5).apply(6));

        Function<Integer, Integer> times2 = e -> e * 2;

        Function<Integer, Integer> squared = e -> e * e;

        // Returns 32
        System.out.println("First **compose** then **apply**: (4 * 4 ) * 2 : " + times2.compose(squared).apply(4));

        // Returns 64
        System.out.println("First **apply** then **andThen**: (4 * 2) * (4 * 2): " + times2.andThen(squared).apply(4));
    }
}
