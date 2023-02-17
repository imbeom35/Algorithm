import java.io.*;

public class Main {
	static boolean[] output;
	static int[] input = new int[9];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		output = new boolean[9];
		boolean[] visited = new boolean[9];
		
		combination(visited, 0, 7);
		
		for(int i=0; i<9; i++) {
			if(output[i]) {
				System.out.println(input[i]);
			}
		}
		
		br.close();
	}
	
	static void combination(boolean[] visited, int depth, int r) {
		if(r == 0) {
			int sumValue = 0;
			// 조합한 아홉 난쟁이의 합 구하기
			for(int i=0; i<9; i++) {
				if(visited[i]) {
					sumValue += input[i];
				}
			}
			
			// 일곱난쟁이의 합이 100이 될 수 있다면 현재 조합을 output에 저장하기
			if(sumValue == 100) {
				for(int i=0; i<output.length; i++) {
					output[i] = visited[i];
				}
			}
			
			return;
		}
		
		if(depth == visited.length) {
			return;
		}
		
		visited[depth] = true;
		combination(visited, depth+1, r-1);
		visited[depth] = false;
		combination(visited, depth+1, r);
	}
}
