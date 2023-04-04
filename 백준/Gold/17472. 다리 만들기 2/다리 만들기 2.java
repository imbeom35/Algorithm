import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int v, w, cost;
		
		Node(int v, int w, int cost) {
			this.v = v;
			this.w = w;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int[][] field;
	static int N, M;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		field = new int[N][M];
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; x++) {
				field[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 숫자 매기기 : 섬 개수 출력
		int number = island();
		
		// 인접행렬 구하기
		int[][] matrix = getMatrix(number);
		
		// 인접행렬을 그래프로 변환
		ArrayList<Node> graph = new ArrayList<>();
		for(int y=0; y<number+1; y++) {
			for(int x=0; x<number+1; x++) {
				if(matrix[y][x] > 0 && matrix[y][x] != 100) {
					graph.add(new Node(y, x, matrix[y][x]));
				}
			}
		}

		// 그래프 정렬
		Collections.sort(graph);
		
		// 부모노드 초기화
		int[] parent = new int[number + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		// 크루스칼
		int result = kruskal(graph, parent);
		
		// 자기 자신을 부모로 갖는 개수 구하기
		int count = 0;
		for (int i = 0; i < parent.length; i++) {
			if(parent[i] == i) {
				count++;
			}
		}
		
		// 예외처리
		if(count > 2 || (result == 0 && number > 1)) {
			result = -1;
		}
		
		System.out.println(result);
		
		br.close();
	}
	
	// 섬 번호 매기기
	static int island() {
		int number = 0;
		boolean[][] visited = new boolean[N][M];
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(!visited[y][x] && field[y][x] == 1) {
					visited[y][x] = true;
					field[y][x] = ++number;
					
					Queue<Point> queue = new ArrayDeque<>();
					queue.add(new Point(x, y));
					
					while(!queue.isEmpty()) {
						Point curr = queue.poll();
						
						for(int i=0; i<4; i++) {
							int nx = curr.x + dx[i];
							int ny = curr.y + dy[i];
							
							if(0 <= nx && nx < M && 0 <= ny && ny < N && !visited[ny][nx] && field[ny][nx] == 1) {
								visited[ny][nx] = true;
								field[ny][nx] = number;
								queue.add(new Point(nx, ny));
							}
						}
					}
				}
			}
		}
		
		return number;
	}
	
	// 인접행렬 만들기
	static int[][] getMatrix(int number) {
		int[][] graph = new int[number+1][number+1];
		for(int i=0; i<number+1; i++) {
			Arrays.fill(graph[i], 100);
		}
		
		Point p1 = null, p2 = null;
		boolean state = false;
		
		// y축에서 가능한 다리 찾기
		for(int y=0; y<N; y++) {
			state = false;
			for(int x=1; x<M; x++) {
				// p1 설정
				if(!state && field[y][x] == 0 && field[y][x-1] > 0) {
					state = true;
					p1 = new Point(x-1, y);
				}
				
				// p2 설정
				else if(state && field[y][x] > 0) {
					state = false;
					p2 = new Point(x, y);
					
					// p1과 p2의 최소값 계산
					if(p2.x - p1.x - 1 > 1) {
						graph[field[p1.y][p1.x]][field[p2.y][p2.x]] = Math.min(graph[field[p1.y][p1.x]][field[p2.y][p2.x]], p2.x - p1.x - 1);
					}
				}
			}
		}
		
		// x축에서 가능한 다리 찾기
		for(int x=0; x<M; x++) {
			state = false;
			for(int y=1; y<N; y++) {
				// p1 설정
				if(!state && field[y][x] == 0 && field[y-1][x] > 0) {
					state = true;
					p1 = new Point(x, y-1);
				}
				
				// p2 설정
				else if(state && field[y][x] > 0) {
					state = false;
					p2 = new Point(x, y);
					
					// p1과 p2의 최소값 계산
					if(p2.y - p1.y - 1  > 1) {
						graph[field[p1.y][p1.x]][field[p2.y][p2.x]] = Math.min(graph[field[p1.y][p1.x]][field[p2.y][p2.x]], p2.y - p1.y - 1);
					}
				}
			}
		}
		
		return graph;
	}
	
	// 유니온 
	public static void union(int[] parent, int x, int y) {
		x = find(parent, x);
		y = find(parent, y);
		
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	
    // 파인드
	public static int find(int[] parent, int x) {
		if(parent[x] == x) return x;
		else return find(parent, parent[x]);
	}
	
	// 크루스칼
	public static int kruskal(ArrayList<Node> graph, int[] parent) {
		int cost = 0;
		for(Node node : graph) {
			if (find(parent, node.v) != find(parent, node.w)) {
				cost += node.cost;
				union(parent, node.v, node.w);
			}
		}
        
		return cost;
	}
}
