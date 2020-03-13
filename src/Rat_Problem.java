import java.util.ArrayList;
import java.util.LinkedList;

public class Rat_Problem {
    static boolean validIndex(int arr[][], int x, int y, boolean visited[][]){
        if (x>=0 && x<arr.length && y>=0 && y<arr[0].length && !visited[x][y] && arr[x][y] == 1){
            return true;
        }
        else {
            return false;
        }
    }

    static boolean checkLastPos(int arr[][], int x, int y, int row, int col){
        if (x == row-1 && y == col-1){
            return true;
        }
        else {
            return false;
        }
    }

    static void solveRatPuzzle(int arr[][], int x, int y, int row, int col, String sol,
                               boolean visited[][], ArrayList<String> solutions){

        // if final position
        if (checkLastPos(arr, x, y, row, col)){
            solutions.add(sol);
            return;
        }

        visited[x][y] = true;

        // move down
        if(validIndex(arr, x+1, y, visited)){
            sol = sol + "D";
            solveRatPuzzle(arr, x+1 , y, row, col, sol, visited, solutions);
            sol = sol.substring(0, sol.length()-1);
        }

        // move right
        if(validIndex(arr, x, y+1, visited)){
            sol = sol + "R";
            solveRatPuzzle(arr, x , y+1, row, col, sol, visited, solutions);
            sol = sol.substring(0, sol.length()-1);
        }

        // move left
        if(validIndex(arr, x, y-1, visited)){
            sol = sol + "L";
            solveRatPuzzle(arr, x , y-1, row, col, sol, visited, solutions);
            sol = sol.substring(0, sol.length()-1);
        }

        // move up
        if(validIndex(arr, x-1, y, visited)){
            sol = sol + "U";
            solveRatPuzzle(arr, x-1 , y, row, col, sol, visited, solutions);
            sol = sol.substring(0, sol.length()-1);
        }

        // if no move possible
        visited[x][y] = false;

        return;
    }

    public static void main(String args[]){
        int arr[][] = {
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 1, 1},
        };

        int row = arr.length;
        int col = arr[0].length;

        boolean visited[][] = new boolean[row][col];
        String path = "";
        ArrayList<String> solutions = new ArrayList<String>();

        solveRatPuzzle(arr, 0, 0, row, col, path, visited, solutions);

        System.out.println("Possible Paths : "+solutions);

        return;

    }
}
