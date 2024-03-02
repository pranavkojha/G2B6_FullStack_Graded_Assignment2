import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of floors in the building: ");
        int N = scanner.nextInt();
        List<Integer> floors = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            System.out.print("Enter the floor size given on day " + (i + 1) + ": ");
            int size = scanner.nextInt();
            floors.add(size);
        }
        List<Integer> assembledFloors = constructSkyscraper(N, floors);
        System.out.println("The order of construction is as follows:");
        int day = 1;
        for (int floorSize : assembledFloors) {
            if (floorSize != 0) {
                System.out.println("Day: " + day + " " + floorSize);
                day++;
            } else {
                System.out.println("Day: " + day);
                day++;
            }
        }
    }
    public static List<Integer> constructSkyscraper(int N, List<Integer> floors) {
        List<Integer> assembledFloors = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int currentFloorSize = floors.get(i);
            priorityQueue.add(currentFloorSize);
            while (!priorityQueue.isEmpty() && priorityQueue.peek() == N - i) {
                assembledFloors.add(priorityQueue.poll());
                N--;
            }
        }
        for (int i = 0; i < N; i++) 
            assembledFloors.add(0);
        return assembledFloors;
    }
}