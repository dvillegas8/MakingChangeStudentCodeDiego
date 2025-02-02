import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Diego Villegas
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {
        // Get the method that uses the least amount of coins with the biggest value
        int[] coinsSorted = coins;
        Arrays.sort(coinsSorted);
        int numWays = 0;
        int remainder = 0;

        for(int i = 0; i < coinsSorted.length; i++){
            int[] certainCoins = new int[i + 1];
            certainCoins = Arrays.copyOfRange(coinsSorted, 0, i);
            numWays += findWays(target, coins);
        }
        return 0;
    }
    public static int findWays(int target, int[] coins){
        int numWays = 0;
        int remainder = 0;
        int difference = target;
        // if we have a single coin
        if(coins.length == 1){
            if(target % coins[0] == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        // Start from the biggest coin
        for(int i = coins.length - 1; i >= 0; i--){
            remainder = difference % coins[i];

        }
        if(remainder == 0){
            return 1;
        }
        return 0;
    }
}
