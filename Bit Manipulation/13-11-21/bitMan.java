// leetcode 231
class Solution {
    public boolean isPowerOfTwo(int n) {
         return n > 0 && (n & (n - 1)) == 0;
    }
}

// leetcode 342
class Solution {
    public boolean isPowerOfFour(int n) {
        if( ((n <= 0) || ((n & (n - 1)) != 0))){
            return false;
        }
        int count = 0;
        while(n != 1){
            n >>>= 1;
            count++;
        }
        
        return(count & 1) == 0;
    }
}

// leetcode 191
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n &= (n - 1);
            count++;
        }
        return count;
    }
}

// leetcode 338
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 1; i <= n; i++){
            ans[i] = ans[(i & (i - 1))] + 1;
        }
        return ans;
    }
}
