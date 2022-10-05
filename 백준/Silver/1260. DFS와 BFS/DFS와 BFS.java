import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[] node = new int[1];
		node[0] = Integer.parseInt(st.nextToken());
		int[][] arr1 = new int[n+1][n+1];
		int[][] arr2 = new int[n+1][n+1];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			arr1[a1][a2] = 1;
			arr1[a2][a1] = 1;
			arr2[a1][a2] = 1;
			arr2[a2][a1] = 1;
		}
		
		System.out.println(DFS(arr1, node[0], 0));
		System.out.println(BFS(arr2, node, 0));

		br.close();
	}
	
	public static String DFS(int[][] arr, int node, int root) {
		String result = "";
		
		if(root == 0) {
			for(int i=0; i<arr.length; i++) {
				arr[i][node] = 0;
			}
			result += Integer.toString(node) + " ";
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[node][i] == 1) {
				for(int j=0; j<arr.length; j++) {
					arr[j][i] = 0;
				}
				
				result += Integer.toString(i) + " " + DFS(arr, i, node);
			}
		}
		
		return result;
	}
	
	public static String BFS(int[][] arr, int[] nodes, int root) {
		String result = "";
		int[] queue = new int[arr.length];
		int n = 0;
		
		if(root == 0) {
			for(int i=0; i<arr.length; i++) {
				arr[i][nodes[0]] = 0;
			}
			result += Integer.toString(nodes[0]) + " ";
		}
		
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i] != 0) {
				for(int j=0; j<arr.length; j++) {
					if(arr[nodes[i]][j] == 1) {
						for(int k=0; k<arr.length; k++) {
							arr[k][j] = 0;
						}
						
						result += Integer.toString(j) + " ";
						queue[n] = j;
						n++;
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			result += BFS(arr, queue, 1);
		}
		
		return result;
	}
}
