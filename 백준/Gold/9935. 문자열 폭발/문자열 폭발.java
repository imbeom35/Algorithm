import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length; i++) {
			stack.add(str[i]);
			
			if(stack.size() >= bomb.length) {
				boolean isSame = true;
				for(int j=0; j<bomb.length; j++) {
					char c1 = stack.get(stack.size() - bomb.length + j);
					char c2 = bomb[j];
					
					if(c1 != c2) {
						isSame = false;
						break;
					}
				}
				if(isSame) {
					for(int cnt=0; cnt<bomb.length; cnt++) {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.size() == 0) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for(char c : stack) {
				sb.append(c);
			}
			System.out.println(sb);
		}
		
		br.close();
	}
}
