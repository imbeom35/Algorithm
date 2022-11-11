import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] M = new int[N][N];
		for(int i=0; i<N; i++) {
			String string = br.readLine();
			for(int j=0; j<N; j++) {
				M[i][j] = Character.getNumericValue(string.charAt(j));
			}
		}
		
		System.out.println(QuadTree(M, 0, 0, N));
		
		br.close();
	}
	
	public static String QuadTree(int[][] arr, int sx, int sy, int size) {
		StringBuilder sb = new StringBuilder();
		
		
		int value = 0;
		boolean flag1 = true;
		boolean flag2 = true;
		
		for(int i=sx; i<sx+size; i++) {
			for(int j=sy; j<sy+size; j++) {
				if(flag1 == true) {
					value = arr[i][j];
					flag1 = false;
				}else {
					if(value != arr[i][j]) {
						sb.append("(");
						sb.append(QuadTree(arr, sx, sy, size/2));
						sb.append(QuadTree(arr, sx, sy+size/2, size/2));
						sb.append(QuadTree(arr, sx+size/2, sy, size/2));
						sb.append(QuadTree(arr, sx+size/2, sy+size/2, size/2));
						sb.append(")");
						
						flag2 = false;
						break;
					}
				}
			}
			if(flag2 == false) {
				break;
			}
		}
		
		if(flag2 == true) {
			sb.append(value);
		}
		
		return sb.toString();
	}
}
