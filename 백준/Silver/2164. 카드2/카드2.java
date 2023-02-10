import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> que = new LinkedList<>();
		
		// 카드를 위에서부터 1~n의 순서로 놓기
		for(int i=1; i<=n; i++) {
			que.add(i);
		}
		
		int curValue = 0;
		int count = 0;
		while(!que.isEmpty()) {
			// 카드를 한 장 뽑는다.
			curValue = que.poll();
			
			// 뽑은 카드가 마지막 카드라면 해당 카드를 가지고 프로그램을 종료한다.
			if(!que.isEmpty()) {
				// 홀수번째로 뽑은 카드를 바닥에 버리고, 짝수번째로 뽑은 카드는 맨 밑에 놓는다.
				if(count++%2 == 1) {
					que.add(curValue);
				}
			}else {
				break;
			}
		}
		
		// 마지막으로 뽑은 카드를 출력한다.
		System.out.println(curValue);
	}
}
