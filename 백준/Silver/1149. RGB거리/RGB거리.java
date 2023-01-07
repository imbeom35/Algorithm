import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			if(i+1 > arr.length-1) {
				break;
			}
			
			if(arr[i][1] > arr[i][2]) {
				arr[i+1][0] += arr[i][2];
			}else {
				arr[i+1][0] += arr[i][1];
			}
			
			if(arr[i][0] > arr[i][2]) {
				arr[i+1][1] += arr[i][2];
			}else {
				arr[i+1][1] += arr[i][0];
			}
			
			if(arr[i][0] > arr[i][1]) {
				arr[i+1][2] += arr[i][1];
			}else {
				arr[i+1][2] += arr[i][0];
			}
		}
		
		int min = arr[N-1][0];
		for(int i=1; i<3; i++) {
			if(min > arr[N-1][i]) {
				min = arr[N-1][i];
			}
		}
		
		System.out.println(min);
		
		br.close();
	}
}