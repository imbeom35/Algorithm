import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static class Word implements Comparable<Word>{
		public String word;
		public double value;
		
		public Word(String word, double value) {
			this.word = word;
			this.value = value;
		}
		
		@Override
		public int compareTo(Word w) {
			if(this.value < w.value) {
				return -1;
			} else if(this.value == w.value) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int c = scan.nextInt();
		
		String[] x = new String[c];
		double[] y = new double[c];
		List<Word> w = new ArrayList<>();
		
		for(int i=0; i<c; i++) {
			x[i] = scan.next();
			y[i] = x[i].length();
			for(int j=0; j<x[i].length(); j++) {
				y[i] += (Character.getNumericValue(x[i].charAt(j))) * Math.pow(0.01, j+1);
			}
			
			boolean overlap = false;
			for(int k=0; k<w.size(); k++) {
				if(x[i].equals(w.get(k).word)) {
					overlap = true;
				}
			}
			if(overlap == false) {
				w.add(new Word(x[i], y[i]));
			}
		}
		
		Collections.sort(w);
		
		for(Word obj : w) {
			System.out.println(obj.word);
		}
		
		scan.close();
	}
}