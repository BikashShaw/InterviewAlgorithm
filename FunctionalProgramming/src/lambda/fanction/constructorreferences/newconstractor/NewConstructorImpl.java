package lambda.fanction.constructorreferences.newconstractor;

public class NewConstructorImpl implements NewConstructor {

    public NewConstructorImpl() {
        System.out.println("Constructor called.");
    }

    @Override
    public void doSomething() {
        System.out.println("doSomething called.");
    }
}
