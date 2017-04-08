package arrayandstring.matrix;

/**
 * K closest point to the center of a cartesian plane
 * Created by Bikash on 4/8/2017.
 */
public class KClosestPoints {

    public double distance2d(int x1, int y1, int x2, int y2) {
        return Math.sqrt((Math.pow(x2-x1, 2)+(Math.pow(y2-y1,2))));
    }

    //TODO: Do it for 3D plan
    public double distance3d(int x1, int y1,int z1, int x2, int y2,int z2) {
        return Math.sqrt((Math.pow(x2-x1, 2)+ Math.pow(y2-y1,2) + Math.pow(z2-z1, 2)));
    }

    public static void main(String[] args) {
        int origin[] = new int[] {0,0};
        int points[][] = new int[][] {{1,4},{-2,1},{2,2},{0,8},{-1,-2},{1,-1}};
        int closestPoint[] = new int[] {0,0};

        double closestDistance = Double.MAX_VALUE;

        KClosestPoints kClosestPoints = new KClosestPoints();

        for (int[] point : points) {
            double distance2d = kClosestPoints.distance2d(origin[0], origin[1], point[0], point[1]);
            if (distance2d < closestDistance) {
                closestDistance = distance2d;
                closestPoint[0] = point[0];
                closestPoint[1] = point[1];
            }
        }
        System.out.println(closestPoint[0]+ "," + closestPoint[1] +
                " is closest point to the center of a cartesian plane with distance " + closestDistance);
    }
}
