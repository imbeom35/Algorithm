import java.io.*;
import java.util.*;

public class Main {
	public static int val = 1;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int N;
	public static int M;
	public static int[][] arr;
	public static boolean[][] check;
	public static Queue<Point> cheese = new LinkedList<Point>();
	public static Queue<Point> meltedCheese = new LinkedList<Point>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new boolean[N][M];
		int count = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findCheese(new Point(0, 0));
		
		while(!cheese.isEmpty()) {
			while(!cheese.isEmpty()) {
				melt(cheese.poll());
			}
			
			while(!meltedCheese.isEmpty()) {
				findCheese(meltedCheese.poll());
			}
			
			count++;
		}
		
		System.out.println(count);
		
		br.close();
	}
	
	public static void melt(Point p) {
		int sum = 0;
		
		for(int i=0; i<4; i++) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			
			if(0 <= x && x < M && 0 <= y && y < N && arr[y][x] == -1) {
				sum++;
			}
		}
		
		if(sum >= 2) {
			meltedCheese.add(p);
			arr[p.y][p.x] = 0;
		}
	}
	
	public static void findCheese(Point p) {
		if(check[p.y][p.x] == true) {
			return;
		}
		
		if(arr[p.y][p.x] == 0) {
			check[p.y][p.x] = true;
			arr[p.y][p.x] = -1;
			
			for(int i=0; i<4; i++) {
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				
				if(0 <= x && x < M && 0 <= y && y < N) {
					findCheese(new Point(x, y));
				}
			}
		}else if(arr[p.y][p.x] == 1) {
			cheese.add(p);
		}
	}
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
