import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(GetCount(coin, K));
		
		br.close();
	}
	
	public static int GetCount(int[] arr, int K) {
		int count = 0;
		int left = K;
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			int x = arr[arr.length - (i+1)];
			
			if(left >= x) {
				count += left/x;
				left = left%x;
			}
			
			if(left == 0) {
				break;
			}
		}
		return count;
	}
}
