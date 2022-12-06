import java.io.*;
import java.util.*;

class tomato{
	int x;
	int y;
	int z;
	tomato(int z, int x, int y){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); //가로
		int N = Integer.parseInt(st.nextToken()); //세로
		int H = Integer.parseInt(st.nextToken());
		int[][][] box = new int[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		System.out.println(Ripen(box));
		
		br.close();
	}
	
	public static int Ripen(int[][][] arr) {
		Queue<tomato> queue = new LinkedList<tomato>();
		int count = 0;
		int buf1 = 0;
		int buf2 = 0;
		boolean flag = false;
		
		int[] dx = {1, -1, 0, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				for(int k=0; k<arr[0][0].length; k++) {
					if(arr[i][j][k] == 1) {
						queue.add(new tomato(i, j, k));
						buf2++;
					}
					
					if(arr[i][j][k] == 0 && flag == false) {
						flag = true;
					}
				}
			}
		}
		
		if(flag == false) {
			return 0;
		}
		
		while(!queue.isEmpty()) {
			tomato t = queue.poll();
			
			int x = t.x;
			int y = t.y;
			int z = t.z;
			
			//System.out.println(x + " " + y + " " + z);
			
			for(int i=0; i<6; i++) {
				try {
					if(arr[z+dz[i]][x+dx[i]][y+dy[i]] == 0) {
						queue.add(new tomato(z+dz[i], x+dx[i], y+dy[i]));
						arr[z+dz[i]][x+dx[i]][y+dy[i]] = 1;
						buf1++;
					}
				}catch(ArrayIndexOutOfBoundsException e) {}
			}
			
			if(buf2 > 0) {
				buf2--;
			}
			
			if(buf2 == 0 && buf1 > 0) {
				buf2 = buf1;
				buf1 = 0;
				count++;
				//System.out.println("-----");
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				for(int k=0; k<arr[0][0].length; k++) {
					if(arr[i][j][k] == 0) {
						return -1;
					}
				}
			}
		}
		
		return count;
	}
}