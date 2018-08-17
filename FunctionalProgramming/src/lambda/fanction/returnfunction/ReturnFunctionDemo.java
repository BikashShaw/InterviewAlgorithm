package lambda.fanction.returnfunction;

public class ReturnFunctionDemo {
    public static void main(String[] args) {

        ReturnFunction<Integer> sumInt = (i1, i2) -> i1 + i2;

        ReturnFunction<Double> sumDouble = (i1, i2) -> i1 + i2;

        ReturnFunction<String> concat = (i1, i2) -> i1 + i2;

        System.out.println(sumInt.returnSomething(20, 25));

        System.out.println(sumDouble.returnSomething(20.5, 25.5));

        System.out.println(concat.returnSomething("Hello ", "World!"));

    }
}
