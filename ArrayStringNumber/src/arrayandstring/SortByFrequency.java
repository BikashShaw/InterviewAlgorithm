package arrayandstring;

import java.util.*;

/**
 * Sort by Frequency at Time Complexity: O(n)
 * Asked by Amazon phone interview!
 * Created by Bikash on 3/16/2017.
 */
public class SortByFrequency {

    public static String sort(String givenString) {
        StringBuilder sortedString = new StringBuilder();
        final Hashtable<Character, Integer> characterIntegerHashtable = new Hashtable<>();
        List<Character> sortedList = new ArrayList<>();

        for (int i = 0; i < givenString.length() ; i++) {
            char ch = givenString.charAt(i);
            sortedList.add(ch);
            if(characterIntegerHashtable.containsKey(ch)) {
                characterIntegerHashtable.put(ch, characterIntegerHashtable.get(ch) + 1);
            } else {
                characterIntegerHashtable.put(ch, 1);
            }
        }

        sortedList.sort((o1, o2) ->  {

            Integer o2Cnt = characterIntegerHashtable.get(o2);
            Integer o1Cnt = characterIntegerHashtable.get(o1);
            return o2Cnt.equals(o1Cnt) ? o1  - o2 : o2Cnt - o1Cnt;
        });
        for (Character character : sortedList) {
            sortedString.append(character);
        }
        return sortedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(sort("loveleetcode"));
    }
}
