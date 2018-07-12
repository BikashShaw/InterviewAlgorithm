package datastructure.linear.amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * A queue of people are waiting to buy ice cream from you. <br />
 * Each person buys one ice cream, which sells for $5. <br />
 * Each customer is holding a bill of $5, $10 or $20. <br />
 * Your initial balance is 0. <br />
 * Find whether you will be able to make change for every customer in the queue. <br />
 * You must serve customers in the order they come in. <br />
 * </p>
 * <p>
 * <b>For example</b><br />
 * 5, 5, 5, 10, 20 -> true,<br />
 * 5, 5, 10 -> true,<br />
 * 10, 10 -> false<br />
 * </p>
 */
public class IceCreamVan {

    static boolean sellIceCream(Queue<Integer> customers) {
        boolean canSell = true;

        Integer $5bill = 0;
        Integer $10bill = 0;
        Integer $20bill = 0;

        while (!customers.isEmpty() && canSell) {
            Integer customerBill = customers.poll();
            if (customerBill == 5) {
                canSell = true;
                $5bill++;
            } else if (customerBill == 10) {
                if ($5bill > 0) {
                    canSell = true;
                    $5bill--;
                    $10bill++;
                } else {
                    canSell = false;
                }
            } else {
                if ($5bill >= 3 || ($5bill >= 1 && $10bill >= 1)) {
                    canSell = true;
                    $20bill++;
                    if ($10bill >= 1) {
                        $10bill--;
                        $5bill--;
                    } else {
                        $5bill -= 3;
                    }
                } else {
                    canSell = false;
                }
            }
        }
        return canSell;
    }

    public static void main(String[] args) {
        //True
        System.out.println(sellIceCream(new LinkedList<>(Arrays.asList(5, 5, 5, 10, 20))));
        System.out.println(sellIceCream(new LinkedList<>(Arrays.asList(5, 5, 10))));
        System.out.println(sellIceCream(new LinkedList<>(Arrays.asList(5, 5, 5, 20))));
        System.out.println(sellIceCream(new LinkedList<>(Arrays.asList(5, 5, 10, 20))));


        //False
        System.out.println(sellIceCream(new LinkedList<>(Arrays.asList(5, 10, 20))));
        System.out.println(sellIceCream(new LinkedList<>(Arrays.asList(10, 10, 10, 20))));
        System.out.println(sellIceCream(new LinkedList<>(Arrays.asList(5, 10, 10, 10, 20))));
    }
}
