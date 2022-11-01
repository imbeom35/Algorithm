import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> heap = new ArrayList<Integer>();
		heap.add(0);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				sb.append(delete(heap)).append('\n');
			} else {
				insert(heap, x);
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	public static int delete(ArrayList<Integer> heap) {
		if(heap.size()-1 < 1) {
			return 0;
		}
		
		int d_item = heap.get(1);
		
		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int pos = 1;
		
		while((pos*2)<heap.size()) {
			int min = heap.get(pos*2);
			int minPos = pos*2;
			
			if(((pos*2+1)<heap.size()) && min>heap.get(pos*2+1) ) {
				min = heap.get(pos*2+1);
				minPos = pos*2+1;
			}
			
			if(min > heap.get(pos)) {
				break;
			}
			
			int tmp = heap.get(pos);
			heap.set(pos, min);
			heap.set(minPos, tmp);
			pos = minPos;
		}
		
		return d_item;
	}
	
	public static void insert(ArrayList<Integer> heap, int x) {
		heap.add(x);
		int p = heap.size() - 1;
		while(p>1 && heap.get(p/2)>heap.get(p)) {
			int tmp = heap.get(p/2);
			heap.set(p/2, x);
			heap.set(p, tmp);
			
			p /= 2;
		}
	}
}
