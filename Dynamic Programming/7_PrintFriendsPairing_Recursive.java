import java.util.*;

public class Main{
    public static void main(String[] args){
        System.out.println(printFriends("ABCDEF", ""));
    }
    
    public static long printFriends(String str, String asf){
        if(str.length() == 0){
            System.out.println(asf);
            return 1;
        }
        long count = 0;
        char ch = str.charAt(0);
        count += printFriends(str.substring(1), asf + ch + " ");
        for(int i = 1; i < str.length(); i++){
            String ros = str.substring(1, i) + str.substring(i + 1);
            count += printFriends(ros, asf + ch + str.charAt(i) + " ");
        }
        return count;
    }
}

                          ABCDEF
                          /    \     \     \     \     \
                         A     AB    AC    AD    AE    AF
                    (BCDEF)  (CDEF)(BDEF)(BCEF)(BCDF)(BCDE)
                      | ||||
                      |  \\\\-----------\  
                      |   \\\-------\    \
                      |    \ ---\    \    \
                      |     \    \    \    \
                      |      \    \    \    \
                      /       \    \    \    \
                     B        BC   BD   BE   BF
                   (CDEF)   (DEF)(CEF)(CDF)(CDE)
