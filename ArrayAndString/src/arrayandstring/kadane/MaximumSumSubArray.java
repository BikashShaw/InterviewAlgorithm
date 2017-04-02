package arrayandstring.kadane;

/**
 * Created by Bikash on 3/11/2017.
 * Kadane's Algorithm to solve the Maximum Sum SubArray problem

 */
public class MaximumSumSubArray {
    class Result {
        int startIndex;
        int endIndex;
        int sum;

        private Result() {
            startIndex = 0;
            endIndex = 0;
            sum = Integer.MIN_VALUE;
        }

        @Override
        public String toString() {
            return "Start Index: " + startIndex + " End Index: " + endIndex + " Sum: " + sum;
        }
    }

    //Time Complexity: O(n)
    private Result maximumSum(int array[]) {
        assert array != null && array.length > 0 : "Array null or empty.";
        Result maxCurrent = new Result();
        Result max = new Result();

        for (int i = 0; i < array.length ; i++) {
            if(maxCurrent.sum < 0) {
                maxCurrent.sum = array[i];
                maxCurrent.startIndex = i;
                maxCurrent.endIndex = i;
            } else {
                maxCurrent.sum += array[i];
                maxCurrent.endIndex = i;
            }
            if(maxCurrent.sum > max.sum) {
                max.sum = maxCurrent.sum;
                max.startIndex = maxCurrent.startIndex;
                max.endIndex = maxCurrent.endIndex;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSumSubArray().maximumSum(new int[] {-1, -2, 3, 4, -5, 6, -18, 7}));
    }
}
