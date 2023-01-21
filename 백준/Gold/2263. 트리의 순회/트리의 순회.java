import java.io.*;
import java.util.*;

public class Main {
	public static StringBuffer sb = new StringBuffer();
	public static int[] inOrder;
	public static int[] postOrder;
	public static int[] inOrderIndex;
	public static int n = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		inOrder = new int[n];
		postOrder = new int[n];
		inOrderIndex = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<n; i++) {
			inOrderIndex[inOrder[i]] = i;
		}
		
		getPreOrder(0, n-1, 0, n-1);
		
		System.out.println(sb);
		
		br.close();
	}
	
	public static void getPreOrder(int in_start, int in_end, int post_start, int post_end) {
		if(in_start > in_end || post_start > post_end) {
			return;
		}
		
		int rootNode = postOrder[post_end];
		sb.append(rootNode + " ");
		
		int rootIndex = inOrderIndex[rootNode];
		int leftNodeLength = rootIndex - in_start;
		
		getPreOrder(in_start, rootIndex-1, post_start, post_start+leftNodeLength-1);
		getPreOrder(rootIndex+1, in_end, post_start+leftNodeLength, post_end-1);
	}
}
