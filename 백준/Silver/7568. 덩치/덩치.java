import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[][] body = new int[2][N];
		int ranking = 1;
		for(int i=0; i<N; i++) {
			body[0][i] = scan.nextInt();
			body[1][i] = scan.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			ranking = 1;
			for(int j=0; j<N; j++) {
				if(body[0][i] <= body[0][j] && body[1][i] <= body[1][j]) {
					if(body[0][i] != body[0][j] && body[1][i] != body[1][j]) {
						ranking++;
					}
				}
			}
			
			System.out.println(ranking);
		}
		
		scan.close();
	}
}
