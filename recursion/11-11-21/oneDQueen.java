import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[] box = new boolean[n];
    int totalQ = scn.nextInt();
    
    // System.out.println(onedQueen_permutation1(box, totalQ, 0, ""));
    System.out.println(onedQueen_permutation2(box, totalQ, 0, "", 0));
    // System.out.println(onedQueen_combination1(box, totalQ, 0, "", 0));
    // System.out.println(onedQueen_combination2(box, totalQ, 0, "", 0));
    
  }

  public static int onedQueen_permutation1(boolean[] box, int totalQ, int qpsf, String asf){
    // write your code here
    if(qpsf==totalQ){
        System.out.println(asf);
        return 1;
    }
    int count=0;
    for(int i=0; i<box.length; i++){
        if(!box[i]){
            box[i]=!box[i];
            count += onedQueen_permutation1(box, totalQ, qpsf+1, asf+ "b"+i+"q"+qpsf+" ");
            box[i]=!box[i];
        }
    }
    return count;
  }
  
  public static int onedQueen_permutation2(boolean[] box, int totalQ, int qpsf, String asf, int idx){
    // write your code here
    if(qpsf==totalQ){
        System.out.println(asf);
        return 1;
    }
    if(idx==box.length)
        return 0;
    int count=0;
    if(!box[idx]){
        box[idx]=!box[idx];
        count += onedQueen_permutation2(box, totalQ, qpsf+1, asf+ "b"+idx+"q"+qpsf+" ", 0);
        box[idx]=!box[idx];
    }
    count += onedQueen_permutation2(box, totalQ, qpsf, asf, idx+1);
    return count;
  }
  
  public static int onedQueen_combination1(boolean[] box, int totalQ, int qpsf, String asf, int idx){
    // write your code here
    if(qpsf==totalQ){
        System.out.println(asf);
        return 1;
    }
    int count=0;
    for(int i=idx; i<box.length; i++){
        if(!box[i]){
            box[i]=!box[i];
            count += onedQueen_combination1(box, totalQ, qpsf+1, asf+ "b"+i+"q"+qpsf+" ", i+1);
            box[i]=!box[i];
        }
    }
    return count;
  }
  public static int onedQueen_combination2(boolean[] box, int totalQ, int qpsf, String asf, int idx){
    // write your code here
    if(qpsf==totalQ){
        System.out.println(asf);
        return 1;
    }
    if(idx==box.length)
        return 0;
    int count=0;
    if(!box[idx]){
        box[idx]=!box[idx];
        count += onedQueen_combination2(box, totalQ, qpsf+1, asf+ "b"+idx+"q"+qpsf+" ", idx+1);
        box[idx]=!box[idx];
    }
    count += onedQueen_combination2(box, totalQ, qpsf, asf, idx+1);
    return count;
  }
  
}

