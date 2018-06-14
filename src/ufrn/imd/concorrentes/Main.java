package ufrn.imd.concorrentes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
	
	static int[] getColumn(int[][] matrix, int column) {
	    return IntStream.range(0, matrix.length)
	        .map(i -> matrix[i][column]).toArray();
	}

	public static void main(String[] args) { 
		int nThreads = 10; 
		
		int[][] A = RandomMatrix.genNewMatrix(nThreads);
		
		for (int[] line : A) {
			for (int i : line) 
				System.out.print(i + " "); 
			System.out.println();
		}
		
		System.out.println("\n"); 
		
	    int[][] B = RandomMatrix.genNewMatrix(nThreads);
		
		for (int[] line : B) {
			for (int i : line) 
				System.out.print(i + " "); 
			System.out.println();
		}
		
	    int[][] C = new int[nThreads][nThreads];
	    
		ExecutorService executor = Executors.newFixedThreadPool(nThreads); 
	     
	    // create and execute threads
	    for (int t = 0; t < nThreads; t++) {
	    		int[] va = getColumn(A, t);
	    		int[] vb = B[t];
	    		
	    	 	Runnable r = new Task(C, nThreads, va, vb);
	    	 	System.out.println("Executando tarefa #" + t);
	    	 	executor.execute(r);
	    }
	    executor.shutdown();
	    
	    for (int[] line : C) {
			for (int i : line) 
				System.out.print(i + " "); 
			System.out.println();
		}
	} 
}
