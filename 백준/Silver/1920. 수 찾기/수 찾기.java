import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] B = new int[M];
		int[] result = new int[M];
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		Arrays.sort(A);
		for(int i=0; i<M; i++) {
			result[i] = binarySearch(A, B[i]);
		}
		
		for(int i=0; i<M; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static int binarySearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(key < arr[mid]) {
				end = mid - 1;
			} else if(key > arr[mid]) {
				start = mid + 1;
			} else {
				return 1;
			}
		}
		
		return 0;
	}
}