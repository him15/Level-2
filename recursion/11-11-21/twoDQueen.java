import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] box = new boolean[n][n];
    int totalQ = scn.nextInt();
    
    // System.out.println(twodQueen_permutation1(box, totalQ, 0, ""));
    System.out.println(twodQueen_combination1(box, totalQ, 0, "", 0));
    // System.out.println(onedQueen_combination1(box, totalQ, 0, "", 0));
    // System.out.println(onedQueen_combination2(box, totalQ, 0, "", 0));
    
  }

  public static int twodQueen_permutation1(boolean[][] box, int totalQ, int qpsf, String asf){
    // write your code here
    int n = box.length;
    if(qpsf==totalQ){
        System.out.println(asf);
        return 1;
    }
    int count=0;
    for(int i=0; i<n*n; i++){
        int r = i/n;
        int c = i%n;
        if(!box[r][c]){
            box[r][c]=!box[r][c];
            count += twodQueen_permutation1(box, totalQ, qpsf+1, asf+ "("+r+" ,"+c+") ");
            box[r][c]=!box[r][c];
        }
    }
    return count;
  }
  
  public static int twodQueen_combination1(boolean[][] box, int totalQ, int qpsf, String asf, int idx){
    // write your code here
    int n = box.length;
    if(qpsf==totalQ){
        System.out.println(asf);
        return 1;
    }
    int count=0;
    for(int i=idx; i<n*n; i++){
        int r = i/n;
        int c = i%n;
        if(!box[r][c]){
            box[r][c]=!box[r][c];
            count += twodQueen_combination1(box, totalQ, qpsf+1, asf+ "("+r+" ,"+c+")->"+"Q"+qpsf+" ", i+1);
            box[r][c]=!box[r][c];
        }
    }
    return count;
  }  
}
