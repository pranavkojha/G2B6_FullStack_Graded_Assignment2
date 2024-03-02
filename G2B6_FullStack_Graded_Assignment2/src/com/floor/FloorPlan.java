package com.floor;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

public class FloorPlan {
    private Integer floors;
    private Integer[] floorSize;
    
    // Constructors.
    public FloorPlan() {
        // Accept floors.
        System.out.println("Enter total no. of floors in the building:");
        Scanner in = new Scanner(System.in);
        this.floors = in.nextInt();
        
        // Accept size on given day
        floorSize = new Integer[this.floors];
        for(int i=0; i < this.floors; i++) {
            System.out.println("\tEnter the floor size given on day " + (i+1) + ": ");
            this.floorSize[i] = in.nextInt();
        }
    }

    public FloorPlan(int floors) {
        // Accept floors.
        this.floors = floors;
        Scanner in = new Scanner(System.in);

        // Accept size on given day
        floorSize = new Integer[this.floors];
        for(int i=0; i < this.floors; i++) {
            System.out.println("\tEnter the floor size given on day " + (i+1) + ": ");
            this.floorSize[i] = in.nextInt();
        }
    }
    public FloorPlan(int floors, Integer[] floorSize) {
        // Accept floors.
        this.floors = floors;
        this.floorSize = floorSize;
    }

    public void printFloorPlan() {
        List<Integer> assembledFloors = this.constructSkyscraper();
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

    private List<Integer> constructSkyscraper() {
        List<Integer> assembledFloors = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < this.floors; i++) {
            int currentFloorSize = this.floorSize[i];
            priorityQueue.add(currentFloorSize);
            while (!priorityQueue.isEmpty() && priorityQueue.peek() == this.floors - i) {
                assembledFloors.add(priorityQueue.poll());
                this.floors--;
            }
        }
        for (int i = 0; i < this.floors; i++)
            assembledFloors.add(0);
        return assembledFloors;
    }

}
