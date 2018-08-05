package number;


public class HistogramLargestRectangle {

    public static void main(String[] args) {
        HistogramLargestRectangle histogramLargestRectangle = new HistogramLargestRectangle();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Max Area: " + histogramLargestRectangle.largestRectangleArea(heights));

        int[] heights1 = {2, 1, 2, 2, 2, 3};
        System.out.println("Max Area: " + histogramLargestRectangle.largestRectangleArea(heights1));
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minElement = heights[i];
            for (int j = i; j < heights.length; j++) {
                int currentValue = heights[j];
                if (maxArea == 0) {
                    minElement = currentValue;
                    maxArea = minElement;
                } else {
                    int newArea;
                    if (currentValue <= minElement) {
                        minElement = currentValue;
                        newArea = ((j - i) + 1) * minElement;
                    } else {
                        newArea = ((j - i) + 1) * minElement;
                    }
                    if (newArea > maxArea) {
                        maxArea = newArea;
                    }
                }
            }
        }
        return maxArea;
    }
}
