public class FreshPromotion_FruitList {

    public static void main(String[] args) {
        String[][] codeList1 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = {{"apple", "apple"}, {"apple", "apple", "banana"}};
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7 = {{"anything", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        System.out.println(solve(codeList1, shoppingCart1));
        System.out.println(solve(codeList2, shoppingCart2));
        System.out.println(solve(codeList3, shoppingCart3));
        System.out.println(solve(codeList4, shoppingCart4));
        System.out.println(solve(codeList5, shoppingCart5));
        System.out.println(solve(codeList6, shoppingCart6));
        System.out.println(solve(codeList7, shoppingCart7));
    }

    private static int solve(String[][] codeList, String[] shoppingCart) {
        if (codeList == null || codeList.length == 0)
            return 1;
        if (shoppingCart == null || shoppingCart.length == 0)
            return 0;
        int i = 0, j = 0;
        for (int k = 0; k < shoppingCart.length; k++) {
            if (codeList[i][j].equals(shoppingCart[k]) || codeList[i][j].equals("anything")) {
                j++;
                if (j == codeList[i].length) {
                    i++;
                    j = 0;
                }
                if (i == codeList.length)
                    return 1;
            } else {
                j = codeList[i][0].equals("anything") ? 1 : 0;
            }
        }
        return 0;


    }
}
