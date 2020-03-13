/*

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */

import java.util.ArrayList;
import java.util.List;

public class Spiral_matrix_1 {


    public static void main(String args[]){

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12}
        };

        List<Integer> result = spiralOrder(matrix);

        System.out.println(result);

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        if(matrix.length == 0){
            return result;
        }

        int M = matrix.length;
        int N = matrix[0].length;

        int row1 = 0;
        int row2 = M-1;
        int col1 = 0;
        int col2 = N-1;
        int total = M*N;

        while(result.size() < total){
            for (int right=col1; right<=col2 && result.size() < total; right++)
                result.add(matrix[row1][right]);
            for (int down=row1+1; down<=row2 && result.size() < total; down++)
                result.add(matrix[down][col2]);
            for (int left=col2-1; left>=col1 && result.size() < total; left--)
                result.add(matrix[row2][left]);
            for (int up=row2-1; up>row1 && result.size() < total; up--)
                result.add(matrix[up][col1]);

            row1++;row2--;col1++;col2--;
        }

        return result;

    }

}
