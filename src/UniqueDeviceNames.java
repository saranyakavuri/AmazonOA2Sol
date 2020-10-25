public class UniqueDeviceNames {

    public class Main {
        public static void uniqueDevices(String[] devices){
            HashMap<String,Integer> map = new HashMap<>();
            String[] res = new String[devices.length];
            for(int i=0;i<devices.length;i++){
                map.put(devices[i],map.getOrDefault(devices[i],0)+1);
                if(map.get(devices[i]) > 1){
                    StringBuilder device = new StringBuilder(devices[i]);
                    int uniqueNumber = map.get(devices[i]) - 1;
                    device.append(Integer.toString(uniqueNumber));
                    res[i] = device.toString();
                }
                else{
                    res[i] = devices[i];
                }
            }
            for(String s :  res){
                System.out.print(s+" ");
            }
        }
        public static void main(String[] args) {
            String[] devices = {"switch","tv","switch","tv","switch","tv","tv"};
            //switch tv switch1 tv1 switch2 tv2 tv3
            uniqueDevices(devices);
        }
    }

}
