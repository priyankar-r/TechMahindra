package week1task;

import java.util.*;

public class Anagram_Finder {
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()){
        	return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();
        
        for (int i = 0; i < windowSize; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        for (int i = windowSize; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++; 
            sCount[s.charAt(i - windowSize) - 'a']--; 

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        sc.close();

        List<Integer> indices = findAnagrams(s, p);
        System.out.println("starting index of anagram is " + indices);
    }
}
