import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		boolean x = true;
		int a, b, c;
		
		Scanner scan = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		
		while(x) {
			a = scan.nextInt();
			b = scan.nextInt();
			c = scan.nextInt();
			
			if(a==0 && b==0 && c==0) {
				x = false;
			}else {
				if(a*a==b*b+c*c || a*a+b*b==c*c || a*a+c*c==b*b) {
					list.add("right");
				}else {
					list.add("wrong");
				}
			}
		}
		
		for(String data: list) {
			System.out.println(data);
		}
		
		scan.close();
	}
}