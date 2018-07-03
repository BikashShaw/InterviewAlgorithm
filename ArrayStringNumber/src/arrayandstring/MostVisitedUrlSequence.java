package arrayandstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostVisitedUrlSequence {
    private static Map<String,List<String>> urlUserMap;
    static {
        urlUserMap = new HashMap<>();
        urlUserMap.put("u1", Arrays.stream(new String[]{"a","b","c","d","e"}).collect(Collectors.toList()));
        urlUserMap.put("u2", Arrays.stream(new String[]{"c","d","e","f","g","a"}).collect(Collectors.toList()));
        urlUserMap.put("u3", Arrays.stream(new String[]{"a","b","c","d","e","f"}).collect(Collectors.toList()));
        urlUserMap.put("u4", Arrays.stream(new String[]{"d","e","f"}).collect(Collectors.toList()));
        urlUserMap.put("u5", Arrays.stream(new String[]{"c","d","e","f"}).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        urlUserMap.values().forEach(urlList -> {

        });
    }
}
