import java.util.*;

public class HighestProfit {

        public static int maximum_profit(int[] inventory, int order){
// create map with inventory value and no of occurences in map i.e if there are 2 items of stock 10,10 map will be 10,2
            HashMap<Integer, Integer> hm=new HashMap();
            for(int i:inventory){
                hm.put(i, hm.getOrDefault(i,0)+1);
            }
// find the maximum value in map. avoid sort so that we can achieve solution in O(n)
// we know that after each item is purchased profit is going to reduce by cut_item-1
            int cur_max = Integer.MIN_VALUE;
            for(int i:hm.keySet()){
                cur_max=Math.max(cur_max,i);
            }
            System.out.println(cur_max);
            int answer=0;
            while(order>0){
                // get the no of items in stock for cur_max inventory
                int no_items = Math.min(order, hm.get(cur_max));
                answer += no_items*cur_max; // calculate current profit
                order = order-no_items; // reduce no of items to order still
                int left_items = hm.get(cur_max) - no_items; // get the no of items in cur_max key and deduce the no of items ordered
                hm.put(cur_max-1, hm.getOrDefault(cur_max-1, 0)+no_items); // we know for when we order next item it's price is going to drop by 1
                // if there is entry in map then update the map value with no of items. if not create new entry
                // if no items are left in stock for max_profit inventory item. remove the entry from map and reduce the profit by 1
                if(left_items == 0){
                    hm.remove(cur_max);
                    cur_max--;
                }

            }

            return answer;

        }

        public static void main(String[] args) {

            int[] inventory = {10,2,8,4,6};
            int order = 20;
            int profit = maximum_profit(inventory, order);
            System.out.println("Total Profit is:  "+ profit);
        }
    }







