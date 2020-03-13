/*

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:
Moving_Average m = new Moving_Average(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

 */


import java.util.LinkedList;
import java.util.Queue;

public class Moving_Average {

    private Queue<Integer> queue;
    private int maxSize;
    private double sum;

    /** Initialize your data structure here. */
    public Moving_Average(int size) {
        queue = new LinkedList<Integer>();
        maxSize = size;
        sum =0.0;
    }

    public double next(int val) {
        if(queue.size() == maxSize){
            sum = sum - queue.remove();
        }

        queue.add(val);
        sum = sum + val;

        return sum/queue.size();

    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
