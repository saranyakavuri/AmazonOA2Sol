public class EarliestTimeToCompleteDeliveries {

    public static int earliestTime(int numOfBuildings, List<Integer> openTime, List<Integer> offloadTime) {
        openTime.sort(null);
        offloadTime.sort(Collections.reverseOrder());
        int earliestTime = 0;
        for (int i = 0; i < numOfBuildings; i++) {
            earliestTime = Math.max(earliestTime, openTime.get(i) + offloadTime.get(i * 4));
        }
        return earliestTime;
    }
}



/*import java.util.*;
class CompleteDeliveries{
public static void main(String[] args){
	int numBuilding = 2;
	int[] openTime = {8,10};
	int[] offloadTime = {2,2,3,1,8,7,4,5};
	//int[] offloadTime = {2,2,3,1,8,7,4,5,13,5,4,2};
	System.out.println(findEarliestTime(numBuilding,openTime,offloadTime));
}
public static int findEarliestTime(int numBuilding,int[] openTime,int[] offloadTime){
	Arrays.sort(openTime);
	// To sort in descending order, first sort in ascending the swap elements
	Arrays.sort(offloadTime);

	// Swap first and last elements and proceed
	for (int i = 0, j = offloadTime.length - 1, tmp; i < j; i++, j--) {
            tmp = offloadTime[i];
            offloadTime[i] = offloadTime[j];
            offloadTime[j] = tmp;
        }

	int max = Integer.MIN_VALUE;
	for(int i=0;i<numBuilding;i++)
		max = Math.max(openTime[i]+offloadTime[i*4],max);
	return max;
}
}

*/





