public class ThrottlingGateway {

    import java.util.*;

    public class Solution {
        public static int solve(int[] arr) {

            List<Integer> indCount = new ArrayList<>();
            List<Integer> aggCount = new ArrayList<>();

            indCount.add(0);
            aggCount.add(0);

            int droppedCount = 0;


            for(int i=0;i<arr.length;i++)
            {
                int a = arr[i];

                if(a+1>indCount.size())
                {
                    if(a+1 > indCount.size()+1)
                    {
                        for(int k=indCount.size();k<a;k++)
                        {
                            indCount.add(0);
                            aggCount.add(aggCount.get(k-1));
                        }
                    }
                    indCount.add(1);
                    aggCount.add(1+aggCount.get(a-1));
                }
                else{
                    indCount.set(a,indCount.get(a)+1);
                    aggCount.set(a,aggCount.get(a)+1);
                }

                if(indCount.get(a)>3)
                {
                    droppedCount++;
                    continue;
                }
                if(a>=10)
                {
                    if(aggCount.get(a)-aggCount.get(a-10)>20)
                    {
                        droppedCount++;
                        continue;
                    }
                }
                else
                {
                    if(aggCount.get(a)>20)
                    {
                        droppedCount++;
                        continue;
                    }
                }
                if(a>=60)
                {
                    if(aggCount.get(a)-aggCount.get(a-60)>60)
                    {
                        droppedCount++;
                    }
                }
                else
                {
                    if(aggCount.get(a)>60)
                    {
                        droppedCount++;
                    }
                }
            }

            return droppedCount;
        }
    }
}
