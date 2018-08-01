package collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Bikash on 4/20/2017.
 */
public class Iterate {
    private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    private final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");


    public void iterateWithConsumer() {
        System.out.println("Using Anonymous Inner Class:");
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    public void iterateWithLambda() {
        System.out.println("Using Lambda Expression:");
        friends.forEach(System.out::println);
    }

    public void iterateWithMethodReference() {
        System.out.println("Using Method Reference:");
        friends.forEach(System.out::println);
    }

    public void iterateWithMethodReferenceUpperCaseTransform() {
        System.out.println("Using Method Reference Upper Case Transform:");
        friends.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public void findElements(String startsWith) {
        System.out.println("Find Elements Starts With " + startsWith +":");
        List<String> subList = friends.stream()
                .filter(name -> name.startsWith(startsWith))
                .collect(Collectors.toList());

        subList.forEach(System.out::println);
    }

    public void findElementsWithPredicate(String startsWith) {
        System.out.println("Find Elements Starts With " + startsWith +" Using Predicate:");

        final Predicate<String> startsWithPredicate = name -> name.startsWith(startsWith);

        System.out.println("Count Of Elements Starts With " + startsWith +" In List \"friends\":" + friends.stream().filter(startsWithPredicate).count());
        System.out.println("Count Of Elements Starts With " + startsWith +" In List \"editors\":" + editors.stream().filter(startsWithPredicate).count());

    }


    public static void main(String[] args) {
        Iterate iterate = new Iterate();
        iterate.iterateWithConsumer();
        iterate.iterateWithLambda();
        iterate.iterateWithMethodReference();
        iterate.iterateWithMethodReferenceUpperCaseTransform();
        iterate.findElements("N");
        iterate.findElements("S");
        iterate.findElementsWithPredicate("B");
        iterate.findElementsWithPredicate("S");
    }
}
