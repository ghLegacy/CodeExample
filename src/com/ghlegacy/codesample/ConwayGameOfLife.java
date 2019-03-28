package com.ghlegacy.codesample;

import java.util.Random;

public class ConwayGameOfLife {
	
	private static boolean[][] currentStatus;
	
	ConwayGameOfLife(int totalRow, int totalCol) {	
		 this.currentStatus = new boolean[totalRow][totalCol];
	     final Random random = new Random();
	     
	     System.out.println("Initial Status of the cells: ");
	     
	     for (int row = 0; row < currentStatus.length; ++row) {
	    	 System.out.println("\n");
	         for (int col = 0; col < currentStatus[row].length; ++col) {
	             currentStatus[row][col] = random.nextBoolean();
		             if(currentStatus[row][col]){
		            	 System.out.print(1);
		             }
		             else
		             {
		            	 System.out.print(0);
		             }
	         }
	     }
     }
	
	 public static void main(final String... args) {
	    
		// Optionally, you can get these dimensions at runtime from the user
	    
		int row=8; 
	    int col=8;
		 
		ConwayGameOfLife gameofLife = new ConwayGameOfLife(row,col);
	        
        boolean[][] next = gameofLife.nextCellStatus(currentStatus, row,col);
        
        System.out.println("\n\nAfter regeneration status of the cells: ");
        
        for (row = 0; row < next.length; ++row) {
	    	 System.out.println("\n");
	         for (col = 0; col < next[row].length; ++col) {
			        if(next[row][col]){
			       	 	System.out.print(1);
			        }
			        else
			        {
			       	 	System.out.print(0);
			        }
	         }
        
	    }
	 }
	
	/*
	 * determine next status of a cell
	 */
	public boolean[][] nextCellStatus(boolean[][] currentStatus, int rowsTotal, int colsTotal) {

	    boolean[][] nextStatus = new boolean[rowsTotal][colsTotal];
	   
		// decides what will happen to cell
	    for (int row = 0; row < rowsTotal; row++) {
	        for (int col = 0; col < colsTotal; col++) {

	            int numOfNeighbours = countCellNeighbours(currentStatus, rowsTotal, colsTotal, row, col);

	            // under or over population, cell dies
	            if ((numOfNeighbours < 2) || (numOfNeighbours > 3)) {
	            	nextStatus[row][col] = false;
	            }

	            // cell lives on to next currentStatus
	            if (numOfNeighbours == 2) {
	            	nextStatus[row][col] = currentStatus[row][col];
	            }

	            // cell either stays alive, or is born
	            if (numOfNeighbours == 3) {
	            	nextStatus[row][col] = true;
	            }
	        }
	    }
	    
	    return nextStatus;
	}

	private static int countCellNeighbours(boolean[][] currentStatus, int rowsTotal, int colsTotal, int row, int col) {
		
		int numNeighbors = 0;

	    // Look NW
	    if ((row - 1 >= 0) && (col - 1 >= 0)) {
	        numNeighbors = currentStatus[row - 1][col - 1] ? numNeighbors + 1 : numNeighbors;
	    }
	    // Look W
	    if ((row >= 0) && (col - 1 >= 0)) {
	        numNeighbors = currentStatus[row][col - 1] ? numNeighbors + 1 : numNeighbors;
	    }
	    // Look SW
	    if ((row + 1 < currentStatus.length) && (col - 1 >= 0)) {
	        numNeighbors = currentStatus[row + 1][col - 1] ? numNeighbors + 1 : numNeighbors;
	    }
	    // Look S
	    if ((row + 1 < currentStatus.length) && (col < currentStatus[0].length)) {
	        numNeighbors = currentStatus[row + 1][col] ? numNeighbors + 1 : numNeighbors;
	    }
	    // Look SE
	    if ((row + 1 < currentStatus.length) && (col + 1 < currentStatus[0].length)) {
	        numNeighbors = currentStatus[row + 1][col + 1] ? numNeighbors + 1 : numNeighbors;
	    }
	    // Look E
	    if ((row < currentStatus.length) && (col + 1 < currentStatus[0].length)) {
	        numNeighbors = currentStatus[row][col + 1] ? numNeighbors + 1 : numNeighbors;
	    }
	    // Look NE
	    if ((row - 1 >= 0) && (col + 1 < currentStatus[0].length)) {
	        numNeighbors = currentStatus[row - 1][col + 1] ? numNeighbors + 1 : numNeighbors;
	    }
	    // Look N
	    if ((row - 1 >= 0) && (col < currentStatus[0].length)) {
	        numNeighbors = currentStatus[row - 1][col] ? numNeighbors + 1 : numNeighbors;
	    }

	    return numNeighbors;
	}
}
