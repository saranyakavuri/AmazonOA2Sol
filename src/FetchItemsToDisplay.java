
    import java.util.*;

    public class FetchItemsToDisplay {

        public static void main(String[] args) {

            int numOfItems = 3;
            HashMap<String, int[]> items = new HashMap<>();
            items.put("item1", new int[]{10, 5});
            items.put("item2", new int[]{3, 4});
            items.put("item3", new int[]{17, 8});
            items.put("item5", new int[]{1, 2});
            items.put("item7", new int[]{12, 15});

            int sortParam = 1;
            int sortOrder = 1; //0 is Asc and 1 is Desc
            int itemsPerPage = 2;
            int pageNumber = 1;

            FetchItemsToDisplay f = new FetchItemsToDisplay();
            List<String> res = f.fetchItemsToDisplay(numOfItems, items, sortParam, sortOrder, itemsPerPage, pageNumber);

            System.out.println("List of items is: " + res);

            // Output: List of items is: [item1, item2]
            // Since the list is expected to be in descending order on the relevance value and needs items on Page1

        }

        public List fetchItemsToDisplay(int numOfItems, HashMap<String, int[]> items, int sortParameter,
                                        int sortOrder, int itemsPerPage, int pageNumber) {
            PriorityQueue<DisplayItems> pq = new PriorityQueue<>();
            if (sortOrder == 1)
                pq = new PriorityQueue<>(Collections.reverseOrder());

            //Since the int array has ["relevance_value", "price_value"]
            //If the sort parameter is 1, I am picking 0th value as my key in the pq else the 1st value (sortParameter - 1)
            for (Map.Entry<String, int[]> map : items.entrySet()) {
                pq.add(new DisplayItems(map.getValue()[sortParameter - 1], map.getKey()));
            }

            List<String> result = new ArrayList<>();
            while (!pq.isEmpty()) {
                result.add(pq.peek().itemName);
                pq.poll();
            }

            //Fetching the items on the given pageNumber
            int startIndex = pageNumber * itemsPerPage;
            int endIndex = (startIndex + itemsPerPage) > result.size() ? result.size() : startIndex + itemsPerPage;

            return result.subList(startIndex, endIndex);
        }

        public class DisplayItems implements Comparable<DisplayItems> {
            private String itemName;
            private Integer value;

            public DisplayItems(Integer value, String itemName) {
                this.itemName = itemName;
                this.value = value;
            }

            public String getItemName() {
                return itemName;
            }

            public Integer getValue() {
                return value;
            }

            @Override
            public int compareTo(DisplayItems o) {
                return this.getValue().compareTo(o.value);
            }
        }
    }

