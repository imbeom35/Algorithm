import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String result = "";
		int N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			String s = scan.next();
			
			char[] array = new char[s.length()+1];
			
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) == '(') {
					push(array, s.charAt(j));
				}else if(s.charAt(j) == ')') {
					if(array[array[0]] == '(') {
						pop(array);
					}else{
						push(array, ')');
					}
				}
			}
 
			if(array[0] == 0) {
				result += "YES\n";
			} else {
				result += "NO\n";
			}
		}
		
		System.out.println(result);
		
		scan.close();
	}
	
	public static char[] push(char[] arr, char x) {
		arr[++arr[0]] = x;
		return arr;
	}
	   
	public static char[] pop(char[] arr) {
		arr[arr[0]--] = 0;
		return arr;
	}
}