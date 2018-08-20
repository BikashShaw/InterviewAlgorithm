package search.strings;

import java.util.List;

public interface PatternSearching {

    default void sampleOutput() {

        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        List<Integer> searchIndexes = this.search(text, pattern);

        System.out.println(text + " : " + pattern + " - " + searchIndexes);

        text = "THIS IS A TEST TEXT";
        pattern = "TEST";
        searchIndexes = this.search(text, pattern);

        System.out.println(text + " : " + pattern + " - " + searchIndexes);
    }

    List<Integer> search(String text, String pattern);
}
