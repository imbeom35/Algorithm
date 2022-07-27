import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String result = "";
      boolean set = true;

      while(set) {
         String s = scan.nextLine();
         
         char[] array = new char[s.length()+1];
         
         for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '(') {
               push(array, s.charAt(i));
            }else if(s.charAt(i) == ')') {
               if(array[array[0]] == '(') {
                  pop(array);
               }else{
                  push(array, ')');
               }
            }else if(s.charAt(i) == ']') {
               if(array[array[0]] == '[') {
                  pop(array);
               }else{
                  push(array, ']');
               }
            }
         }
         
         if(s.charAt(s.length() - 1) == '.' && s.length() == 1) {
            set = false;
         } else if(array[0] == 0) {
            result += "yes\n";
         } else {
            result += "no\n";
         }
      }
      
      System.out.println(result);
      
      scan.close();
   }
   
   public static char[] push(char[] arr, char x) {
      arr[++arr[0]] = x;
      return arr;
   }
   
   public static char[] pop(char[] arr) {
      arr[arr[0]--] = 0;
      return arr;
   }
}
