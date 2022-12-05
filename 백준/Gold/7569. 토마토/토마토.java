import java.io.*;
import java.util.*;

public class Main {
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
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
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					
				}
			}
		}
		
		System.out.println(Ripen(box));
		
		br.close();
	}
	
	public static int Ripen(int[][][] arr) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = 0;
		int buf1 = 0;
		int buf2 = 0;
		boolean flag = false;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				for(int k=0; k<arr[0][0].length; k++) {
					if(arr[i][j][k] == 1) {
						queue.add(i);
						queue.add(j);
						queue.add(k);
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
			int x = queue.poll();
			int y = queue.poll();
			int z = queue.poll();
			
			//System.out.println(buf2 + " " + x + " " + y + " " + z);
			
			try {
				if(arr[x+1][y][z] == 0) {
					queue.add(x+1);
					queue.add(y);
					queue.add(z);
					arr[x+1][y][z] = 1;
					buf1++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			try {
				if(arr[x-1][y][z] == 0) {
					queue.add(x-1);
					queue.add(y);
					queue.add(z);
					arr[x-1][y][z] = 1;
					buf1++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			try {
				if(arr[x][y+1][z] == 0) {
					queue.add(x);
					queue.add(y+1);
					queue.add(z);
					arr[x][y+1][z] = 1;
					buf1++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			try {
				if(arr[x][y-1][z] == 0) {
					queue.add(x);
					queue.add(y-1);
					queue.add(z);
					arr[x][y-1][z] = 1;
					buf1++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			try {
				if(arr[x][y][z+1] == 0) {
					queue.add(x);
					queue.add(y);
					queue.add(z+1);
					arr[x][y][z+1] = 1;
					buf1++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			try {
				if(arr[x][y][z-1] == 0) {
					queue.add(x);
					queue.add(y);
					queue.add(z-1);
					arr[x][y][z-1] = 1;
					buf1++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			if(buf2 > 0) {
				buf2--;
			}
			
			if(buf2 == 0 && buf1 > 0) {
				buf2 = buf1;
				buf1 = 0;
				count++;
				//System.out.println("-------");
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
