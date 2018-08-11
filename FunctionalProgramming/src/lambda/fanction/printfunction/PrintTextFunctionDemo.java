package lambda.fanction.printfunction;

public class PrintTextFunctionDemo {

    public static void main(String[] args) {
        PrintTextFunction<String> printTextFunctionImpl1 = text -> System.out.println(text);

        PrintTextFunction<String> printTextFunctionImpl2 = System.out::println;

        PrintTextFunction<Double> printTextFunctionDoubleImpl = System.out::println;

        printTextFunctionImpl1.print("Hello World!");
        printTextFunctionImpl2.print("Hello World!!");
        printTextFunctionDoubleImpl.print(55.456d);
    }
}
