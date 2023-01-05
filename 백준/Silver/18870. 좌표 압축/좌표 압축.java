import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] copy = arr.clone();
		Arrays.sort(copy);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			if(i == 0) {
				map.put(copy[i], i==0 ? 0 : map.get(copy[i-1])+1);
			}else if(i>0 && copy[i-1] != copy[i]) {
				map.put(copy[i], i==0 ? 0 : map.get(copy[i-1])+1);
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(map.get(arr[i]) + " ");
		}
		
		System.out.print(sb.toString());
		
		br.close();
	}
}
