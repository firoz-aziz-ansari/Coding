/*

A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and
 (x2, y2) are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at
the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false

 */


import java.util.Arrays;

public class Rectangle_Overlap {

    public static void main(String args[]){
        int rect1[] = {0, 0, 2, 2};
        int rect2[] = {1, 1, 3, 3};

        boolean result = isRectangleOverlap(rect1, rect2);

        System.out.println(result);
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int left1[] = new int[2];
        int right1[] = new int[2];
        int left2[] = new int[2];
        int right2[] = new int[2];

        left1[0] = rec1[0];
        left1[1] = rec1[1];
        right1[0] = rec1[2];
        right1[1] = rec1[3];

        left2[0] = rec2[0];
        left2[1] = rec2[1];
        right2[0] = rec2[2];
        right2[1] = rec2[3];

        System.out.println("l1 : " + Arrays.toString(left1));
        System.out.println("r1 : " + Arrays.toString(right1));
        System.out.println("l2 : " + Arrays.toString(left2));
        System.out.println("r2 : " + Arrays.toString(right2));

        // if one rectangle is beside another with no overlap
        if (right1[0] <= left2[0] || right2[0] <= left1[0]) {
            System.out.println("Condition 1");
            return false;
        }

        // if one rectangle is on top or bottom of another with no overlap
        if (right2[1] <= left1[1] || right1[1] <= left2[1]) {
            System.out.println("Condition 2");
            return false;
        }
        return true;
    }

//    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//        return !(rec1[2] <= rec2[0] ||   // left
//                rec1[3] <= rec2[1] ||   // bottom
//                rec1[0] >= rec2[2] ||   // right
//                rec1[1] >= rec2[3]);    // top
//    }

}
