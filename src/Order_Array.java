/*

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't
appear in arr2 should be placed at the end of arr1 in ascending order.

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

*/

import java.util.*;

public class Order_Array {

    public static void main(String args[]){
        int arr2[] = {2,1,4,3,9,6};
        int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};

        LinkedHashMap<Integer, ArrayList<Integer>> sortMap = new LinkedHashMap<Integer, ArrayList<Integer>>();

        for (int i=0; i<arr2.length; i++){
            sortMap.put(arr2[i], new ArrayList<Integer>());
        }

        for (int i=0; i<arr1.length; i++){
            if (!sortMap.containsKey(arr1[i])) {
                sortMap.put(arr1[i], new ArrayList<Integer>());
                sortMap.get(arr1[i]).add(arr1[i]);
            }
            else{
                sortMap.get(arr1[i]).add(arr1[i]);
            }
        }

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        ArrayList<Integer> a2 = new ArrayList<Integer>();

        Iterator<Map.Entry<Integer, ArrayList<Integer>>> i = sortMap.entrySet().iterator();

        while (i.hasNext()){
            Map.Entry<Integer, ArrayList<Integer>> key_value = i.next();
            ArrayList<Integer> values = key_value.getValue();
            int j=0;
            for (; j<arr2.length; j++){
                if (values.get(0) == arr2[j]){
                    a1.addAll(values);
                    break;
                }
            }
            if (j==arr2.length){
                a2.addAll(values);
            }
        }

        Collections.sort(a2);
        a1.addAll(a2);
        System.out.print(a1);

    }
}
