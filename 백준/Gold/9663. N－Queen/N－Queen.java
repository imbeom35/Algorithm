import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int count;
	static int n;
	static int[] chess;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		chess = new int[n];
		
		nqueen(0);
		
		System.out.println(count);
		
		br.close();
	}
	
	// depth : x좌표, chess[depth] : y좌표
	public static void nqueen(int depth) {
		// 체스판에 n개를 모두 채웠을 경우 종료
		if(depth == n) {
			// 경우의 수 증가
			count++;
			return;
		}
		
		// 현재 x(depth)에서 선택 가능한 y좌표를 탐색한다.
		for(int y=0; y<n; y++) {
			// 이전 좌표가 없을 경우
			if(depth == 0) {
				chess[depth] = y;
				nqueen(depth+1);
			}else {
				boolean flag = true;
				
				// 이전의 모든 좌표와 비교한다.
				for(int preX=0; preX<depth; preX++) {
					// (depth, y)에 놓을 수 없는 경우
					if(!canbeplaced(depth, y, preX, chess[preX])) {
						flag = false;
					}
				}
				
				// (depth, y)에 놓기
				if(flag) {
					chess[depth] = y;
					nqueen(depth+1);
				}
			}
		}
	}
	
	// 두 퀸이 서로 공격할 수 없게 놓아져 있는지 확인
	public static boolean canbeplaced(int x1, int y1, int x2, int y2) {
		if(x1 == x2 || y1 == y2) {
			return false;
		}
		
		if(Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			return false;
		}
		
		return true;
	}
}
