import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        int[] dp = new int[tar + 1];
        // Arrays.fill(dp, -1);
        // System.out.println(coinChangePer_Recursive(arr, tar));
        // System.out.println(coinChangePer_Memo(arr, tar, dp));
        System.out.println(coinChangePer_DP(arr, tar, dp));
    }
    
    public static int coinChangePer_Recursive(int[] arr, int tar){
        if(tar == 0){
            return 1;
        }
        int count = 0;
        for(int coin : arr){
            if(tar - coin >= 0){
                count += coinChangePer_Recursive(arr, tar - coin);
            }
        }
        return count;
    }
    
    public static int coinChangePer_Memo(int[] arr, int tar, int[] dp){
        if(tar == 0){
            return dp[tar] = 1;
        }
        if(dp[tar] != -1){
            return dp[tar];
        }
        int count = 0;
        for(int coin : arr){
            if(tar - coin >= 0){
                count += coinChangePer_Memo(arr, tar - coin, dp);
            }
        }
        return dp[tar] = count;
    }
    
    public static int coinChangePer_DP(int[] arr, int Tar, int[] dp){
        dp[0] = 1;
        for(int tar = 1; tar <= Tar; tar++){
            for(int coin : arr){
                if(tar - coin >= 0){
                    dp[tar] += dp[tar - coin];  //coinChangePer_Memo(arr, tar - coin, dp);
                }
            }
        }
        return dp[Tar];
    }
}
