package Hashing;
import java.util.*;

public class ItineraryFromTickets {
    public static void getItenirary(String[][] tickets) {
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<tickets.length; i++) {
            map.put(tickets[i][0], tickets[i][1]);
        }
        
        HashMap<String, String> revMap = new HashMap<>();
        for(int i=0; i<tickets.length; i++) {
            revMap.put(tickets[i][1], tickets[i][0]);
        }

        String start = "";

        Set<String> keys1 = map.keySet();
        for(String key : keys1) {
            if(!revMap.containsKey(key)) {
                start = key;
                break;
            }
        }

        String from = start;
        System.out.print(from);
        while(true) {
            if(map.get(from) == null) {
                break;
            }
            String to = map.get(from);
            System.out.print(" -> "+to);
            from = to;
        }
    }

    public static void main(String[] args) {
        String[][] tickets = {{"Chennai","Bengaluru"},
                              {"Mumbai", "Delhi"},
                              {"Goa", "Chennai"},
                              {"Delhi", "Goa"}};
                              
        

        getItenirary(tickets);
    }   
}
