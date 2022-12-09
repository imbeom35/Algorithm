import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int ans = Integer.parseInt(st.nextToken());
			
			boolean[] visit = new boolean[10000];
			visit[input] = true;
			
			Queue<Register> que = new LinkedList<>();
			que.add(new Register(input, ""));
			
			while(!que.isEmpty()) {
				Register r = que.poll();
				
				if(r.num == ans) {
					sb.append(r.command + "\n");
					break;
				}
				
				if(!visit[r.D()]) {
					que.add(new Register(r.D(), r.command+"D"));
					visit[r.D()] = true;
				}
				
				if(!visit[r.S()]) {
					que.add(new Register(r.S(), r.command+"S"));
					visit[r.S()] = true;
				}
				
				if(!visit[r.L()]) {
					que.add(new Register(r.L(), r.command+"L"));
					visit[r.L()] = true;
				}
				
				if(!visit[r.R()]) {
					que.add(new Register(r.R(), r.command+"R"));
					visit[r.R()] = true;
				}
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	static class Register {
		int num;
		String command;
		
		Register(int num, String command){
			this.num = num;
			this.command = command;
		}
		
		int D() {
			return (num*2)%10000;
		}
		
		int S() {
			return (num+9999)%10000;
		}
		
		int L() {
			return (num%1000)*10 + num/1000;
		}
		
		int R() {
			return (num%10)*1000 + num/10;
		}
	}
}
