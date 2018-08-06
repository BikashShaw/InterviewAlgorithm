package arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity O(n!)!!!
 * Created by Bikash on 3/26/2017.
 */
public class Permutation {

    List<String> permutations(String s) {
        List<String> permutationList = new ArrayList<>();
        performPermutation(s, 0, permutationList);

        return permutationList;

    }

    private void performPermutation(String s, int position, List<String> permutationList) {

        if (position >= s.length()) { //Exit Criteria
            return;
        }

        char positionChar = s.charAt(position);
        String rest = s.substring(0, position) +  s.substring(position+1, s.length());

        for (int i = 0; i < s.length(); i++) {
            String e = insertAt(positionChar, rest, i);
            if(!permutationList.contains(e)) {
                permutationList.add(e);
            }
        }
        performPermutation(s, position + 1, permutationList);
    }

    private String insertAt(char positionChar, String str, int location) {
        return str.substring(0, location) + positionChar + str.substring(location, str.length());
    }


    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        System.out.println( new Permutation().permutations("ABC"));

        new Permutation().permute("ABC", 0 , 2);
    }
}
