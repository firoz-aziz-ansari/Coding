/*

In a given grid, each cell can have one of three values:

1. the value 0 representing an empty cell;
2. the value 1 representing a fresh orange;
3. the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible,
return -1 instead.

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens
              4-directionally.

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

 */

import java.util.HashSet;
import java.util.Set;

public class Rotten_Orange {

    public static void main(String args[]){
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int result = orangesRotting(grid);

        System.out.println(result);

    }

    public static int orangesRotting(int[][] grid) {
        Set <String> fresh = new HashSet<>();
        Set <String> rotten = new HashSet<>();

        int R = grid.length;
        int C = grid[0].length;

        for (int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if (grid[i][j] == 1)
                    fresh.add(""+i+j);
                else if (grid[i][j] == 2)
                    rotten.add(""+i+j);
            }
        }

        int minutes = 0;
        int[][] direct = {
                {1,0},  //down
                {0,1},  //right
                {-1,0}, //up
                {0,-1}  //left
        };

        while(fresh.size()>0){
            Set <String> newRotten = new HashSet<>();
            for(String coord : rotten){
                int i = coord.charAt(0) - '0';
                int j = coord.charAt(1) - '0';

                for(int[] d : direct){
                    int newi = i + d[0];
                    int newj = j+ d[1];
                    String newcoord = ""+newi+newj;
                    if(fresh.contains(newcoord)){
                        fresh.remove(newcoord);
                        newRotten.add(newcoord);
                    }
                }
            }

            if (newRotten.size() == 0){
                return -1;
            }
            rotten = newRotten;
            minutes++;

        }

        return minutes;

    }
}
