/*

Remove AA, BB, CC from a given String consisting of only A, B, C

Example : ABBACCC

ABBACCC -> AACCC -> CCC -> C

 */

import java.util.Stack;

public class String_With_Rules {
    public static void main(String args[]){
        String question = "ABBACCC";
        String result = "";
        Stack<Character> s = new Stack<Character>();

        for (int i=0; i<question.length(); i++){
            s.push(question.charAt(i));
            if(s.size() >= 2 && s.get(s.size()-1) == s.get(s.size()-2)){
                s.pop();
                s.pop();
            }
        }

        for(char i: s) result += i;

        System.out.println(result);
    }
}
