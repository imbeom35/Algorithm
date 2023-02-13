import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수신받을 수 있는 탑의 목록을 스택으로 구현
		Stack<Tower> stack = new Stack<>();
		
		// N개의 탑을 순차적으로 입력받는다.
		for(int i=1; i<=N; i++) {
			// 입력받은 탑의 높이
			int height = Integer.parseInt(st.nextToken());
			
			// 입력받은 탑의 신호를 수신하는 탑를 발견했는지 여부
			boolean findTower = false;

			// 수신받을 수 있는 탑의 목록 접근
			while(!stack.isEmpty()) {
				// 수신받을 수 있는 가장 가까운 탑을 발견
				if(stack.peek().height > height) {
					// 수신하는 탑의 번호 출력
					sb.append(stack.peek().index).append(" ");
					
					// 입력받은 탑을 수신받을 수 있는 탑 목록에 추가
					stack.add(new Tower(i, height));
					
					// 수신하는 탑이 존재
					findTower = true;
					
					break;
				}else {
					// 입력받은 타워보다 작을 경우 이후 오른쪽에서 신호를 수신받을 수 없다.
					stack.pop();
				}
			}
			
			// 수신하는 탑이 존재하지 않으면 0을 출력
			if(!findTower) {
				sb.append("0 ");
				// 입력받은 타워를 수신받을 수 있는 타워 목록에 추가
				stack.add(new Tower(i, height));
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static class Tower{
		int index;
		int height;
		
		Tower(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
}
