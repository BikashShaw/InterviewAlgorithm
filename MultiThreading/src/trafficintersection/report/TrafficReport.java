package trafficintersection.report;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficReport {

    private Map<Integer, TrafficFlowDirection> integerTrafficFlowDirectionMap;

    public TrafficReport(int size) {
        TrafficFlowDirection trafficFlowDirection = new TrafficFlowDirection();
        trafficFlowDirection.setNorthSouthBound(0);
        trafficFlowDirection.setEastWestBound(0);
        integerTrafficFlowDirectionMap = new ConcurrentHashMap<>(size);
        integerTrafficFlowDirectionMap.put(0, trafficFlowDirection);
    }

    public TrafficFlowDirection addNorthSouthBound(int second, int carCount) {
        TrafficFlowDirection trafficFlowDirection;
        if (integerTrafficFlowDirectionMap.containsKey(second)) {
            trafficFlowDirection = integerTrafficFlowDirectionMap.get(second);
            addNorthSouthBoundReport(second, carCount, trafficFlowDirection);
        } else {
            trafficFlowDirection = new TrafficFlowDirection();
            addNorthSouthBoundReport(second, carCount, trafficFlowDirection);
        }

        return trafficFlowDirection;
    }

    private void addNorthSouthBoundReport(int second, int carCount, TrafficFlowDirection trafficFlowDirection) {
        trafficFlowDirection.setNorthSouthBound(carCount);
        integerTrafficFlowDirectionMap.put(second, trafficFlowDirection);
    }

    public TrafficFlowDirection addEastWestBound(int second, int carCount) {
        TrafficFlowDirection trafficFlowDirection;
        if (integerTrafficFlowDirectionMap.containsKey(second)) {
            trafficFlowDirection = integerTrafficFlowDirectionMap.get(second);
            addEastWestBoundReport(second, carCount, trafficFlowDirection);
        } else {
            trafficFlowDirection = new TrafficFlowDirection();
            addEastWestBoundReport(second, carCount, trafficFlowDirection);
        }

        return trafficFlowDirection;
    }

    private void addEastWestBoundReport(int second, int carCount, TrafficFlowDirection trafficFlowDirection) {
        trafficFlowDirection.setEastWestBound(carCount);
        integerTrafficFlowDirectionMap.put(second, trafficFlowDirection);
    }

    public Map<Integer, TrafficFlowDirection> report() {
        return integerTrafficFlowDirectionMap;
    }
}
