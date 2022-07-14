import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int M = scan.nextInt();
		int N = scan.nextInt();
		
		for(int i=M; i<N+1; i++) {
			for(int j=2; j<(int)Math.sqrt(i)+2; j++) {
				if(i != j && i%j == 0) {
					break;
				}
				
				if(i != 1 && j == (int)Math.sqrt(i)+1) {
					System.out.println(i);
				}
			}
		}
		
		scan.close();
	}
}
