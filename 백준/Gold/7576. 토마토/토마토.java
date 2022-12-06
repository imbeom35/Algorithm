import java.io.*;
import java.util.*;

public class Main {
public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] box = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(Ripen(box));
		
		br.close();
	}
	
	public static int Ripen(int[][] arr) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = 0;
		int buf1 = 0;
		int buf2 = 0;
		boolean flag = false;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == 1) {
					queue.add(i);
					queue.add(j);
					buf2++;
				}
				
				if(arr[i][j] == 0 && flag == false) {
					flag = true;
				}
			}
		}
		
		if(flag == false) {
			return 0;
		}
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			
			//System.out.println(buf2 + " " + x + " " + y + " " + z);
			
			try {
				if(arr[x+1][y] == 0) {
					queue.add(x+1);
					queue.add(y);
					arr[x+1][y] = 1;
					buf1++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			try {
				if(arr[x-1][y] == 0) {
					queue.add(x-1);
					queue.add(y);
					arr[x-1][y] = 1;
					buf1++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			try {
				if(arr[x][y+1] == 0) {
					queue.add(x);
					queue.add(y+1);
					arr[x][y+1] = 1;
					buf1++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			try {
				if(arr[x][y-1] == 0) {
					queue.add(x);
					queue.add(y-1);
					arr[x][y-1] = 1;
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
				if(arr[i][j] == 0) {
					return -1;
				}
			}
		}
		
		return count;
	}
}
