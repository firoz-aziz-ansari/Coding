/*

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either
(a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1

 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Domino_Pairs {

    public static void main(String args[]){

        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        int result = numEquivDominoPairs(dominoes);

        System.out.println(result);
    }


    public static int numEquivDominoPairs(int[][] dominoes) {

        Map<String, ArrayList<Integer>> pairs = new HashMap<String, ArrayList<Integer>>();
        int result = 0;

        int i=0;
        for(int[] domino : dominoes){
            if(pairs.containsKey(""+domino[0]+domino[1]))
                pairs.get(""+domino[0]+domino[1]).add(i);
            else if(pairs.containsKey(""+domino[1]+domino[0]))
                pairs.get(""+domino[1]+domino[0]).add(i);
            else {
                pairs.put("" + domino[0] + domino[1], new ArrayList<Integer>());
                pairs.get(""+domino[0]+domino[1]).add(i);
            }
            i++;
        }

        Iterator<Map.Entry<String, ArrayList<Integer>>> it = pairs.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String, ArrayList<Integer>> pair = it.next();
            ArrayList<Integer> a = pair.getValue();
            int size = a.size();

            result = result + size * (size-1) / 2;

        }

        return result;
    }

}
