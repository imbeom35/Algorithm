import java.io.*;

public class Main {
	public static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
	public static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		// 별을 찍을 공간생성
		char[][] space = new char[n][n];
		
		// 공간 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				space[i][j] = ' ';
			}
		}
		
		// 공간에 별찍기 : 공간의 크기와 정 가운데 좌표 전달
		printStar(space, n/2, n/2, n);
		
		// 공간을 StringBuilder에 저장
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(space[i][j]);
			}
			sb.append("\n");
		}
		
		// 출력
		System.out.println(sb.toString());
		
		br.close();
	}
	
	// 별을 찍는 함수 : 공간, x좌표, y좌표, 크기
	public static void printStar(char[][] space, int x, int y, int n) {
		// 크기가 3일 경우 별을 찍는다.
		if(n == 3) {
			// 현재 위치를 제외한 팔방에 별을 찍는다.
			for(int i=0; i<8; i++) {
				space[x+dx[i]][y+dy[i]] = '*';
			}
		}else {
			// 크기를 3으로 나눈다.
			n = n/3;
			
			// 현재 위치를 제외한 팔방의 좌표를 전달하여 재귀함수를 호출한다.
			// 각 좌표는 해당 크기 공간의 정 가운데가 된다.
			for(int i=0; i<8; i++) {
				printStar(space, x+dx[i]*n, y+dy[i]*n, n);
			}
		}
	}
}
