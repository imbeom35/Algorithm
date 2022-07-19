import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static class Document {
		public int order;
		public int value;
		
		public Document(int order, int value) {
			this.order = order;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		int[] result = new int[count];
				
		for(int i=0; i<count; i++) {
			int N = scan.nextInt();
			int M = scan.nextInt();
			
			List<Document> d = new ArrayList<>();
			for(int j=0; j<N; j++) {
				int x = scan.nextInt();
				d.add(new Document(j, x));
			}
			
			boolean find = false;
			int y = 0;
			int z = 0;
			while(!find) {
				for(int j=y; j<d.size(); j++) {
					if(d.get(y).value < d.get(j).value) {
						d.add(d.get(y));
						z++;
						break;
					} else if(j+1 == d.size()) {
						if(d.get(y).order == M) {
							result[i] = y-z+1;
							find = true;
							break;
						}
					}
				}
				
				y++;
			}
		}
		
		for(int i=0; i<count; i++) {
			System.out.println(result[i]);
		}
		
		scan.close();
	}
}
