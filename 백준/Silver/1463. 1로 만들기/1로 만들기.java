import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Queue<Integer> queue = new LinkedList<>();
		
		int N = scan.nextInt();
		int cycle = 0;
		int x = 0;
		
		queue.add(N);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				x = queue.poll();
				
				if(x == 1) {
					break;
				}
				
				if(x%3 == 0) {
					queue.add(x/3);
				}
                if(x%2 == 0) {
					queue.add(x/2);
				}
                
				queue.add(x-1);
			}
			
			if(x == 1) {
				break;
			}
			
			cycle++;
		}
		
		System.out.println(cycle);
		
		scan.close();
	}
}