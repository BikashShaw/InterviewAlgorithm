package arrayandstring.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * You have been given a task of reordering some data from a log file.
 * Every line in the log file is a space delimited list of strings and all lines begin with an identifier that is alphanumeric.
 * After the identifier, a line will consist of either a list of words using only English letters or only a list of integers.
 * There will be no lines that consist of only an identifier.
 * </p>
 * <p>
 * Your task is to reorder the data from the log file such that all the lines with words are at the top in the log file in lexicographical order.
 * Words are ordered lexicographically ignoring the identifier except in the case of ties.
 * In the case of ties (if there are two lines that are identical except for the identifier),
 * the identifier is used to order lexicographically.
 * Alphanumerics should be sorted in ASCII order (numbers come before letters).
 * The identifiers must still be part of the lines in the output Strings.
 * Lines with integers do not need to be sorted relative to other lines with integers.
 * </p>
 * <p>
 * Write an algorithm to reorder the data in the log file.
 * <br />
 * The input to the function/method consists of two arguments -
 * <br />
 * <b>logFileSize:</b> an integer representing the number of lines in the log file,
 * <br />
 * <b>logLines:</b> a list of strings representing the log file.
 * <br />
 * Output:
 * Return a list of strings representing the reordered log file data.
 * <br />
 * Note:
 * Identifier consists of only English letters and numbers. <br />
 * The lines with words are not required to match case and the sort needs to be case insensitive.
 * </p>
 * <b>Example:</b><br />
 * <b>Input:</b><br />
 * logFileSize = 5 <br />
 * logLines = <br />
 * [al 9 2 3 1] <br />
 * [g1 Act car] <br />
 * [zo4 4 7] <br />
 * [abl off KEY dog] <br />
 * [a8 act zoo] <br />
 *
 * <b>Output:</b><br />
 * [gl Act car] <br />
 * [a8 act zoo] <br />
 * [ab1 off KEY dog] <br />
 * [al 9 2 3 1] <br />
 * [zo4 4 7] <br />
 * <p>
 * <b>Explanation:</b><br />
 * Second, fourth. and fifth lines are the lines with words. According to the lexicographical order,
 * the second line will be reordered first in the log file, then fifth, and the fourth comes in the log file.
 * Next, the lines with numbers come in the order in which these lines were in the input.
 * </p>
 */
public class ReorderLogfile {

    public static List<String> logProcessor(List<String> list) {
        List<String> strAlp = new ArrayList<>();
        List<String> strNum = new ArrayList<>();
        List<String> alpNum = new ArrayList<>();

        for (String sl : list) {
            String[] slPart = sl.split(" ", 2);
            if (Character.isDigit(slPart[1].charAt(0))) {
                strNum.add(sl);
            } else {
                strAlp.add(slPart[1].concat(" " + slPart[0]));
            }
        }
        Collections.sort(strAlp);
        for (String sl2 : strAlp) {
            String[] part = {sl2.substring(0, sl2.lastIndexOf(" ")), sl2.substring(sl2.lastIndexOf(" ") + 1)};
            alpNum.add(part[1].concat(" " + part[0]));
        }
        alpNum.addAll(strNum);
        return alpNum;
    }

    public static void main(String[] args) {
        logProcessor(Arrays.asList("al 9 2 3 1", "g1 Act car", "zo4 4 7", "abl off KEY dog", "a8 act zoo")).forEach(System.out::println);
    }
}
