package lambda.fanction.constructorreferences.newconstractor;

import java.util.function.Supplier;

public class NewConstructorDemo {

    public static void main(String[] args) {
        Supplier<NewConstructor> newConstructor = NewConstructorImpl::new;

        System.out.println("Constructor declared but not called by Java.");

        newConstructor.get().doSomething();


    }
}
