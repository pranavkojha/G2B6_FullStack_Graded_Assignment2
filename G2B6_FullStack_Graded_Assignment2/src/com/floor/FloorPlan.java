package com.floor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

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

    /**
     * Main algorithm that prints the floors need to be constructed on which day.
     */
    public void printFloorPlan() {
        // Make a copy for floorSizeList.
        ArrayList<Integer> sortedFloorList = new ArrayList<Integer>(this.floorSizeList);

        // Sort the copy of list made above in descending order.
        Collections.sort(sortedFloorList, Collections.reverseOrder());

        // We use 2 indexes to track the floorSize and sorted floor size.
        int floorSizeIdx = 0, sortedFloorSizeIdx=0;
        Stack<Integer> stack = new Stack<>();
        while(floorSizeIdx < this.floorSizeList.size()) {
            System.out.println("Day: " + (floorSizeIdx+1));

            // Until we get the largest floor size ready, push all received floors to stack.
            if (this.floorSizeList.get(floorSizeIdx) != sortedFloorList.get(sortedFloorSizeIdx)) {
                System.out.println("");
                stack.push(this.floorSizeList.get(floorSizeIdx++));
            }
            // Once we receive the floor, we assemble the given floor along with rest of the floors.
            else
            {
                System.out.print(this.floorSizeList.get(floorSizeIdx++));
                sortedFloorSizeIdx++;

                // Assemble all smaller floor received as well.
                while(!stack.isEmpty()){
                    System.out.print(" " + stack.pop());
                    sortedFloorSizeIdx++;
                }
                System.out.println("");
            }
        }
    }

}
