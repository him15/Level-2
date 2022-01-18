import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    // int m = sc.nextInt();
    int[] dp = new int[n + 1];

    // System.out.println(diceThrowRecursive(n));           // recursive solution
    // System.out.println(diceThrow_Memo(n, dp));  // memo
    // System.out.println(diceThrow_DP(n, dp));    //dp
    System.out.println(diceThrow_SpaceOptimize(n)); // space optimization
    // print1D(dp);
    // print2D(dp);
  }

  public static int diceThrowRecursive(int n) {
    if (n == 0) {
      return 1;
    }
    int count = 0;
    for (int jump = 1; jump <= 6; jump++) {
      if (n - jump >= 0) {
        count += diceThrowRecursive(n - jump);
      }
    }
    return count;
  }

  public static int diceThrow_Memo(int n, int[] dp) {
    if (n == 0) {
      return dp[n] = 1;
    }
    if (dp[n] != 0) {
      return dp[n];
    }
    int count = 0;
    for (int jump = 1; jump <= 6; jump++) {
      if (n - jump >= 0) {
        count += diceThrow_Memo(n - jump, dp);
      }
    }
    return dp[n] = count;
  }

  public static int diceThrow_DP(int N, int[] dp) {
    for (int n = 0; n <= N; n++) {
      if (n == 0) {
        dp[n] = 1;
        continue;
      }
      int count = 0;
      for (int jump = 1; jump <= 6; jump++) {
        if (n - jump >= 0) {
          count += dp[n - jump]; //diceThrow_Memo(n - jump, dp);
        }
      }
      dp[n] = count;
    }

    return dp[N];
  }
  
  public static int diceThrow_SpaceOptimize(int N){
      LinkedList<Integer> list = new LinkedList<>();
      for(int n = 0; n <= N; n++){
          if(n == 0 || n == 1){
              list.addLast(1);
          }else{
              if(list.size() <= 6){
                  list.addLast(list.getLast() * 2);
              }else{
                  list.addLast(list.getLast() * 2 - list.removeFirst());
              }
          }
      }
      return list.getLast();
  }

  public static void print1D(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void print2D(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}
