package arrayandstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostVisitedUrlSequence {
    private static Map<String, List<String>> urlUserMap;
    private static Map<String, Integer> sequenceCounterMap;

    static {
        urlUserMap = new HashMap<>();
        urlUserMap.put("u1", Arrays.stream(new String[]{"a", "b", "c", "d", "e"}).collect(Collectors.toList()));
        urlUserMap.put("u2", Arrays.stream(new String[]{"c", "d", "e", "f", "g", "a"}).collect(Collectors.toList()));
        urlUserMap.put("u3", Arrays.stream(new String[]{"a", "b", "c", "d", "e", "f"}).collect(Collectors.toList()));
        urlUserMap.put("u4", Arrays.stream(new String[]{"d", "e", "f"}).collect(Collectors.toList()));
        urlUserMap.put("u5", Arrays.stream(new String[]{"c", "d", "e", "f"}).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        sequenceCounterMap = new HashMap<>();
        urlUserMap.values().forEach(urlList -> {
            for (int i = 0; i < urlList.size(); i++) {
                int fistUrlIndex = i;
                int secondUrlIndex = fistUrlIndex + 1;
                int thirdUrlIndex = secondUrlIndex + 1;
                if (thirdUrlIndex >= urlList.size()) {
                    break;
                }
                String firstUrl = urlList.get(fistUrlIndex);
                String secondUrl = urlList.get(secondUrlIndex);
                String thirdUrl = urlList.get(thirdUrlIndex);

                String urlSequenceKey = firstUrl + secondUrl + thirdUrl;
                if (sequenceCounterMap.containsKey(urlSequenceKey)) {
                    sequenceCounterMap.replace(urlSequenceKey, sequenceCounterMap.get(urlSequenceKey) + 1);
                } else {
                    sequenceCounterMap.put(urlSequenceKey, 1);
                }
            }
        });

        System.out.println(sequenceCounterMap);
    }
}
