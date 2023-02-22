import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				int value = Integer.parseInt(st.nextToken());
				max = Math.max(max, value);
				board[y][x] = value;
			}
		}
		
		moveBlock(board, 'U', 0);
		moveBlock(board, 'D', 0);
		moveBlock(board, 'L', 0);
		moveBlock(board, 'R', 0);
		
		System.out.println(max);
		
		br.close();
	}
	
	static void moveBlock(int[][] board, char direction, int depth) {
		int count = 0;
		
		int[][] temp = new int[N][N];
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				temp[y][x] = board[y][x];
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		
		switch(direction) {
		case 'U':
			for(int x=0; x<N; x++) {
				stack.clear();
				int in = 0;
				for(int y=0; y<N; y++) {
					if(temp[y][x] != 0) {
						if(stack.size() > 0 && stack.pop() == temp[y][x]) {
							temp[in-1][x] = temp[y][x]*2;
							temp[y][x] = 0;
							count++;
						}else {
							stack.add(temp[y][x]);
							if(in != y) {
								temp[in][x] = temp[y][x];
								temp[y][x] = 0;
								count++;
							}
							in++;
						}
					}
				}
			}
			break;
		case 'D':
			for(int x=0; x<N; x++) {
				stack.clear();
				int in = N-1;
				for(int y=N-1; y>=0; y--) {
					if(temp[y][x] != 0) {
						if(stack.size() > 0 && stack.pop() == temp[y][x]) {
							temp[in+1][x] = temp[y][x]*2;
							temp[y][x] = 0;
							count++;
						}else {
							stack.add(temp[y][x]);
							if(in != y) {
								temp[in][x] = temp[y][x];
								temp[y][x] = 0;
								count++;
							}
							in--;
						}
					}
				}
			}
			break;
		case 'L':
			for(int y=0; y<N; y++) {
				stack.clear();
				int in = 0;
				for(int x=0; x<N; x++) {
					if(temp[y][x] != 0) {
						if(stack.size() > 0 && stack.pop() == temp[y][x]) {
							temp[y][in-1] = temp[y][x]*2;
							temp[y][x] = 0;
							count++;
						}else {
							stack.add(temp[y][x]);
							if(in != x) {
								temp[y][in] = temp[y][x];
								temp[y][x] = 0;
								count++;
							}
							in++;
						}
					}
				}
			}
			break;
		case 'R':
			for(int y=0; y<N; y++) {
				stack.clear();
				int in = N-1;
				for(int x=N-1; x>=0; x--) {
					if(temp[y][x] != 0) {
						if(stack.size() > 0 && stack.pop() == temp[y][x]) {
							temp[y][in+1] = temp[y][x]*2;
							temp[y][x] = 0;
							count++;
						}else {
							stack.add(temp[y][x]);
							if(in != x) {
								temp[y][in] = temp[y][x];
								temp[y][x] = 0;
								count++;
							}
							in--;
						}
					}
				}
			}
			break;
		}
		
		if(depth == 4) {
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					max = Math.max(max, temp[y][x]);
				}
			}
			return;
		}
		
		if(count != 0) {
			moveBlock(temp, 'U', depth+1);
			moveBlock(temp, 'D', depth+1);
			moveBlock(temp, 'L', depth+1);
			moveBlock(temp, 'R', depth+1);
		}
	}
}
