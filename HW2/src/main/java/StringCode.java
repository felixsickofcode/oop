import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        int max = 0;
        int temp = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            char c1 = str.charAt(i - 1);
            if (c == c1) {
                temp++;
            } else temp = 1;
            if (temp > max) max = temp;
        }
        return max;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int k = c - '0';
                if (i + 1 < str.length()) {
                    for (int j = 0; j < k; j++) sb.append(str.charAt(i + 1));
                }
            } else sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i + len <= a.length(); i++) {
            set.add(a.substring(i, i + len));
        }
        for (int j = 0; j + len <= b.length(); j++) {
            if (set.contains(b.substring(j, j + len))) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StringCode obj = new StringCode();
        String s = "ab2c3s";
        String s1 = obj.blowup(s);
        System.out.println(obj.blowup(s));
        System.out.println(obj.maxRun(s1));
    }
}
