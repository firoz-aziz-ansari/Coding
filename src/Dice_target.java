/*

You have d dice, and each die has f faces numbered 1, 2, ..., f.
Return the number of possible ways (out of f^d total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up
numbers equals target.

Input: d = 1, f = 6, target = 3
Output: 1
Explanation:
You throw one die with 6 faces.  There is only one way to get a sum of 3.

Input: d = 2, f = 6, target = 7
Output: 6
Explanation:
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.

Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation:
The answer must be returned modulo 10^9 + 7.

*/

public class Dice_target {

    private static int[][] dTar;
    private static int MODULUS;

    public static void main(String args[]){
        int d=30;
        int f=30;
        int target=500;

        dTar = new int[d + 1][target + 1];
        dTar[0][0] = 1;

        MODULUS = 1000000007;

        for (int i=1; i<=d; i++){
            for (int j=1; j<=target; j++){
                for (int k=1; k <= f && k <= j; k++){
                    dTar[i][j] = (dTar[i][j] + dTar[i-1][j-k]) % MODULUS;
                }
            }
        }

        System.out.print(dTar[d][target]);


    }
}
