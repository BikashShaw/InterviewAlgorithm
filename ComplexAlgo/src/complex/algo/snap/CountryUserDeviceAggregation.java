package complex.algo.snap;

import java.util.*;

/**
 * {"country":"AU","device":"iOS","last_char":"8","total_count":"328953"}
 * {"country":"BH","device":"Android","last_char":"9","total_count":"14832"}
 * {"country":"LB","device":"iOS","last_char":"d","total_count":"4525"}
 * {"country":"ID","device":"iOS","last_char":"6","total_count":"79613"}
 * {"country":"KW","device":"iOS","last_char":"y","total_count":"425374"}
 * {"country":"CH","device":"iOS","last_char":"s","total_count":"284796"}
 */
class  JsonObject {
    String country, device;
    char lastChar;
    int totalCount;

    public JsonObject(String country, String device, char lastChar, int totalCount) {
        this.country = country;
        this.device = device;
        this.lastChar = lastChar;
        this.totalCount = totalCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public char getLastChar() {
        return lastChar;
    }

    public void setLastChar(char lastChar) {
        this.lastChar = lastChar;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getValue(GroupBy key) {

        switch (key) {
            case COUNTRY:
                return getCountry();
            case DEVICE:
                return getDevice();
            case BOTH:
                return getCountry() + " : " + getDevice();
            default:
                return getCountry();
        }
    }
}

enum GroupBy {
    COUNTRY,
    DEVICE,
    BOTH
}
public class CountryUserDeviceAggregation {

    public static void main(String[] args) {

        List<JsonObject> data = new ArrayList<>(); // We have the full list
        data.add(new JsonObject("AU", "ios", 'a', 1));
        data.add(new JsonObject("AU", "Android", 'a', 2));
        data.add(new JsonObject("AU", "ios", 'b', 2));
        data.add(new JsonObject("AU", "ios", 'c', 1));
        data.add(new JsonObject("AU", "Android", 'c', 3));



        data.add(new JsonObject("US", "ios", 'a', 3));
        data.add(new JsonObject("US", "Android", 'a', 2));
        data.add(new JsonObject("US", "ios", 'c', 5));
        data.add(new JsonObject("US", "Android", 'd', 4));

        data.add(new JsonObject("IN", "ios", 'a', 1));
        data.add(new JsonObject("IN", "Android", 'a', 2));

        mostVarietyOfLastChar(data);

        mostFeqLastChar(data, GroupBy.COUNTRY);
        mostFeqLastChar(data, GroupBy.DEVICE);
        mostFeqLastChar(data, GroupBy.BOTH);

    }

    // key - US_a - Count
    private static void mostFeqLastChar(List<JsonObject> data, GroupBy groupByKey) {
        Map<String, Integer> mapLastChar = new HashMap<>();
        for (JsonObject jsonObject : data) {
            String key = jsonObject.getValue(groupByKey) + "_" + jsonObject.getLastChar();
            if(!mapLastChar.containsKey(key)) {
                mapLastChar.put(key, jsonObject.getTotalCount());
            }else {
                Integer count = mapLastChar.get(key);
                count += jsonObject.getTotalCount();
                mapLastChar.put(key, count);
            }
        }

        System.out.println(mapLastChar);

        int max = 0 ;
        String maxKey = "";
        String maxCh = "";

        for (String key : mapLastChar.keySet()) {
            Integer totalCount = mapLastChar.get(key);
            if(totalCount > max) {
                max = totalCount;
                String[] s = key.split("_");
                maxKey = s[0];
                maxCh = s[1];
            }
        }

        System.out.println(String.format("%s - %s : %d", maxKey, maxCh,  max));
    }

    private static void mostVarietyOfLastChar(List<JsonObject> data) {
        Map<String, Set<Character>> mapLastChar = new HashMap<>(); // Group by country code and count of last char

        for (JsonObject jsonObject : data) {
            Set<Character> lastCharacterSet;
            if(!mapLastChar.containsKey(jsonObject.getCountry())) {
                lastCharacterSet = new HashSet<>();
                mapLastChar.put(jsonObject.getCountry(), lastCharacterSet);
            } else {
                lastCharacterSet = mapLastChar.get(jsonObject.getCountry());

            }
            lastCharacterSet.add(jsonObject.getLastChar());
        }
        int max = 0 ;
        String maxCountry = "";

        for (String country : mapLastChar.keySet()) {
            Set<Character> lastCharacterSet = mapLastChar.get(country);
            if(lastCharacterSet.size() > max) {
                max = lastCharacterSet.size();
                maxCountry = country;
            }
        }

        System.out.println(String.format("%s : %d", maxCountry, max));
    }
}
