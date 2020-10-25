public class FiveStarSellers {


    public String[] processLogFile(String[] logs, int threshold) {
        Map<String,Integer> file = new HashMap<>();
        for(String log:logs){
            String[] arr = log.split(" ");
            if(!arr[0].equals(arr[1]))
                file.put(arr[0],file.getOrDefault(arr[0],0)+1);
            file.put(arr[1],file.getOrDefault(arr[1],0)+1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : file.entrySet()) {
            if(entry.getValue()>=threshold){
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        return list.stream().toArray(String[]::new);
    }
}
