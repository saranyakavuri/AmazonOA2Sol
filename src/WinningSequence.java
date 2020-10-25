
    import java.util.Arrays;
    public class WinningSequence{
        public static void main(String []args){
            int count=5;
            int lowerEnd = 2+1;
            int upperEnd = 5+5;
            int len = Math.max(1+(upperEnd-(upperEnd-lowerEnd))*2, 1+(upperEnd-lowerEnd)*2);
            int[] arr = new int[len];
            int start = lowerEnd;
            for(int i=0;i<=arr.length/2;i++){
                arr[i]= start;
                if(i!=arr.length/2)
                    arr[arr.length-i-1]=start;
                start++;
            }
            //System.out.println(Arrays.toString(arr));
            int[] res = new int[count];
            if(arr.length<count)
                System.out.println("not possible");
            else{
                res[0]=arr[arr.length/2-1];
                for(int i=1,j=arr.length/2;i<res.length;i++,j++){
                    res[i]=arr[j];
                }
            }
            System.out.print(Arrays.toString(res));
        }
    }

