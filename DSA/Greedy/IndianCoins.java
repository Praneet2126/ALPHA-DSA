package Greedy;

import java.util.*;

public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 5059;

        Arrays.sort(coins, Comparator.reverseOrder());

        int countCoins = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<coins.length; i++) {
            if(amount >= coins[i]) {
                countCoins++;
                amount -= coins[i];
                list.add(coins[i]);
                i--;
            }
        }

        System.out.println(countCoins);
        System.out.println(list);
    }
}
