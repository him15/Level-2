import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    int ans = fib_dp2(n, dp);
    System.out.println(ans);
  }
  // recursion
  public static int fib(int n){
      if(n == 0 || n == 1){
          return n;
      }
      int ans = 0;
      ans = fib(n - 1) + fib (n - 2);
      return ans;
  }
  // memoization
  public static int fib_memo(int n, int[] dp){
      if(n == 0 || n == 1){
          return dp[n] = n;
      }
      if(dp[n] != -1){
          return dp[n];
      }
      int ans = 0;
      ans = fib(n - 1) + fib (n - 2);
      return dp[n] = ans;
  }
  // tabulation
  public static int fib_dp(int n, int[] dp){
      for(int i = 0; i <= n; i++){
          if(i == 0 || i == 1){
              dp[i] = i;
              continue;
          }
          dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
  }
  public static int fib_dp2(int n, int[] dp){
      dp[0] = 0;
      dp[1] = 1;
      for(int i = 2; i <= n; i++){
          dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
  }
  // space Optimization
  public static int fib_optimization(int n){
      int a = 0;
      int b = 1;
      for(int i = 0; i < n; i++){
          int sum = a + b;
          a = b;
          b = sum;
      }
      return a;
  }
  

}
