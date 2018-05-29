
package robot_world;

import java.io.IOException;

public class RobotWorld {
       
	// These are constants representing possible
	// chars in the world map

	public static final char SPACE = ' ';
	public static final char WALL = '#';
	public static final char GOAL = 'G';

	public static final char NORTH = '^';
	public static final char SOUTH = 'V';
	public static final char EAST = '>';
	public static final char WEST = '<';
	
    // Fields 
    
    // The map of the world
	private char[][] worldMap;
    
	// The dimensions of the world map
	private int maxRows, maxColumns;
	
	// The location of the robot
	private int robotRow, robotColumn;
    
	
    public RobotWorld(String mapFileName) throws IOException {
        
    	// This loads the file data into the world map
    	
        WorldMapReader wmr = new WorldMapReader();
        worldMap = wmr.readWorldMap(mapFileName);
        
        // This saves the dimensions of the world map
        maxRows = wmr.getMaxRows();
        maxColumns = wmr.getMaxColumns();
        
        // This sets the location of the robot to the initial position
        // shown in the file
        robotRow = wmr.getInitRobotRow();
        robotColumn = wmr.getInitRobotColumn();
    }
    
 
    /**
     * Changes the direction of the robot by rotating it clockwise
     * 90 degrees
     */
    public void rotateClockwise() {
        switch(worldMap[robotRow][robotColumn]){
            case NORTH:
                worldMap[robotRow][robotColumn] = EAST;
                break;
            case EAST:
                worldMap[robotRow][robotColumn] = SOUTH;
                break;
            case SOUTH:
                worldMap[robotRow][robotColumn] = WEST;
                break;
            case WEST:
                worldMap[robotRow][robotColumn] = NORTH;
                break;
        }
    }
    
    
    /**
     * Changes the direction of the robot by rotating it counter-
     * clockwise 90 degrees
     */
    public void rotateCounterClockwise() {
        switch(worldMap[robotRow][robotColumn]){
            case NORTH:
                worldMap[robotRow][robotColumn] = WEST;
                break;
            case EAST:
                worldMap[robotRow][robotColumn] = NORTH;
                break;
            case SOUTH:
                worldMap[robotRow][robotColumn] = EAST;
                break;
            case WEST:
                worldMap[robotRow][robotColumn] = SOUTH;
                break;
        }
    }
    
    
    /**
     * Moves the robot forward one place, as long as it is not 
     * directly in front of a wall (if it is, throw an exception).
     * Also outputs a message if the robot finds the goal
     */
    public void moveForward() throws Exception {
        int newRow = robotRow, newCol = robotColumn;
        switch(worldMap[robotRow][robotColumn]){
            case NORTH:
                newRow--;
                break;
            case EAST:
                newCol++;
                break;
            case SOUTH:
                newRow++;
                break;
            case WEST:
                newCol--;
                break;
        }
        if(newRow == maxRows || newRow < 0 || newCol == maxColumns || newCol < 0 || worldMap[newRow][newCol] == WALL)throw new Exception("Impossible to move forward!");
        else if(worldMap[newRow][newCol] == GOAL)System.out.println("SUCCESS!");
        worldMap[newRow][newCol] = worldMap[robotRow][robotColumn];
        worldMap[robotRow][robotColumn] = SPACE;
        robotRow = newRow;
        robotColumn = newCol;
    }
    
    
    public void printCurrentWorldMap() {
    	
    	for (int i = 0; i < maxRows; i++) {
    		for (int j = 0; j < maxColumns; j++) {
    			System.out.print(worldMap[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
