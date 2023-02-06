import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int n = Integer.parseInt(br.readLine());
		
		// 재귀함수 호출
		hanoi(n, 1, 3);
		
		// 출력
		System.out.println(count);
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static void hanoi(int n, int from, int to) {
		// 더는 옮길 것이 없으면 종료
		if(n <= 0) {
			return;
		}
		
		// 이동 횟수 증가
		count++;
		
		// 출발지와 목적지의 연산을 통해 임시장소의 위치 확인
		int tmp;
		if(from + to == 3) {
			tmp = 3;
		}else if(from + to == 4) {
			tmp = 2;
		}else {
			tmp = 1;
		}
		
		// 맨 아래 원판을 제외한 나머지 원판을 임시장소로 이동
		hanoi(n-1, from, tmp);
		
		// 맨 아래 원판을 목적지로 이동
		sb.append(from).append(" ").append(to).append("\n");
		
		// 나머지 원판을 목적지로 이동
		hanoi(n-1, tmp, to);
	}
}