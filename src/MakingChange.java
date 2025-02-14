import java.util.Arrays;
import java.util.Collections;

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
        // Memoization
        long[][] memoizationTable = new long[coins.length][target + 1];
        for(int i = 0; i < memoizationTable.length; i++){
            memoizationTable[i][0] = 1;
        }
        // Tabulation
        long[][] tabulationTable = new long[coins.length][target + 1];
        for(int i = 0; i < tabulationTable.length; i++){
            tabulationTable[i][0] = 1;
        }
        Arrays.sort(coinsSorted);
        long totalWays = 0;
        // Tabulation
        for(int i = 0; i < tabulationTable.length; i++){
            for(int j = 0; j < tabulationTable[0].length - 1; j++){
                totalWays = findWaysTabulation(j + 1, coinsSorted, i, tabulationTable);
            }
        }
        // Memoization
        //totalWays = findWaysMemoization(target, coinsSorted, 0, memoizationTable);
        return totalWays;
    }
    public static long findWaysTabulation(int target, int[] coins, int index, long[][] table){
        // Base cases
        if(target == 0){
            return 1;
        }
        else if(target < 0){
            return 0;
        }
        else if(index < 0){
            return 0;
        }
        else if(table[index][target] != 0){
            return table[index][target];
        }
        // Recursive step
        table[index][target] = findWaysTabulation(target - coins[index], coins, index, table) + findWaysTabulation(target, coins, index - 1, table);
        return table[index][target];
    }
    public static long findWaysMemoization(int target, int[] coins, int index, long[][] table){
        // Base cases
        if(target == 0){
            return 1;
        }
        else if(target < 0){
            return 0;
        }
        else if(index >= coins.length){
            return 0;
        }
        else if(table[index][target] != 0){
            return table[index][target];
        }
        long sum = 0;
        // Recursive step
        sum = findWaysMemoization(target - coins[index], coins, index, table) + findWaysMemoization(target, coins, index + 1, table);
        table[index][target] = sum;
        return sum;
    }
    /*
    public static int findWays(int target, int[] coins){
        /*
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
    */
}
