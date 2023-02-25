import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static char[] input;
	static HashSet<Character> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// HashSet에 모음 저장
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		
		combination(0, 0, 0, new String());
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void combination(int index, int con, int vow, String s) {
		// L개를 모두 뽑았을 경우 출력
		if(con + vow == L) {
			if(con >= 2 && vow >= 1) {
				sb.append(s).append("\n");
			}
			
			return;
		}
		
		// index를 모두 접근했을 경우 종료
		if(index == C) {
			return;
		}
		
		// index번째를 뽑았을 경우 재귀호출
		combination(index+1, con + (set.contains(input[index])?0:1), vow + (set.contains(input[index])?1:0), s+input[index]);
		
		// index번째를 뽑지 않았을 경우 재귀호출
		combination(index+1, con, vow, s);
	}
}
