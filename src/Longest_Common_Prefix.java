/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Input: ["flower","flow","flight"]
Output: "fl"

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */


public class Longest_Common_Prefix {

    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};

        String result = longestCommonPrefix(strs);

        System.out.println(result);

    }

    public static String longestCommonPrefix(String[] strs) {

        String result = "";

        if(strs.length == 0)
            return result;

        int min_length = strs[0].length();
        String min_element = strs[0];

        for(String str : strs){
            if (str.length() < min_length){
                min_length = str.length();
                min_element = str;
            }
        }

        result = min_element;

        for(String str : strs){
            while(!result.equals(str.substring(0, min_length))){
                if(min_length==0)
                    break;
                else
                    min_length--;
                result = result.substring(0, min_length);
            }
        }

        return result;
    }
}
