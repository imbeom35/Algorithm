import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<Integer> list;
	public static Queue<Integer> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList<>();
		que = new LinkedList<>();
		
		while(true) {
			String n = br.readLine();
			if(n == null || n.equals("")) {
				break;
			}
			
			list.add(Integer.parseInt(n));
		}
		
		x(0, list.size()-1);
		
		br.close();
	}
	
	public static void x(int start, int end) {
		if(start > end) {
			return;
		}
		
		int mid = start+1;
		for(int i=start+1; i<=end; i++) {
			if(list.get(start) < list.get(i)) {
				mid = i;
				break;
			}
		}
		
		x(start+1, mid-1);
		x(mid, end);
		
		System.out.println(list.get(start));
	}
}
