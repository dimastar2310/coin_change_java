import java.util.Arrays;

public class coin_problem {
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] T = new int[n+1][amount+1];

        for (int i = 0; i <= amount; i++) {
            T[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                //because of baunds
                if (coins[i - 1] > j) { // if the coin value is greater than the current amount
                    T[i][j] = T[i - 1][j];
                } else {
                    T[i][j] = Math.min(T[i - 1][j], 1 + T[i][j - coins[i-1]]);
                }
            }
        }

        print_mat(T);
        return T[n][amount] > amount ? -1 : T[n][amount];
    }


    private static void print_mat(int[][] t) {
        int n = t.length;
        int m = t[0].length;
        for (int i = 0; i <n ; i++) {
            System.out.println(Arrays.toString(t[i]));

        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,5};
        int amount = 11;
        int[] arr2 = {2};
        int amount2 = 2;

        int[] arr3 = {1,5,6,9};
        int amount3 = 10;

        int[] arr4 = {1,5,6,8};
        int amount4 = 11;
        int sol = coinChange(arr3,amount3);
        //int sol2 = change(amount4,arr4);
        System.out.println("the second data is ="+sol);
    }
}

