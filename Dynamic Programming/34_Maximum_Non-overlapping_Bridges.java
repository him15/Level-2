import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(nonOverlappingBridges(arr));
    }
    
    public static int nonOverlappingBridges(int[][] arr){
        Arrays.sort(arr, (a, b) -> {
            return a[0] - b[0]; // this - other, default behaviour.
            // return b[0] - a[0]; // other - this, reverse default behaviour.
        });
        
        int n = arr.length;
        int ans = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
