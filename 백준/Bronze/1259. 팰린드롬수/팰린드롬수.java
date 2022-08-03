import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String x;
		String result = "";
		boolean w = true;
		int i, j;
		
		Scanner scan = new Scanner(System.in);
		while(w) {
			x = scan.nextLine();
			
			if(x.equals("0")) {
				w = false;
			}else{
				j = 0;
				String r = "yes";
				for(i=x.length();i>1; i--) {
					j++;
					
					if(x.charAt(j-1) != x.charAt(i-1)) {
						r = "no";
						break;
					}
				}
				
				result += r + "\n";
			}
		}
		

		System.out.print(result);
		
		scan.close();
	}
}