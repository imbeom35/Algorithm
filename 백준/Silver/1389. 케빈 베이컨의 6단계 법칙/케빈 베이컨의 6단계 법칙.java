import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] array = new boolean[N+1][N+1];
		int[][] rel_arr = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			array[A][B] = true;
			array[B][A] = true;
		}
		
		int min = 1000000;
		int min_value = 0;
		
		for(int i=1; i<N+1; i++) {
			int sum = 0;
			
			for(int j=1; j<N+1; j++) {
				if(i != j) {
					if(rel_arr[i][j] == 0) {
						rel_arr[i][j] = relation(array, i, j);
						rel_arr[j][i] = rel_arr[i][j];
					}
					sum += rel_arr[i][j];
				}
			}
			
			if(sum < min) {
				min = sum;
				min_value = i;
			}
		}
		
		System.out.println(min_value);
		
		br.close();
	}
	
	public static int relation(boolean[][] arr, int a, int b) {
		int deep = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(a);
		
		while(!queue.isEmpty()) {
			// a와 연결된 값들을 큐에 저장
			// 값들중에 b가 있을 경우 1을 반환
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int x = queue.poll();
				
				for(int j=0; j<arr.length; j++) {
					if(arr[x][j] == true) {
						if(j == b) {
							return deep;
						} else {
							queue.add(j);
						}
					}
				}
			}
			
			deep++;
		}
		
		return -1;
	}
}
