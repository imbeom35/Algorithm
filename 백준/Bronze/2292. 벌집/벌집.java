import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x, y;
		int n=0;
		boolean w = true;
		x = scan.nextInt();
		y = x-1;
		
		while(w) {
			n++;
			y = y-6*n;
			
			if(y<=0) {
				w = false;
			}
		}
		
		if(x == 1) {
			n = 0;
		}
		
		System.out.print(n+1);
		
		scan.close();
	}
}