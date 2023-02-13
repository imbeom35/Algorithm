import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> que = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			que.add(i);
		}
		
		int count = 1;
		while(!que.isEmpty()) {
			if(count%K == 0) {
				if(que.size() == 1) {
					sb.append(que.poll());
				}else {
					sb.append(que.poll()).append(", ");
				}
			}else {
				que.add(que.poll());
			}
			
			count++;
		}
		
		System.out.println("<" + sb + ">");
		
		br.close();
	}
}
