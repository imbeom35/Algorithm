import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] input = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		input[0] = 0;
		for(int i=1; i<N+1; i++) {
			input[i] = input[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sum = input[e] - input[s-1];
			
			sb.append(sum + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
