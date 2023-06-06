package GoogleQuestions;

public class LatestBusTime {
    public int latestBusTime(int[] buses, int[] passengers, int capacity) {
        if(buses == null || passengers == null) {
            return 0;
        }
        int busIndex = 0;
        int passengerIndex = 0;

        while (busIndex < buses.length && passengerIndex < passengers.length) {
            if (passengers[passengerIndex] <= buses[busIndex]) {
                int passengersWaiting = passengers.length - passengerIndex;
                int passengersToBoard = Math.min(capacity, passengersWaiting);

                passengerIndex += passengersToBoard;
            }

            busIndex++;
        }

        if (passengerIndex == 0) {
            // No passengers boarded any bus
            return passengers[0] - 1;
        } else if (passengerIndex >= passengers.length) {
            // All passengers boarded buses
            return passengers[passengerIndex - 1];
        } else {
            // Some passengers boarded buses
            return passengers[passengerIndex] - 1;
        }
    }
    public static void main(String[] args) {
        LatestBusTime l = new LatestBusTime();
        int[] buses = {10,20};
        int[] passengers = {2,17,18,19,20};
        int capacity = 2;

        System.out.println(l.latestBusTime(buses, passengers, capacity));
    }
}
