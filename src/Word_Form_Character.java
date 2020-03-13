/*

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

 */


public class Word_Form_Character {

    public static void main(String args[]){

        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

        int result = countCharacters(words, chars);

        System.out.println(result);

    }

    public static int countCharacters(String[] words, String chars) {
        int result = 0;
        int[] count = new int[26];

        for(char c : chars.toCharArray())
            count[c - 'a']++;

        for(String word : words){
            int[] temp = count.clone();
            int valid_count = 0;

            for(char w : word.toCharArray()){
                if(temp[w-'a']>0){
                    temp[w-'a']--;
                    valid_count++;
                }
                if(valid_count == word.length())
                    result = result + valid_count;
            }
        }
        return result;
    }
}
