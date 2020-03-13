/*

For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

Return the largest string X such that X divides str1 and X divides str2.

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Input: str1 = "LEET", str2 = "CODE"
Output: ""

 */


public class GCD_Strings {

    public static void main(String args[]){

        String str1 = "ABCABC";
        String str2 = "ABC";

        String result = gcdOfStrings(str1, str2);

        System.out.println(result);

    }

    public static String gcdOfStrings(String str1, String str2) {
        if(str1.equals(str2))
            return str1;

        if(str1.length() > str2.length()) {
            String sub = str1.substring(str2.length());
            return gcdOfStrings(sub, str2);
        }

        if(str1.length() < str2.length()){
            String sub2 = str2.substring(str1.length());
            return gcdOfStrings(str1, sub2);
        }

        return "";
    }

}
