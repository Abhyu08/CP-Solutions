import java.util.Arrays;

class Solution {
    
    /*  //Find out possible combinations O(n^k)
        public void combination_Sum2(int[] candidates,  int target, ArrayList<Integer> list) {
        if (target < 0) {
            return;
        } else if (target == 0) {
               result = Math.min(result , list.size());
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (target - candidates[i] < 0)
                    continue;
                list.add(candidates[i]);
                combination_Sum2(candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
    */

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        //Arrays.sort(coins);
        Arrays.fill(dp , amount + 1);
        dp[0] = 0 ;
        for(int i=0;i<=amount;i++)
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i] , 1 + dp[i-coins[j]]);
                }
            }
        return dp[amount] == amount+1 ? -1 : dp[amount];
        // combination_Sum2(coins , amount , new ArrayList<Integer>());
        //return result == Integer.MAX_VALUE ? -1 : result ;

    }
}