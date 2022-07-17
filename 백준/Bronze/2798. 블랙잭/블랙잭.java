import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] card = new int[N];
		int result = 0;
		
		for(int i=0; i<N; i++) {
			card[i] = scan.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					int x = card[i] + card[j] + card[k];
					if(x <= M) {
						if(x > result) {
							result = x;
						}
					}
				}
			}
		}
		
		System.out.println(result);
		
		scan.close();
	}
}
