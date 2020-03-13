/*

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: "cbbd"
Output: "bb"

 */


public class Longest_Palindrome_Substring {

    public static void main(String args[]){
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println(result);
    }


    static String longestPalindrome(String s) {

        if (s.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i=0; i<s.length(); i++){
            int odd = exandFromCenter(s, i, i);
            int even = exandFromCenter(s, i, i+1);
            int length = Math.max(odd, even);

            if(length > end - start + 1){
                start = i - ((length-1)/2);
                end = i + (length/2);
            }
        }

        return s.substring(start, end+1);

    }

    static int exandFromCenter(String s, int left, int right){

        if (left > right)
            return 0;

        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }

}
