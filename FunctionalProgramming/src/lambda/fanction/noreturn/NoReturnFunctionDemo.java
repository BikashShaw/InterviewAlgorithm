package lambda.fanction.noreturn;

public class NoReturnFunctionDemo {

    public static void main(String[] args) {
        NoReturnFunction noReturnFunction = () -> System.out.println("Inside No Return No Argument Function.");

        noReturnFunction.noReturn();

        noReturnFunction = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i + ": Inside No Return No Argument Function.");
            }
        };

        noReturnFunction.noReturn();
    }

}
