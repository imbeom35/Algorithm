import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int count = 0;
		
		for(int i=0; i<N; i++) {
			int x = scan.nextInt();
			for(int j=2; j<(int)Math.sqrt(x)+2; j++) {
				if(x != j && x%j == 0) {
					break;
				}
				
				if(x != 1 && j == (int)Math.sqrt(x)+1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		scan.close();
	}
}
