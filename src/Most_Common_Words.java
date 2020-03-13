/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words. It
is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation. Words in the paragraph are not case
sensitive.  The answer is in lowercase.

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
 */

import java.util.*;

public class Most_Common_Words {
    public static void main(String args[]){
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        String[] words = paragraph.toLowerCase().split("([.,!?:;'\"-]|\\s)+");

        HashMap<String, Integer> word_count = new HashMap<String, Integer>();

        for (int i=0; i<words.length; i++){
            if (word_count.containsKey(words[i])){
                word_count.put(words[i], word_count.get(words[i])+1);
            }
            else {
                word_count.put(words[i], 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> j = word_count.entrySet().iterator();
        String result = "";
        int count = 0;


        while (j.hasNext()){
            Map.Entry<String, Integer> key_value = j.next();
            if (!Arrays.asList(banned).contains(key_value.getKey()) && key_value.getValue() > count){
                count = key_value.getValue();
                result = key_value.getKey();
            }
        }

        System.out.print(result);
    }
}
