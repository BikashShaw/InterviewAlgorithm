package number;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Intersect3Arrays {

    public static void main(String[] args) {
        Intersect3Arrays intersect3Arrays = new Intersect3Arrays();
        int[] A = {1, 2, 3, 4, 5, 6, 11};
        int[] B = {2, 4, 6, 8, 9, 10, 11};
        int[] C = {1, 2, 3, 4, 6, 7, 11};


        System.out.println(intersect3Arrays.solution1(A, B, C));
        System.out.println(intersect3Arrays.solution2(A, B, C));
    }

    public List<Integer> solution2(int[] A, int[] B, int[] C) {
        List<Integer> output = new ArrayList<>();

        int n = A.length;

        int x = 0;
        int y = 0;
        int z = 0;

        while (x < n && y < n && z < n) {
            if ((A[x] == B[y]) && (A[x] == C[z])) {
                output.add(A[x]);
                x++;
                y++;
                z++;
            } else if (A[x] > B[y]) {
                y++;
            } else if (A[x] > C[z]) {
                z++;
            } else if (A[x] < B[y] || A[x] < C[z]) {
                x++;
            } else if (B[y] > C[z]) {
                z++;
            } else if (B[y] < C[z]) {
                y++;
            }
        }

        return output;
    }

    public List<Integer> solution1(int[] A, int[] B, int[] C) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> intersectionMap = new TreeMap<>();

        int n = A.length;

        for (int i = 0; i < n; i++) {
            int a = A[i];
            int b = B[i];
            int c = C[i];

            if (!intersectionMap.containsKey(a)) {
                intersectionMap.put(a, 1);
            } else {
                intersectionMap.replace(a, intersectionMap.get(a) + 1);
            }

            if (!intersectionMap.containsKey(b)) {
                intersectionMap.put(b, 1);
            } else {
                intersectionMap.replace(b, intersectionMap.get(b) + 1);
            }

            if (!intersectionMap.containsKey(c)) {
                intersectionMap.put(c, 1);
            } else {
                intersectionMap.replace(c, intersectionMap.get(c) + 1);
            }
        }

        for (Integer key : intersectionMap.keySet()) {
            if (intersectionMap.get(key) == 3) {
                output.add(key);
            }
        }
        return output;
    }
}
