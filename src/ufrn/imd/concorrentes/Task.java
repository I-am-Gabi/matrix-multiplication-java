package ufrn.imd.concorrentes;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	
	int[] vector_a;
	int[] vector_b;
	int[][] matrix_r;
	int dimension;
	
	public Task(int[][] matrix_r, int dimension, int[] vector_a, int[] vector_b) {
		this.matrix_r = matrix_r;
		this.dimension = dimension;
		this.vector_a = vector_a;
		this.vector_b = vector_b;
	}
	
	@Override 
	public void run() {
		try {
			String nome = Thread.currentThread().getName();
			for (int i = 0; i < dimension; ++i) {  
		    		for (int j = 0; j < dimension; ++j) {  
		    			int sum = vector_a[i] * vector_b[j];
				    matrix_r[i][j] += sum;
				}
		    }
			System.out.println("Thread " + nome + " executando");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
