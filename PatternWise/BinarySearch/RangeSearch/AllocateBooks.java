package PatternWise.BinarySearch.RangeSearch;

public class AllocateBooks {
    public static int canAllocate(int mid, int[] pages, int students) {
        int studentCount = 1;
        int sum = 0;
        for(int page : pages) {
            if(sum + page > mid) {
                studentCount++;
                sum = page;
            } else {
                sum += page;
            }
        }
        return studentCount; 
    }

    public static int allocateBooks(int[] pages, int students) {
        if(pages.length < students) return -1;

        int left = 0;
        int right = 0;

        for(int i=0; i<pages.length; i++) {
            left = Math.max(left, pages[i]);
            right += pages[i]; 
        }

        int ans = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int k = canAllocate(mid, pages, students);
            if(k <= students) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            } 
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] pages = {25,46,28,49,24};
        int students = 4;

        System.out.println(allocateBooks(pages, students));
    }
}
