package Arrays;

public class TrappingRainwater {
    public static int trappedWater(int height[]) {
        int n = height.length;
        
        // leftMax boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        
        // rightMAx boundary
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        // loop
        int trappedWater = 0;
        for(int i=0; i<n; i++) {
            // waterLevel calculation
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            
            // trappedWater calculation
            trappedWater += waterLevel - height[i]; 
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println("Trapped Water = " + trappedWater(height));
    }
}
