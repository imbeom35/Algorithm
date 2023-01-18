import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	static int min = Integer.MIN_VALUE;
	static int[][] arr1, arr2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr1 = new int[n][3];
		arr2 = new int[n][3];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr1[i][0] = a;
			arr1[i][1] = b;
			arr1[i][2] = c;
			
			arr2[i][0] = a;
			arr2[i][1] = b;
			arr2[i][2] = c;
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<3; j++) {
				int max = 0;
				
				for(int k=-1; k<=1; k++) {
					if(0 <= j+k && j+k <= 2) {
						if(max < arr1[i-1][j+k]) {
							max = arr1[i-1][j+k];
						}
					}
				}
				
				arr1[i][j] += max;
			}
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<3; j++) {
				int min = Integer.MAX_VALUE;
				
				for(int k=-1; k<=1; k++) {
					if(0 <= j+k && j+k <= 2) {
						if(min > arr2[i-1][j+k]) {
							min = arr2[i-1][j+k];
						}
					}
				}
				
				arr2[i][j] += min;
			}
		}
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for(int val : arr1[n-1]) {
			if(val > max) {
				max = val;
			}
		}
		
		for(int val : arr2[n-1]) {
			if(val < min) {
				min = val;
			}
		}
		
		System.out.println(max + " " + min);
		
		br.close();
	}
}
