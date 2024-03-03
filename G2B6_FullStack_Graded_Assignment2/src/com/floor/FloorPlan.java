package com.floor;

import java.util.*;

public class FloorPlan {
    private Integer floors;
    private ArrayList<Integer> floorSizeList;
    
    // Constructors.
    public FloorPlan() {
        // Accept floors.
        System.out.println("Enter total no. of floors in the building:");
        Scanner in = new Scanner(System.in);
        this.floors = in.nextInt();
        
        // Accept size on given day
        floorSizeList = new ArrayList<Integer>();
        for(int i=0; i < this.floors; i++) {
            System.out.println("\tEnter the floor size given on day " + (i+1) + ": ");
            this.floorSizeList.add(in.nextInt());
        }
    }

    public FloorPlan(int floors) {
        // Accept floors.
        this.floors = floors;
        Scanner in = new Scanner(System.in);

        // Accept size on given day
        floorSizeList = new ArrayList<Integer>();
        for(int i=0; i < this.floors; i++) {
            System.out.println("\tEnter the floor size given on day " + (i+1) + ": ");
            this.floorSizeList.add(in.nextInt());
        }
    }
    public FloorPlan(int floors, ArrayList<Integer> floorSizeList) {
        // Accept floors.
        this.floors = floors;
        this.floorSizeList = floorSizeList;
    }

    public void printFloorPlan() {
        ArrayList<Integer> sortedFloorList = new ArrayList<Integer>(this.floorSizeList);
        Collections.sort(sortedFloorList, Collections.reverseOrder());
        int floorSizeIdx = 0, sortedFloorSizeIdx=0;
        Stack<Integer> stack = new Stack<>();
        while(floorSizeIdx < this.floorSizeList.size()) {
            System.out.println("Day: " + (floorSizeIdx+1));
            if (this.floorSizeList.get(floorSizeIdx) != sortedFloorList.get(sortedFloorSizeIdx)) {
                System.out.println("");
                stack.push(this.floorSizeList.get(floorSizeIdx++));
            } else {
                System.out.print(this.floorSizeList.get(floorSizeIdx++));
                sortedFloorSizeIdx++;
                while(!stack.isEmpty()){
                    System.out.print(" " + stack.pop());
                    sortedFloorSizeIdx++;
                }
                System.out.println("");
            }
        }
    }

}
