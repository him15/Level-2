import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] dp = new int[n][m];

    // System.out.println(countMazePathWithJumps(0, 0, n - 1, m - 1));           // recursive solution
    // System.out.println(countMazePathWithJumps_Memo(0, 0, n - 1, m - 1, dp));  // memo
    System.out.println(countMazePathWithJumps_DP(0, 0, n - 1, m - 1, dp));    //dp
    print2D(dp);
  }

  public static int countMazePathWithJumps(int sr, int sc, int dr, int dc) {
    if (sr == dr && sc == dc) {
      return 1;
    }
    int count = 0;
    for (int jump = 1; sc + jump <= dc; jump++) {
      count += countMazePathWithJumps(sr, sc + jump, dr, dc);
    }
    for (int jump = 1; sr + jump <= dr; jump++) {
      count += countMazePathWithJumps(sr + jump, sc, dr, dc);
    }
    for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
      count += countMazePathWithJumps(sr + jump, sc + jump, dr, dc);
    }
    return count;
  }

  public static int countMazePathWithJumps_Memo(int sr, int sc, int dr, int dc, int[][] dp) {
    if (sr == dr && sc == dc) {
      return dp[sr][sc] = 1;
    }
    if (dp[sr][sc] != 0) {
      return dp[sr][sc];
    }
    int count = 0;
    for (int jump = 1; sc + jump <= dc; jump++) {
      count += countMazePathWithJumps_Memo(sr, sc + jump, dr, dc, dp);
    }
    for (int jump = 1; sr + jump <= dr; jump++) {
      count += countMazePathWithJumps_Memo(sr + jump, sc, dr, dc, dp);
    }
    for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
      count += countMazePathWithJumps_Memo(sr + jump, sc + jump, dr, dc, dp);
    }
    return dp[sr][sc] = count;
  }

  public static int countMazePathWithJumps_DP(int SR, int SC, int dr, int dc, int[][] dp) {
    for (int sr = dr; sr >= 0; sr--) {
      for (int sc = dc; sc >= 0; sc--) {
        if (sr == dr && sc == dc) {
          dp[sr][sc] = 1;
          continue;
        }

        int count = 0;
        for (int jump = 1; sc + jump <= dc; jump++) {
          count += countMazePathWithJumps_Memo(sr, sc + jump, dr, dc, dp);
        }
        for (int jump = 1; sr + jump <= dr; jump++) {
          count += countMazePathWithJumps_Memo(sr + jump, sc, dr, dc, dp);
        }
        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
          count += countMazePathWithJumps_Memo(sr + jump, sc + jump, dr, dc, dp);
          dp[sr][sc] = count;
        }
      }
    }
    return dp[SR][SC];
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

