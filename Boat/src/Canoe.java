import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;



public class tcss343 {
	private static int[] sizes = {4,5,10,15,20};


	/**
	 * This method will create 5 files. It will also populate those files with a matrix of
	 * a certain size.
	 */
	public static void fileGenerator() throws IOException{

		for (int i = 0; i < 5; i++) {	//for each matrix size, create a file	
			try {

				File statText = new File("Matrix" + sizes[i] + ".txt");
				FileOutputStream is = new FileOutputStream(statText);
				OutputStreamWriter osw = new OutputStreamWriter(is);    
				BufferedWriter w = new BufferedWriter(osw);

				for (int j = 0; j < sizes[i]; j++) {
					w.write(matrixWriter(sizes[i], j));
					w.newLine();
				}

				w.close();
			} catch (IOException e) {
				System.err.println("Problem writing to the file statsTest.txt");
			}
		}		
	}


	/**
	 * This method creates and returns one row of the matrix.
	 * @param i is the width and height of the matrix/
	 * @param theRow is the current row of the matrix that is being built.
	 * 			For example, for a 100x100 matrix theRow will be from 0 till 99.
	 *
	 * @return one line for the matrix.
	 */
	private static String matrixWriter(int i, int theRow) {

		//NOTE: the diagonal across the matrix will be filled with 0 values.
		//NOTE: the spots below the diagonal will be filled with NA value.

		String lineIt = "";

		for (int a = 0; a < theRow; a++ ) {
			lineIt += "NA";
			lineIt += '\t'; //add the tab
		}

		lineIt += 0; //add a single zero after adding all NAs for this line.
		lineIt += '\t';

		Random rn = new Random();
		for (int b = theRow + 1; b < i; b++) {
			lineIt += rn.nextInt(10) + 5 * b;
			if (b != (i - 1)) {
				lineIt += '\t';
			}
		}

		return lineIt;
	}


