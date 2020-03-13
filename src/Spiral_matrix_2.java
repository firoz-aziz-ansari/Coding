/*

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */

import java.util.Arrays;

public class Spiral_matrix_2 {

    public static void main(String args[]){
        int n=3;

        int[][] result = generateMatrix(n);

        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];

        int i = 1;
        int row1 = 0;
        int row2 = n-1;
        int col1 = 0;
        int col2 = n-1;

        while(row1<=row2 || col1<=col2){
            for (int right=col1; right<=col2; right++)
                mat[row1][right] = i++;
            for (int down=row1+1; down<=row2; down++)
                mat[down][col2] = i++;
            for (int left=col2-1; left>=col1; left--)
                mat[row2][left] = i++;
            for (int up=row2-1; up>row1; up--)
                mat[up][col1] = i++;

            row1++;row2--;col1++;col2--;
        }

        return mat;

    }

}
