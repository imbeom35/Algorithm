import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int[] queue = new int[N+1];
      queue[0] = N;
      for(int i=1; i<N+1; i++) {
         queue[i] = i;
      }
      
      StringBuilder sb = new StringBuilder();
      sb.append("<");
      
      for(int i=0; i<N; i++) {
         for(int j=0; j<M-1; j++) {
            push(queue, pop(queue));
         }
         
         if(i == N-1) {
            sb.append(pop(queue)).append(">");
         } else {
            sb.append(pop(queue)).append(", ");
         }
      }
      System.out.println(sb);
      
      br.close();
   }
   
   public static void push(int[] arr, int x) {
      arr[0]++;
      arr[arr[0]] = x;
   }
   
   public static int pop(int[] arr) {
      int val = arr[1];
      for(int i=1; i<arr[0]; i++) {
         arr[i] = arr[i+1];
      }
      
      arr[arr[0]] = 0;
      arr[0]--;
      
      return val;
   }
}