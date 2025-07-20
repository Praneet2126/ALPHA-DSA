package PatternWise.BinarySearch.RangeSearch;

public class CapacityToShipPackages {
    public static boolean canShip(int[] weights, int cap, int days) {
        int ships = 1;
        int currCap = cap;
        for(int weight : weights) {
            if(currCap - weight < 0) {
                ships++;
                currCap = cap;
            }
            currCap -= weight;
        }

        return ships <= days;
    }
    
    public static int shipWithinDays(int[] weights, int days) {
        // lower bound and upper bound
        int left = 0;
        int right = 0;
        for(int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        
        int res = right;
        int cap = 1;
        while(left <= right) {
            cap = (left + right) / 2;
            if(canShip(weights, cap, days)) {
                res = cap;
                right = cap - 1;
            } else {
                left = cap + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}
