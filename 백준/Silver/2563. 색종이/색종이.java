import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		
		// 가로, 세로 크기가 각각 100인 도화지를 2차원 배열로 구현
		boolean[][] paper = new boolean[101][101];
		
		// n개의 색종이를 입력받는다.
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// 색종이를 붙인 영역을 true로 표시한다.
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					paper[j][k] = true;
				}
			}
		}
		
		// 색종이를 붙인 영역의 총 개수를 구한다.
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(paper[i][j] == true) {
					sum++;
				}
			}
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}
