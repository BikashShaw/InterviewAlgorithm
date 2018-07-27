package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groupAnagramsMap = new GroupAnagrams().groupAnagrams(strs);


        System.out.println(groupAnagramsMap);


    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupAnagramsMap = new HashMap<>();
        for (String str : strs) {
            String anagramKey = getAnagramKey(str);

            if (!groupAnagramsMap.containsKey(anagramKey)) {
                groupAnagramsMap.put(anagramKey, new ArrayList<>());
            }
            groupAnagramsMap.get(anagramKey).add(str);
        }
        List<List<String>> lists = new ArrayList<>();
        for (String key : groupAnagramsMap.keySet()) {
            lists.add(groupAnagramsMap.get(key));
        }
        return lists;
    }

    public String getAnagramKey(String str) {
        Integer[] anagramArray = new Integer[26];
        Arrays.fill(anagramArray, 0);

        char[] chars = str.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            anagramArray[index] = 1 + anagramArray[index];
        }

        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0; i < anagramArray.length; i++) {
            Integer indexValue = anagramArray[i];
            if (indexValue > 0) {
                keyBuilder.append("I:");
                keyBuilder.append(i);
                keyBuilder.append("-V:");
                keyBuilder.append(indexValue);
            }

        }

        return keyBuilder.toString();
    }

}