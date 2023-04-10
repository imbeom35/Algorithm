import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] field = new int[10][10];
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int y=0; y<10; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<10; x++) {
				field[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] paper = new int[5];
		Arrays.fill(paper, 5);
		
		dfs(0, 0, paper, 0);
		
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
		
		br.close();
	}
	
	static void dfs(int x, int y, int[] paper, int depth) {
		if(x == 0 && y == 10) {
			ans = Math.min(ans, depth);
			return;
		}
		
		if(field[y][x] == 1) {
			for(int size=4; size>=0; size--) {
				if(paper[size] > 0 && isValid(x, y, size)) {
					fillArray(field, x, y, size, 0);
					paper[size]--;
					dfs(x, y, paper, depth+1);
					fillArray(field, x, y, size, 1);
					paper[size]++;
				}
			}
		} else {
			dfs((x+1)%10, y+(x+1)/10, paper, depth);
		}
	}
	
	static boolean isValid(int x, int y, int size) {
		for(int ny=y; ny<=y+size; ny++) {
			for(int nx=x; nx<=x+size; nx++) {
				if(!(0 <= ny && ny < 10 && 0 <= nx && nx < 10 && field[ny][nx] == 1)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void fillArray(int[][] arr, int x, int y, int size, int value) {
		for(int ny=y; ny<=y+size; ny++) {
			for(int nx=x; nx<=x+size; nx++) {
				arr[ny][nx] = value;
			}
		}
	}
}
