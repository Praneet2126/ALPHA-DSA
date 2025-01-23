package Divide_and_Conquer;

public class QuestionEasy {
    public static void mergeSortStrings(String arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }

        int mid = si + (ei - si)/2;
        mergeSortStrings(arr, si, mid);
        mergeSortStrings(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=ei) {
            if(stringIsSmaller(arr[i], arr[j])) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++; 
            }
            k++;
        }

        while(i<=mid) {
            temp[k++] = arr[i++];
        }

        while(j<=ei) {
            temp[k++] = arr[j++];
        }

        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static boolean stringIsSmaller(String s1, String s2) {
        int i = 0;
        int j = 0;

        while(i <= s1.length() || j <= s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++; j++;
            } else {
                if(s1.charAt(i) < s2.charAt(j)) {
                    return true;
                } else {
                    break;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String arr[] = {"sun", "earth", "mars", "mercury"};
        // String arr[] = {"xyz", "aabb", "abc", "abba"};
        mergeSortStrings(arr, 0, arr.length-1);

        for(String i : arr) {
            System.out.print(i + " ");
        }
    }
}
