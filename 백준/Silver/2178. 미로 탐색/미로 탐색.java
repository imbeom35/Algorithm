import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[][] space = new int[y][x];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		queue.add(0);
		
		for(int i=0; i<y; i++) {
			String str = br.readLine();
			
			for(int j=0; j<x; j++) {
				space[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(maze(space, queue));
		
		br.close();
	}
	
	public static int maze(int[][] arr, Queue<Integer> queue) {
		int size = queue.size()/2;
		
		for(int i=0; i<size; i++){
			int x = queue.poll();
			int y = queue.poll();
			
			if(x == arr[0].length-1 && y == arr.length-1) {
				return 1;
			}
			
			
			if(0 <= x && x < arr[0].length && 0 <= y && y < arr.length) {
				if(arr[y][x] != 0) {
					queue.add(x+1);
					queue.add(y);
					
					queue.add(x-1);
					queue.add(y);
					
					queue.add(x);
					queue.add(y+1);
					
					queue.add(x);
					queue.add(y-1);
					
					arr[y][x] = 0;
				}
			}
		}
		
		return maze(arr, queue) + 1;
	}
}
