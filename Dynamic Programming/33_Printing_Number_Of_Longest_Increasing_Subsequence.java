class Solution {
    int m = 0;
    // LIS
    public int LIS_LR_DP(int[] arr, int[] dp){
        int n = arr.length;
        int[] count = new int[n];
        
        int maxLen = 0;
        int maxCount = 0;
        
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            count[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxCount = count[i];
                m = maxLen;
            }
            else if(dp[i] == maxLen){
                maxCount += count[i];
            }
        }
        return maxCount;
    }
    
    public void printNumberofLIS(int[] arr, HashMap<Integer, ArrayList<Integer>> map, int idx, int count, String asf){
        if(count == 1){
            System.out.println(asf + "]");
            return;
        }
        if(map.containsKey(count - 1)){
            ArrayList<Integer> list = map.get(count - 1);
            for(Integer i : list){
                if(i < idx && arr[i] < arr[idx]){
                    printNumberofLIS(arr, map, i, count - 1, asf + arr[i] + " ");
                }
            }
        }
    }
    
    
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int lis = LIS_LR_DP(arr, dp);
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(dp[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(dp[i], list);
            }else{
                ArrayList<Integer> list = map.get(dp[i]);
                list.add(i);
                map.put(dp[i], list);
            }
        }
        
        ArrayList<Integer> list = map.get(m);
        for(int i = 0; i < list.size(); i++){
            int idx = list.get(i);
            printNumberofLIS(arr, map, idx, m, "[" + arr[idx] + " ");
        }
         
        
        return lis;
    }
}
