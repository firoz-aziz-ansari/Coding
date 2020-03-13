/*

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum
is equal to the given target.

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

 */


import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Two_Sum_BST {

    private ArrayList<Integer> al;

    public boolean findTarget(TreeNode root, int k) {
        al = new ArrayList<Integer>();

        treeToArray(root, al);

        int left=0;
        int right=al.size()-1;

        while(left<right){
            if(al.get(left)+al.get(right) == k)
                return true;
            if(al.get(left)+al.get(right) > k)
                right--;
            else
                left++;
        }
        return false;
    }

    public static void treeToArray(TreeNode root, ArrayList<Integer> al){
        if(root == null){
            return;
        }
        treeToArray(root.left, al);
        al.add(root.val);
        treeToArray(root.right, al);
    }

}
