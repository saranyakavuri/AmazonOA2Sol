public class ROLLDICE {

    import java.util.*;

    public class DiceProblem {
        public static void main(String args[]){
            int[] A = {3,4,1,2,4,2,3,5,1,2,3,4,6,2,4,1,5,2};
            Map<Integer, Integer> countMap = new HashMap<>();
            int rotation = 0;
            int diceCount;
            int maxDiceNumber = A[0];
            int OppositeOfMaxDiceNumber;
            int max = 1;

            for(int i = 1; i <= 6 ; i++){
                diceCount = 0;
                for (int value : A) {
                    if(i == value){
                        diceCount++;
                    }
                }
                countMap.put(i, diceCount);
                if(diceCount > max){
                    max = diceCount;
                    maxDiceNumber = i;
                }
            }

            if(max == 1){
                if(countMap.get(1).equals(countMap.get(6)) && countMap.get(1) != 0 && countMap.get(2) != 0){
                    maxDiceNumber = 2;
                }else if(countMap.get(2).equals(countMap.get(5))  && countMap.get(2) != 0 && countMap.get(3) != 0){
                    maxDiceNumber = 3;
                }else if(countMap.get(3).equals(countMap.get(4)) && countMap.get(1) != 0){
                    maxDiceNumber = 1;
                }else if(countMap.get(2) != 0){
                    maxDiceNumber = 2;
                }else if(countMap.get(5) != 0){
                    maxDiceNumber = 5;
                }else if(countMap.get(6) != 0){
                    maxDiceNumber = 6;
                }
            }

            System.out.println("Max Dice Number: "+ maxDiceNumber);
            OppositeOfMaxDiceNumber = createOpposite(maxDiceNumber);
            System.out.println("Opposite Dice Number: "+ OppositeOfMaxDiceNumber);

            Iterator it2 = countMap.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry pair = (Map.Entry)it2.next();
                System.out.println(pair.getKey() + " = " + pair.getValue());
                if((int)(pair.getValue()) > 0 && (int)(pair.getKey()) != maxDiceNumber){
                    if((int)(pair.getKey()) == OppositeOfMaxDiceNumber){
                        rotation = rotation + (2  * (int)(pair.getValue()));
                    }else {
                        rotation = rotation + ((int)(pair.getValue()));
                    }
                }

                it2.remove(); // avoids a ConcurrentModificationException
            }
            System.out.println("Number of Minimum Rotations: "+ rotation);

        }
        private static int createOpposite(int key){
            switch (key) {
                case 1:
                    return 6;
                case 2:
                    return 5;
                case 3:
                    return 4;
                case 4:
                    return 3;
                case 5:
                    return 2;
                case 6:
                    return 1;
            }
            return 0;
        }
    }


}
