/*

There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

    1. If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    2. Otherwise, it becomes vacant.

(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied,
else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)


Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation:
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]


Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]

 */


import java.util.Arrays;
import java.util.HashMap;

public class Prision_Ndays {

    public static void main(String args[]){
        int N = 1000000;
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};

        HashMap<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            int[] temp = new int[cells.length];
            seen.put(Arrays.toString(cells), N);

            for (int i = 1; i < cells.length-1; ++i){
                if (cells[i - 1] == cells[i + 1]){
                    temp[i] = 1;
                }
            }

            cells = temp;
            N--;

            // Cycle repeats
            if (seen.containsKey(Arrays.toString(cells))) {
                N = N % (N - seen.get(Arrays.toString(cells)));
            }

        }

        for (int j =0; j<cells.length; j++){
            System.out.print(cells[j]+" ");
        }


    }

}
