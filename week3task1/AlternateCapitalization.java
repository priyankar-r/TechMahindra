package week3task1;
public class AlternateCapitalization {
	public static void main(String[] args) {
        // input string
        String input = "jonh smith";

        // convert the string to a character array 
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            // capitalize every alternate character
            if (i % 2 == 0) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }

        // convert the character array to a string
        String result = new String(charArray);

        // print the result
        System.out.println("original string: " + input);
        System.out.println("modified string: " + result);
    }
}
