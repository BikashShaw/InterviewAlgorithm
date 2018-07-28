package arrayandstring.leetcode;

public class Sum4II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int counter = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    for (int l = 0; l < D.length; l++) {
                        if(A[i] + B[j] + C[k] + D[l] == 0) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }
}
