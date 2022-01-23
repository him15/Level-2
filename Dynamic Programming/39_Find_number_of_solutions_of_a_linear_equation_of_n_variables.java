https://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int amt = sc.nextInt();
    System.out.println(linearEqu(arr, amt, 0, new int[n], amt));
  }
  
  public static int linearEqu(int[] arr, int tar, int idx, int[] coeff, int oTar) {
    if(tar == 0){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "(" + coeff[i] + ")");
            if(i != arr.length - 1){
                System.out.print(" + ");
            }
        }
        System.out.println(" = " + oTar);
        return 1;
    }
    int count = 0;
    for(int i = idx; i < arr.length; i++){
        if(tar - arr[i] >= 0){
            coeff[i]++;
            count += linearEqu(arr, tar - arr[i], i, coeff, oTar);
            coeff[i]--;
        }
    }
    return count;
  }
}
