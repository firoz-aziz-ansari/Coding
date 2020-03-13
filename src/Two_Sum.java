/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */

import java.util.HashMap;

public class Two_Sum {

    public static void main(String args[]){
        int nums[] = {3, 2, 11, 15, 7};
        int target = 9;

        HashMap<Integer, Integer> num_ix = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++){
            num_ix.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if (num_ix.containsKey(temp) && num_ix.get(temp) != i){
                int ret[] = {i, num_ix.get(temp)};
                System.out.print(ret[0]+ " " +ret[1]);
                System.exit(0);
            }
        }

    }
}
