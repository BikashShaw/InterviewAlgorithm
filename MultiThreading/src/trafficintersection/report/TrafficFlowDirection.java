package trafficintersection.report;

public class TrafficFlowDirection {

    int northSouthBound;
    int eastWestBound;

    public TrafficFlowDirection() {
        northSouthBound = 0;
        eastWestBound = 0;
    }

    public int getNorthSouthBound() {
        return northSouthBound;
    }

    public void setNorthSouthBound(int northSouthBound) {
        this.northSouthBound = northSouthBound;
    }

    public int getEastWestBound() {
        return eastWestBound;
    }

    public void setEastWestBound(int eastWestBound) {
        this.eastWestBound = eastWestBound;
    }

    @Override
    public String toString() {
        return String.format("N = %d; S = %d; E = %d; W = %d", northSouthBound, northSouthBound, eastWestBound, eastWestBound);
    }
}
