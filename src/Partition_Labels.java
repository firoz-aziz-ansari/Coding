/*

A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each
letter appears in at most one part, and return a list of integers representing the size of these parts.

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition_Labels {

    public static void main(String args[]){
        String S = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(S);

        System.out.println(result);
    }

    private static List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<Integer>();

        int i=0;
        while (i<S.length()){
            int partLast = S.lastIndexOf(S.charAt(i));
            int j = i;
            while (j<partLast){
                int partNew = S.lastIndexOf(S.charAt(j));
                if (partLast < partNew){
                    partLast = partNew;
                }
                j++;
            }
            result.add(j - i + 1);
            i=j+1;
        }

        return result;
    }

}
