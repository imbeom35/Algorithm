import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		String[] value = new String[st.countTokens()];
		
		int plus = 0;
		int minus = 0;
		
		for(int i=0; i<value.length; i++) {
			value[i] = st.nextToken();
		}
		
		for(int i=0; i<value.length; i++) {
			st = new StringTokenizer(value[i], "+");
			while(st.hasMoreTokens()) {
				if(i == 0) {
					plus += Integer.parseInt(st.nextToken());
				} else {
					minus += Integer.parseInt(st.nextToken());
				}
			}
		}
		
		System.out.println(plus - minus);
		
		br.close();
	}
}