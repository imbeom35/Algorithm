import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 돌아가는 라인의 수
		int count = Math.min(N, M) / 2;
		
		// 회전 횟수만큼 반복한다.
		for(int r=0; r<R; r++) {
			// 모든 라인에 적용한다.
			for(int i=0; i<count; i++) {
				// 각 라인을 회전하면서 첫번째 값은 덮어씌워지기 때문에 저장한다.
				int temp = arr[i][i];
				
				for(int x=i+1; x<M-i; x++) {
					arr[i][x-1] = arr[i][x];
				}
				
				for(int y=i+1; y<N-i; y++) {
					arr[y-1][M-1-i] = arr[y][M-1-i];
				}
				
				for(int x=M-2-i; x>=i; x--) {
					arr[N-1-i][x+1] = arr[N-1-i][x];
				}
				
				for(int y=N-2-i; y>=i; y--) {
					arr[y+1][i] = arr[y][i];
				}
				
				// 회전 후 마지막 값에 첫번째 값이 온다.
				arr[i+1][i] = temp;
			}
		}
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
	}
}
