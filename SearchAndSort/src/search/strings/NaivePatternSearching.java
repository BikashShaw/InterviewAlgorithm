package search.strings;

import java.util.ArrayList;
import java.util.List;

public class NaivePatternSearching implements PatternSearching {


    public static void main(String[] args) {
        new NaivePatternSearching().sampleOutput();
    }

    @Override
    public List<Integer> search(String text, String pattern) {
        List<Integer> indexes = new ArrayList<>();

        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();

        int m = textChars.length;
        int n = patternChars.length;

        for (int i = 0; i <= m - n; i++) {
            boolean found = true;
            for (int j = 0; j < n; j++) {
                if (textChars[i + j] != patternChars[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
