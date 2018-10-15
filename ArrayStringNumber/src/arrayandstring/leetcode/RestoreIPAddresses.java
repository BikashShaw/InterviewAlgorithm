package arrayandstring.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> outputList = new ArrayList<>();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    for (int d = 1; d <= 3; d++) {
                        if (a + b + c + d == s.length()) {
                            String aStr = s.substring(0, a);
                            String bStr = s.substring(a, a + b);
                            String cStr = s.substring(a + b, a + b + c);
                            String dStr = s.substring(a + b + c, a + b + c + d);

                            Integer aValue = Integer.valueOf(aStr);
                            Integer bValue = Integer.valueOf(bStr);
                            Integer cValue = Integer.valueOf(cStr);
                            Integer dValue = Integer.valueOf(dStr);
                            if (aValue <= 255 && bValue <= 255
                                    && cValue <= 255 && dValue <= 255) {
                                String ipAddress = aValue + "." + bValue + "." + cValue + "." + dValue;
                                if (ipAddress.length()  == s.length() + 3)
                                    outputList.add(ipAddress);
                            }

                        }
                    }
                }
            }
        }
        return outputList;
    }
}
