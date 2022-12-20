import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				int A = Math.abs(a);
				int B = Math.abs(b);
				if(A == B) {
					if(a < b) {
						return -1;
					}else {
						return 1;
					}
				}else {
					if(A < B) {
						return -1;
					}else {
						return 1;
					}
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(que.isEmpty()) {
					sb.append("0" + "\n");
				}else {
					sb.append(que.poll() + "\n");
				}
			}else {
				que.add(x);
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
