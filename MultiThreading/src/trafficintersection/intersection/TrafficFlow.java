package trafficintersection.intersection;

import trafficintersection.signal.TrafficSignal;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class TrafficFlow {
    private int totalSecond;
    private LinkedList<Integer> totalCarsPerSecondCounter;
    private AtomicInteger atomicInteger;

    public TrafficFlow(int totalSecond) {
        this.totalSecond = totalSecond;
        this.totalCarsPerSecondCounter = new LinkedList<>();
        this.atomicInteger = new AtomicInteger(0);
    }

    public LinkedList<Integer> flow(TrafficSignal currentTrafficSignal) {

        int carCount;
        int greenCount = 0;
        int redCount = 0;
        while (totalCarsPerSecondCounter.size() <= totalSecond) {
            carCount = atomicInteger.incrementAndGet();
            totalCarsPerSecondCounter.addLast(carCount);

            if (currentTrafficSignal == TrafficSignal.GREEN  && totalCarsPerSecondCounter.size()<=3) {
                exitIntersection();
                if(totalCarsPerSecondCounter.size() == 3) {
                    currentTrafficSignal = TrafficSignal.RED;
                    redCount = 0;
                    greenCount = 0;
                }
            } else if(currentTrafficSignal == TrafficSignal.RED) {
                if(redCount == 3) { // 0 - Added, 1 - Added,  2 - Added,  3 - Added :: Total Four
                    currentTrafficSignal = TrafficSignal.GREEN;
                    redCount = 0;
                    greenCount = 0;
                }
                redCount++;
            } else if(currentTrafficSignal == TrafficSignal.GREEN  && totalCarsPerSecondCounter.size() > 3) {
                if(greenCount < 1) { // 0 - Added (NOT removed)
                    greenCount++;
                } else if(greenCount<=2) { // 1 - Removed, 2 Removed
                    exitIntersection();
                    greenCount++;
                }

            }
        }


        return totalCarsPerSecondCounter;
    }

    private void exitIntersection() {
        int carCount;
        carCount = atomicInteger.decrementAndGet();
        totalCarsPerSecondCounter.removeLast();
        totalCarsPerSecondCounter.addLast(carCount);
    }
}
