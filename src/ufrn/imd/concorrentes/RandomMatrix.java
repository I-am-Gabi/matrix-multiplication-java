package ufrn.imd.concorrentes;

import java.util.Random;

public class RandomMatrix {
	public static int[][] genNewMatrix(int n) { 		
		int[][] A = new int[n][n]; 	
		Random R = new Random(); 	
		 
		int i, j; 	
		for(i = 0; i < n ; i++) {
			for(j = 0; j < n ; j++) {
				A[i][j] = R.nextInt(256); 	
			}	
		}	
		return A; 
	}
}
