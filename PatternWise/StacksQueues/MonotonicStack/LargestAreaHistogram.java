package PatternWise.StacksQueues.MonotonicStack;

import java.util.*;

public class LargestAreaHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];

        //Next Smaller Left
        for(int i=0; i<heights.length; i++) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nsl[i] = -1;
            } else { 
                nsl[i] = s.peek(); // for width index matters not value
            }

            s.push(i);
        }

        //Next Smaller Right
        s = new Stack<>();
        for(int i=heights.length-1; i>=0; i--) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nsr[i] = heights.length;
            } else {
                nsr[i] = s.peek();  // for width index matters not value
            }

            s.push(i);
        } 

        int maxArea = 0;
        for(int i=0; i<heights.length; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
    
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
