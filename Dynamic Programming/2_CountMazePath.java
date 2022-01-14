import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] dp = new int[n][m];

    // System.out.println(countMazePath(0, 0, n - 1, m - 1));           // recursive solution
    // System.out.println(countMazePath_Memo(0, 0, n - 1, m - 1, dp));  // memo
    System.out.println(countMazePath_DP(0, 0, n - 1, m - 1, dp));    //dp
    print2D(dp);
  }

  public static int countMazePath(int sr, int sc, int dr, int dc) {
    if (sr == dr && sc == dc) {
      return 1;
    }
    int count = 0;
    if (sc + 1 <= dc) {
      count += countMazePath(sr, sc + 1, dr, dc);
    }
    if (sr + 1 <= dr) {
      count += countMazePath(sr + 1, sc, dr, dc);
    }
    if (sr + 1 <= dr && sc + 1 <= dc) {
      count += countMazePath(sr + 1, sc + 1, dr, dc);
    }
    return count;
  }

  public static int countMazePath_Memo(int sr, int sc, int dr, int dc, int[][] dp) {
    if (sr == dr && sc == dc) {
      return dp[sr][sc] = 1;
    }
    if (dp[sr][sc] != 0) {
      return dp[sr][sc];
    }
    int count = 0;
    if (sc + 1 <= dc) {
      count += countMazePath_Memo(sr, sc + 1, dr, dc, dp);
    }
    if (sr + 1 <= dr) {
      count += countMazePath_Memo(sr + 1, sc, dr, dc, dp);
    }
    if (sr + 1 <= dr && sc + 1 <= dc) {
      count += countMazePath_Memo(sr + 1, sc + 1, dr, dc, dp);
    }
    return dp[sr][sc] = count;
  }

  public static int countMazePath_DP(int SR, int SC, int dr, int dc, int[][] dp) {
    for (int sr = dr; sr >= 0; sr--) {
      for (int sc = dc; sc >= 0; sc--) {
        if (sr == dr && sc == dc) {
          dp[sr][sc] = 1;
          continue;
        }

        int count = 0;
        if (sc + 1 <= dc) {
          count += countMazePath_Memo(sr, sc + 1, dr, dc, dp);
        }
        if (sr + 1 <= dr) {
          count += countMazePath_Memo(sr + 1, sc, dr, dc, dp);
        }
        if (sr + 1 <= dr && sc + 1 <= dc) {
          count += countMazePath_Memo(sr + 1, sc + 1, dr, dc, dp);
        }
        dp[sr][sc] = count;
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
