/*

You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this
map:

1. 0 represents the obstacle can't be reached.
2. 1 represents the ground can be walked through.
3. The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the
   tree's height.

In one step you can walk in any of the four directions top, bottom, left and right also when standing in a point which
is a tree you can decide whether or not to cut off the tree.

You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with
lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees.
If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Input:
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6

Input:
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1

Input:
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.

 */



import java.util.*;

public class Cut_Tree_Golf_BFS {
    public static void main(String[] args){
        List<List<Integer>> forest = new ArrayList<List<Integer>>();

        List<Integer> a = new ArrayList<>();
        a.add(2);a.add(3);a.add(4);

        List<Integer> b = new ArrayList<>();
        b.add(0);b.add(0);b.add(10);

        List<Integer> c = new ArrayList<>();
        c.add(8);c.add(7);c.add(6);

        forest.add(a);forest.add(b);forest.add(c);

        int result = cutOffTree(forest);

        System.out.println(result);
    }



    public static int cutOffTree(List<List<Integer>> forest) {
        TreeMap<Integer, int[]> trees = new TreeMap();
        int nr = forest.size();
        int nc = forest.get(0).size();
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++ ) {
                int v = forest.get(r).get(c);
                if (v > 1) trees.put(v, new int[]{r, c});
            }
        }

        int result = 0, x1 = 0, y1 = 0;
        for (Map.Entry<Integer, int[]> tree: trees.entrySet()) {
            //int height = tree.getKey();
            int[] pos = tree.getValue();
            int cost = dist_bfs(forest, x1, y1, pos[0], pos[1], nr, nc);
            if (cost < 0) {
                return -1;
            }
            result = result + cost;
            x1 = pos[0]; y1 = pos[1];
        }
        return result;
    }


    public static int dist_bfs(List<List<Integer>> forest, int x1, int y1, int x2, int y2, int nr, int nc) {
        LinkedList<int[]> queue = new LinkedList();
        queue.add(new int[]{x1, y1, 0});
        boolean[][] visited = new boolean[nr][nc];
        visited[x1][y1] = true;
        int[][] direct = {
                {1,0},  //down
                {0,1},  //right
                {-1,0}, //up
                {0,-1}  //left
        };
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            if (t[0] == x2 && t[1] == y2)
                return t[2];
            for (int i = 0; i < 4; i++) {
                int r = t[0] + direct[i][0];
                int c = t[1] + direct[i][1];
                if (r>=0 && r<nr &&  c>=0 && c<nc &&
                        !visited[r][c] && forest.get(r).get(c) > 0) {
                    visited[r][c] = true;
                    queue.add(new int[]{r, c, t[2]+1});
                }
            }
        }
        return -1;
    }
//    static void cutOffTree(List<List<Integer>> forest) {
//
//        int[][] forest_int = forestListToInt(forest);
//        int row = forest_int.length;
//        int col = forest_int[0].length;
//        boolean blocked[][] = new boolean[row][col];
//        for (int i=0; i<row; i++)
//            for (int j=0; j<col; j++)
//                if (forest_int[i][j] == 0)
//                    blocked[i][j] = true;
//
//        int sol = 0;
//        ArrayList<Integer> solutions = new ArrayList<Integer>();
//        cutOffTreeUtil(forest_int, row, col, 0, 0, blocked, sol, solutions);
//        if (solutions.size()>0){
//            System.out.println(Collections.min(solutions));
//        }
//        else {
//            System.out.println(-1);
//        }
//
//    }
//
//
//
//    private static void cutOffTreeUtil(int[][] forest_int, int row, int col, int x, int y, boolean[][] blocked,
//                                      int sol, ArrayList<Integer> solutions) {
//
//
//        int temp = forest_int[x][y];
//        forest_int[x][y] = 1;
//
//        //if all trees cut
//        if(allTreeCut(forest_int, row, col)){
//            solutions.add(sol);
//            return;
//        }
//
//        blocked[x][y] = true;
//
//        //move down
//        if(validMove(forest_int, row, col, x, y, x+1, y, blocked)){
//            sol = sol + 1;
//            cutOffTreeUtil(forest_int, row, col, x+1, y, blocked, sol, solutions);
//            sol = sol - 1;
//        }
//
//        //move right
//        if(validMove(forest_int, row, col, x, y, x, y+1, blocked)){
//            sol = sol + 1;
//            cutOffTreeUtil(forest_int, row, col, x, y+1, blocked, sol, solutions);
//            sol = sol - 1;
//        }
//
//        //move left
//        if(validMove(forest_int, row, col, x, y, x, y-1, blocked)){
//            sol = sol + 1;
//            cutOffTreeUtil(forest_int, row, col, x, y-1, blocked, sol, solutions);
//            sol = sol - 1;
//        }
//
//        //move up
//        if(validMove(forest_int, row, col, x, y, x-1, y, blocked)){
//            sol = sol + 1;
//            cutOffTreeUtil(forest_int, row, col, x-1, y, blocked, sol, solutions);
//            sol = sol - 1;
//        }
//
//        //no move possible
//        forest_int[x][y] = temp;
//        blocked[x][y] = false;
//
//        return;
//    }
//
//    private static boolean validMove(int[][] forest_int, int row, int col, int x, int y,
//                                     int new_x, int new_y, boolean[][] blocked) {
//        if (new_x>=0 && new_x<row && new_y>=0 && new_y<col && !blocked[new_x][new_y] &&
//                forest_int[x][y] <= forest_int[new_x][new_y]){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    private static boolean allTreeCut(int[][] forest_int, int row, int col) {
//        boolean noTree = true;
//
//        for (int i=0; i<row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (forest_int[i][j] != 1 && forest_int[i][j] != 0) {
//                    noTree = false;
//                }
//            }
//        }
//        return noTree;
//    }
//
//    private static int[][] forestListToInt(List<List<Integer>> forest) {
//        int[][] array = new int[forest.size()][];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = new int[forest.get(i).size()];
//        }
//        for(int i=0; i<forest.size(); i++){
//            for (int j = 0; j < forest.get(i).size(); j++) {
//                array[i][j] = forest.get(i).get(j);
//            }
//        }
//
//        return array;
//    }
}
