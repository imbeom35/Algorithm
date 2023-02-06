import java.io.*;

public class Main {
	public static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 만큼 반복
		for(int tc=0; tc<t; tc++) {
			// 문자열 입력
			String s = br.readLine();
			
			// 출력서식
			sb.append(isPalindrome(s)).append(" ").append(count).append("\n");
		}
		
		// 출력
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static int recursion(String s, int l, int r){
		// 반복 횟수 증가
		count++;
		
		// 모든 문자열을 비교하고 이상이 없을 경우 1리턴
        if(l >= r) return 1;
        // 문자열의 양쪽을 비교하여 같지 않을경우 0리턴
        else if(s.charAt(l) != s.charAt(r)) return 0;
        // 문자열의 왼쪽을 1증가 오른쪽을 1감소하여 다시 호출한다.
        else return recursion(s, l+1, r-1);
    }
	
	// recursion을 통해 팰린드롬 여부를 확인하는 메서드
	public static int isPalindrome(String s){
		// recursion의 반복횟수를 초기화
		count = 0;
		
		// recursion 호출 : 문자열, 문자열 첫부분, 문자열 끝부분
		return recursion(s, 0, s.length()-1);
	}
}
