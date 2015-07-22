/**
 * @author Henning Gross
 */
public class StringUtils {

    public static String intArrayToString(int[] intArray) {

        char[] charArray = new char[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            charArray[i] = (char) intArray[i];
        }
        return new String(charArray);
    }

    public static int[] stringToIntArray(String string) {

        char[] charArray = string.toCharArray();
        int[] intArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charArray[i];
        }

        return intArray;
    }
}
