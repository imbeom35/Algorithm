import java.io.*;
import java.util.*;

public class Main {
	static boolean visited[] = new boolean[200000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		int x = 0;
		int count = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				x = queue.poll();
				
				if(x == M) {
					break;
				}
				
				if(visited[x] == true) {
					continue;
				} else {
					visited[x] = true;
				}
				
				if(x < M) {
					if(Math.abs(M-x) > Math.abs(M-(x*2))) {
						queue.add(x*2);
					}
					queue.add(x+1);
				}
				if(x-1 >= 0) {
					queue.add(x-1);
				}
			}
			
			if(x == M) {
				break;
			}
			
			count++;
		}
		
		System.out.println(count);
		
		br.close();
	}
}
