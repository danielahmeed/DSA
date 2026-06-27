class Solution {
    public int change(int amount, int[] coins) {
       
   /*    number of ways humko nikalna hain Arftr that
       5=5
5=2+2+1  -> return 4 ;
5=1+1+1+1+1
       if (amount is not matxhing ) {
        return 0;
       }
*/
return solve (0, amount ,coins);
    }
    int solve (int index, int amount , int[] coins) {
        if (amount == 0)
            return 1;
            if (index == coins.length)
            return 0;
            int take = 0 ;
               if (coins[index] <= amount)
            take = solve(index, amount - coins[index], coins);

        int skip = solve(index + 1, amount, coins);

        return take + skip;
    }

    }