	public static  void printGrid(int[][] a){
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++){
				System.out.printf("%d ", a[i][j]);
			}
			System.out.println();
		}
	} 
	public static int[][] createGrid(String fileName) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File(fileName));
		int count = 0;
		while(input.hasNext()) {
			input.next();
			count ++;		
		}
		input = new Scanner(new File(fileName));
		int rows = (int) Math.sqrt(count);
		int table[][] = new int[rows][rows];
		int row = 0;
		int col = 0;
		while(input.hasNext()) {
			String next = input.next();
			if(next.equalsIgnoreCase("NA")) {
				table[row][col] = -1;
			} else {
				table[row][col] = Integer.parseInt(next);
			}
			col ++;
			if(col == rows)  {
				col = 0;
				row ++;
			}
		}
		return table;
	}
	public static List<Integer> bruteForceSol(int[] possibilities, int[][] grid) {
		List<Integer> path = null;
		int min = -1;
		for(int c = 0; c < Math.pow(2, possibilities.length); c++){
			List<Integer> create = new ArrayList<Integer>();
			for(int j = 0; j < possibilities.length; j ++ ) {
				if(((c >> j) & 1) == 1){
					create.add(possibilities[j]);
				}
			}
			//is this path valid ? Has Starting point and ending point?
			if(create.contains(possibilities[0]) &&
					create.contains(possibilities[possibilities.length - 1])) {
				int sum = 0;
				//calculate path 
				for(int count = 0; count < create.size() - 1; count ++) {
					sum += grid[create.get(count) - 1][create.get(count+1) - 1];
				}  
				if(min == - 1 || min > sum) {
					min = sum;
					path = create;
				}
			}
			//one possibility 

		}
		return path;
	}
	private static NodeAndMinCost divideAndConquer(int[][] grid, int start,
			int cost) {
		if(start == grid.length) {
			//we are done
			return new NodeAndMinCost(grid.length, cost, null);
		} else {
			NodeAndMinCost toReturn = new NodeAndMinCost(start, cost, null);
			NodeAndMinCost minCost = null;
			for(int attempt=start+1;attempt<=grid.length;attempt++){
				NodeAndMinCost costPath = divideAndConquer(grid, attempt, cost+grid[start-1][attempt-1]);
				if(minCost == null || costPath.minDistance < minCost.minDistance) {
					minCost = costPath;
				}
			}
			toReturn.minDistance = minCost.minDistance;
			toReturn.node = minCost;
			return toReturn;
		}	
	}
	public static NodeAndMinCost dijkstraShortestPath(int[][] grid, int start, int end) {
		Set<NodeAndMinCost> trackBeforeAndMin = new HashSet<NodeAndMinCost>();
		int minDistance = grid[start-1][end-1];
		NodeAndMinCost startLinker = new NodeAndMinCost(start, 0, null);
		NodeAndMinCost latestProcessedElement = startLinker;
		for(int k=start+1;k<=end;k++) {
			NodeAndMinCost current = new NodeAndMinCost(k, grid[start-1][k-1], startLinker);
			trackBeforeAndMin.add(current);
			if(grid[start-1][k-1] < minDistance) {
				minDistance = grid[start-1][k-1];
				latestProcessedElement = current;
			}
		}
		NodeAndMinCost next = latestProcessedElement;
		while(latestProcessedElement.value != end) {
			minDistance = Integer.MAX_VALUE;
			trackBeforeAndMin.remove(latestProcessedElement);
			for(NodeAndMinCost element: trackBeforeAndMin) {
				if(element.value > latestProcessedElement.value) {
					if(latestProcessedElement.minDistance + 
							grid[latestProcessedElement.value - 1][element.value-1] 
									< element.minDistance) {
						element.node = latestProcessedElement;
						element.minDistance = latestProcessedElement.minDistance + 
								grid[latestProcessedElement.value-1][element.value-1];
					}
				} 
				if(element.minDistance <= minDistance ) {
					next = element;
					minDistance = element.minDistance;
				}	
			}

			latestProcessedElement = next;
		} 
		return latestProcessedElement;

	}
	public static void main(String[] args) throws FileNotFoundException {
		//		 try {
		//				fileGenerator();
		//			} catch (IOException e) {
		//				// 
		//				e.printStackTrace();
		//			}

		
		Date startDate = new Date();
		Date finishDate = new Date();

		long startTime = 0;
		long finishTime = 0;
		
		long totalTime = 0;

		int grid[][] = createGrid(args[0]); //takes in the first string from the command line.
		int len = grid.length;
		int[] poss = new int[len];
		for(int l = 1; l <= len; l ++) {
			poss[l - 1] = l;
		}

		startDate = new Date();
        startTime = startDate.getTime();
		List<Integer> list = bruteForceSol(poss, grid); //
		finishDate = new Date();
		finishTime = finishDate.getTime();
		totalTime += (finishTime - startTime);
		System.out.println("Brute Force took " + totalTime + " milliseconds to run");
		int minCost = 0;
		for(int count=1;count < list.size();count++) {
			minCost += grid[list.get(count-1) - 1][list.get(count)-1];
		}
		System.out.println(list + " brute force min cost is " + minCost);


		startDate = new Date();
        startTime = startDate.getTime();
		NodeAndMinCost start = divideAndConquer(grid, 1, 0); //
		finishDate = new Date();
		finishTime = finishDate.getTime();
		totalTime += (finishTime - startTime);
		System.out.println("Divide and conquer took " + totalTime + " milliseconds to run");
		System.out.print ("[");
		printShortest(start); //TODO
		System.out.print ("] ");
		int divMinCost = 0;
		NodeAndMinCost previous = start;
		NodeAndMinCost current = start.node;
		while(current!= null) {
			divMinCost += grid[previous.value - 1][current.value - 1];
			previous = current;
			current = current.node;
		}
		System.out.println("divide and conquer min cost is " + divMinCost);
		
		
		startDate = new Date();
        startTime = startDate.getTime();
		NodeAndMinCost before = dijkstraShortestPath(grid, 1, len); //
		finishDate = new Date();
		finishTime = finishDate.getTime();
		totalTime += (finishTime - startTime);
		System.out.println("Dijkstras took " + totalTime + " milliseconds to run");
		System.out.print ("[");
		printDijkstra(before);
		System.out.print ("] ");
		System.out.println(" dijkstra shortest path is " + before.minDistance);

	}
	public static void printDijkstra(NodeAndMinCost toPrint) {
		if(toPrint!= null) {
			printDijkstra(toPrint.node);
			System.out.print(toPrint.value  + " ");
		}
	}
	public static void printShortest(NodeAndMinCost toPrint) {
		if(toPrint!= null) {
			System.out.print(toPrint.value  + " ");
			printShortest(toPrint.node);
		}
	}
	private static class NodeAndMinCost {
		private int value;
		private int minDistance;
		private NodeAndMinCost node;
		public NodeAndMinCost(int value, int minDistance, NodeAndMinCost before) {
			this.value = value;
			this.minDistance = minDistance;
			this.node = before;
		}

	}
}
