import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N, M;
		int result = 64;
		int count;
		String s;
		char[][] x;
		char[][] y;
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		x = new char[N][M];
		y = new char[N][M];
		
		for(int i=0; i<N; i++) {
			s = scan.next();
			
			for(int j=0; j<M; j++) {
				x[i][j] = s.charAt(j);
				y[i][j] = s.charAt(j);
			}
		}
		
		char[][] check1 = x.clone();
		char[][] check2 = y.clone();
		
		//맨 위가 W인 경우
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(((i+1)%2+j)%2 == 1) {
					if(check1[i][j] != 'W') {
						check1[i][j] = 'X';
					}
				}else {
					if(check1[i][j] != 'B') {
						check1[i][j] = 'X';
					}
				}
			}
		}
		
		for(int i1=0; i1<N-7; i1++) {
			for(int j1=0; j1<M-7; j1++) {
				count = 0;
				for(int i=i1; i<8+i1; i++) {
					for(int j=j1; j<8+j1; j++) {
						if(check1[i][j] == 'X') {
							count++;
						}
					}
				}
				if(count < result) {
					result = count;
				}
			}
		}
		
		//맨 위가 B인 경우
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(((i+1)%2+j)%2 == 1) {
					if(check2[i][j] != 'B') {
						check2[i][j] = 'X';
					}
				}else {
					if(check2[i][j] != 'W') {
						check2[i][j] = 'X';
					}
				}
			}
		}

		for(int i1=0; i1<N-7; i1++) {
			for(int j1=0; j1<M-7; j1++) {
				count = 0;
				for(int i=i1; i<8+i1; i++) {
					for(int j=j1; j<8+j1; j++) {
						if(check2[i][j] == 'X') {
							count++;
						}
					}
				}
				if(count < result) {
					result = count;
				}
			}
		}
		
		System.out.print(result);
		scan.close();
	}
}