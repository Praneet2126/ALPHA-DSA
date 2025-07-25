package PatternWise.StacksQueues.MonotonicStack;

import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] nextGreater = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nextGreater[i] = 0;
            } else {
                nextGreater[i] = s.peek();
            }

            s.push(i);
        }

        for(int i=0; i<n; i++) {
            nextGreater[i] = nextGreater[i] == 0 ? 0 : nextGreater[i] - i; 
        }

        return nextGreater;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        for(int ele : res) {
            System.out.print(ele+" ");
        }
    }
}
