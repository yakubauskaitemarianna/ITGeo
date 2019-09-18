package findSubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 

public class FindSubsequence {
	public static Set<String> longestCommonSubstrings(String s, String t) {
	    int[][] table = new int[s.length()][t.length()];
	    int longest = 0;
	    Set<String> result = new HashSet<>();

	    for (int i = 0; i < s.length(); i++) {
	        for (int j = 0; j < t.length(); j++) {
	            if (s.charAt(i) != t.charAt(j)) {
	                continue;
	            }

	            table[i][j] = (i == 0 || j == 0) ? 1
	                                             : 1 + table[i - 1][j - 1];
	            if (table[i][j] > longest) {
	                longest = table[i][j];
	                result.clear();
	            }
	            if (table[i][j] == longest) {
	                result.add(s.substring(i - longest + 1, i + 1));
	            }
	        }
	    }
	    
	    return result;
	}
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк:");
        int n = scanner.nextInt();
        Comparator<String> comparator = new Comparator<String>() {
            
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            strings.add(scanner.next());
        }
        
        Collections.sort(strings,comparator);
        
        String pattern = (String)strings.get(0);
        
        for (String string : strings) {
        	pattern = longestCommonSubstrings(pattern, string).iterator().next();
        }
              
        System.out.print(pattern);
	}
}
