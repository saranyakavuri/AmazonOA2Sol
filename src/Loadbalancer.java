public class Loadbalancer {

    public boolean isBalanced(int[] array) {

        if(array == null || array.length < 5) {
            return false;
        }
        int sum = 0;
        for(int number : array) {
            sum+=number;
        }
        int i= 0;
        int j = array.length-1;
        int leftSum = array[i];
        int rightSum = array[j];
        while(true) {

            if(i>=j){
                break;
            }
            if(leftSum == rightSum) {
                int middleSum  = sum - ((leftSum+rightSum) +(array[i+1]+array[j-1]));
                if(leftSum==middleSum) {
                    return true;
                }
                leftSum +=array[++i];
                rightSum += array[--j];
            } else if (leftSum<rightSum) {
                leftSum +=array[++i];
            } else {
                rightSum += array[--j];
            }
        }
        return false;

    }
}
