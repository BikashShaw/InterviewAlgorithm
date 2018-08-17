package lambda.fanction.compareFunction;

public class CompareFunctionDemo {
    public static void main(String[] args) {
        CompareFunction<Integer> intIsGreaterThan = (o1, o2) -> o1 > o2;

        CompareFunction<Integer> intIsLessThan = (o1, o2) -> o1 < o2;

        CompareFunction<Double> doubleIsGreaterThan = (o1, o2) -> o1 > o2;

        CompareFunction<Double> doubleIsLessThan = (o1, o2) -> o1 < o2;

        System.out.println(intIsGreaterThan.compare(5,4));
        System.out.println(intIsGreaterThan.compare(4,5));
        System.out.println(intIsLessThan.compare(4,5));
        System.out.println(intIsLessThan.compare(5,4));


        System.out.println(doubleIsGreaterThan.compare(5.5,5.4));
        System.out.println(doubleIsGreaterThan.compare(5.4,5.5));
        System.out.println(doubleIsLessThan.compare(4.4,4.5));
        System.out.println(doubleIsLessThan.compare(4.5,4.4));

    }
}
