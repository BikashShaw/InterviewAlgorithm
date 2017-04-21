package arrayandstring;

/**
 * Roman to numeric conversion
 * Created by Bikash on 4/8/2017.
 */
public class RomanToInteger {

    public static int convert(String roman) {
        int result = 0;

        for (int i = roman.length() -1 ; i >=0 ; i--) {
            char c = roman.charAt(i);

            switch (c) {
                case 'I' :
                    result += result >= 5 ? -1 : 1;
                    break;
                case 'V' :
                    result += 5;
                    break;
                case 'X' :
                    result += result >= 10 ? -10 : 10;
                    break;
                case 'L' :
                    result += result >= 50 ? -50 : 50;
                    break;
                case 'C' :
                    result += result >= 100 ? -100 : 100;
                    break;
                case 'D' :
                    result += 500;
                    break;
                case 'M' :
                    result +=1000;
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("IX : " + RomanToInteger.convert("IX"));
        System.out.println("XV : " + RomanToInteger.convert("XV"));
        System.out.println("XIV : " + RomanToInteger.convert("XIV"));
        System.out.println("XII : " + RomanToInteger.convert("XII"));
        System.out.println("LIV : " + RomanToInteger.convert("LIV"));
        System.out.println("LVX : " + RomanToInteger.convert("LVX"));
        System.out.println("LXVIII : " + RomanToInteger.convert("LXVIII"));
        System.out.println("LXVII : " + RomanToInteger.convert("LXVII"));
        System.out.println("MMMDXXXIX : " + RomanToInteger.convert("MMMDXXXIX"));
    }
}
