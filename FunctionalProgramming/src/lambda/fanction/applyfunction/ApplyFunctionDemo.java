package lambda.fanction.applyfunction;

public class ApplyFunctionDemo {

    public static void main(String[] args) {
        ApplyFunction applyFunction1 = () -> System.out.println("Call From applyFunction1");

        ApplyFunction applyFunction2 = () -> System.out.println("Call From applyFunction2");

        applyFunction1.apply();
        applyFunction2.apply();
    }
}
