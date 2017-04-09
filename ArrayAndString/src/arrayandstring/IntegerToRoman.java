package arrayandstring;

/**
 * Convert integer to roman
 * Created by Bikash on 4/6/2017.
 */
public class IntegerToRoman {

    public static String convert(Integer number) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            for (int i = 0; i < values.length; i++) {
                if(number >= values[i]) {
                    number -= values[i];
                    sb.append(strs[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("1: " + IntegerToRoman.convert(1));
        System.out.println("3: " + IntegerToRoman.convert(3));
        System.out.println("4: " + IntegerToRoman.convert(4));
        System.out.println("5: " + IntegerToRoman.convert(5));
        System.out.println("9: " + IntegerToRoman.convert(9));
        System.out.println("11: " + IntegerToRoman.convert(11));
        System.out.println("22: " + IntegerToRoman.convert(22));
        System.out.println("154: " + IntegerToRoman.convert(154));
        System.out.println("591: " + IntegerToRoman.convert(591));
        System.out.println("3333: " + IntegerToRoman.convert(3333));
        System.out.println("409: " + IntegerToRoman.convert(409));
    }
}
