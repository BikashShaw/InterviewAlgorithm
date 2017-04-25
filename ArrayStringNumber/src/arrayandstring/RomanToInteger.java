package arrayandstring;

/**
 * Roman to numeric conversion
 * Created by Bikash on 4/8/2017.
 */
public class RomanToInteger {

    public static int convert(String roman) {
        int nums[]=new int[roman.length()];
        for(int i=0;i<roman.length();i++){
            switch (roman.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
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
        System.out.println("IX : " + RomanToInteger.convert("IX"));
        System.out.println("XI : " + RomanToInteger.convert("XI"));
        System.out.println("DCXXI : " + RomanToInteger.convert("DCXXI"));
    }
}
