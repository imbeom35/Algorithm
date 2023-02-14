import java.io.*;

public class Main {
	
	static class Node{
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node('A', null, null);
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			
			insertNode(root, input[0].charAt(0), input[1].charAt(0), input[2].charAt(0));
		}
		
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		
		br.close();
	}
	
	static void insertNode(Node cursor, char value, char left, char right) {
		if(cursor.value == value) {
			if(left != '.') cursor.left = new Node(left, null, null);
			if(right != '.') cursor.right = new Node(right, null, null);
		}else {
			if(cursor.left != null) insertNode(cursor.left, value, left, right);
			if(cursor.right != null) insertNode(cursor.right, value, left, right);
		}
	}
	
	static void preOrder(Node cursor) {
		System.out.print(cursor.value);
		if(cursor.left != null) preOrder(cursor.left);
		if(cursor.right != null) preOrder(cursor.right);
	}
	
	static void inOrder(Node cursor) {
		if(cursor.left != null) inOrder(cursor.left);
		System.out.print(cursor.value);
		if(cursor.right != null) inOrder(cursor.right);
	}
	
	static void postOrder(Node cursor) {
		if(cursor.left != null) postOrder(cursor.left);
		if(cursor.right != null) postOrder(cursor.right);
		System.out.print(cursor.value);
	}
}
