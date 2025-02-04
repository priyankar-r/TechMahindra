package week1task;

public class String_Processor {
	public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
	
	public static int countOccurrences(String text, String sub) {
        int count = 0;
        int index = text.indexOf(sub);

        while (index != -1) {
            count++;
            index = text.indexOf(sub, index + sub.length());
        }
        return count;
    }
	public static String splitAndCapitalize(String str) {
        String[] words = str.split("\\s+");
        StringBuilder capitalizedStr = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalizedStr.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }
        return capitalizedStr.toString().trim();
    }
	 public static void main(String[] args) {
	        String text1 = "red fox jumped over a lazy dog";
	        System.out.println("reversed string -> " + reverseString(text1));
	        String text2 = "red redder fox jumped over a lazy red painteddog";
	        String sub = "red";
	        System.out.println("occurrences of -> " + sub + " " + countOccurrences(text2, sub));
	        String text3 = "red fox jumped over a lazy dog";
	        System.out.println("capitalized string -> " + splitAndCapitalize(text3));
	    }
}
