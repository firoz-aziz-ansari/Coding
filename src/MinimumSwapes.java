/*

You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.

For example, given the array  we perform the following steps:

i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took 5 swaps to sort the array.


Sample Input
4
4 3 1 2
Sample Output
3

 */


import java.util.Arrays;

public class MinimumSwapes {

    public static void main(String[] args){

        int[] arr = {4,3,1,2};

        int swapes=0;

        for(int i=0; i<arr.length; i++){
            while(arr[i] != (i+1)){
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
                swapes++;
            }
        }

        System.out.println(swapes);

    }

}
