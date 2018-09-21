package arrayandstring.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonRepeatingSubstringWithNonRepeatingCharectersList {

    public static void main(String[] args) {
        System.out.println(new NonRepeatingSubstringWithNonRepeatingCharectersList().subStringsKDist("awaglknagawunagwkwagl", 4));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> subStringsKDist(String inputStr, int num)
    {
        List<String> list = new ArrayList<>();

        int beginIndex = 0;
        int endIndex = num;
        int counter[] = new int[26];
        while (beginIndex < inputStr.length() - (num - 1)) {
            Arrays.fill(counter, 0);

            String substring = inputStr.substring(beginIndex++, endIndex++);
            boolean repeating = false;
            for (int i = 0; i < substring.length(); i++) {
                int index = substring.charAt(i) - 'a';
                counter[index] +=1;
                if(counter[index] > 1) {
                    repeating = true;
                    break;
                }
            }
            if(!repeating && !list.contains(substring)) {
                list.add(substring);
            }
        }

        return list;
    }
    // METHOD SIGNATURE ENDS


}
