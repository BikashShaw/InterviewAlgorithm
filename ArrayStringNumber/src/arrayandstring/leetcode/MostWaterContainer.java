package arrayandstring.leetcode;

/**
 * Leetcode: https://leetcode.com/articles/container-with-most-water/
 */
public class MostWaterContainer {


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MostWaterContainer().maxArea(height));
    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        int pillerArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int dist = (j - i) * 2;
                int area = height[i] < height[j] ? height[i] * height[i] * dist: height[j] * height[j] * dist;
                if(area > maxArea) {
                    maxArea = area;
                    pillerArea = height[i] < height[j] ? height[i] * height[i] : height[j] * height[j];
                }
            }
        }

        return pillerArea;
    }

}
