import java.io.*;
import java.util.*;

public class Main {
	public static int plus = 0;
	public static int minus = 0;
	public static int zero = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Cut(arr);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);

		br.close();
	}
	
	public static void Cut(int[][] arr) {
		int value = arr[0][0];
		boolean same = true;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(value != arr[i][j]) {
					same = false;
					break;
				}
			}
			if(same == false) {
				break;
			}
		}
		
		if(same == true) {
			if(value == 1) {
				plus ++;
			} else if(value == -1) {
				minus ++;
			} else if(value == 0) {
				zero ++;
			} else {
				System.out.println("error");
			}
		} else {
			int size = arr.length/3;
			
			int[][] sub_arr = new int[size][size];
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					for(int x=0; x<size; x++) {
						for(int y=0; y<size; y++) {
							sub_arr[x][y] = arr[size*i+x][size*j+y];
						}
					}
					
					Cut(sub_arr);
				}
			}
		}
	}
}
