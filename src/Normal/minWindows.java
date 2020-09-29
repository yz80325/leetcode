package Normal;


import java.util.HashMap;

/*
* checkInclusion
* 力扣567
* */
public class minWindows {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","ccbaoo"));

    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> window=new HashMap<>();
        HashMap<Character,Integer> need=new HashMap<>();
        for (Character c:s1.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int vaild=0;
        while (right<s2.length()){
            char c1=s2.charAt(right);
            right++;
            //对窗口数据进行判断
            if (need.containsKey(c1)){
                window.put(c1,window.getOrDefault(c1,0)+1);
                if (window.get(c1).equals(need.get(c1))){
                    vaild++;
                }
            }
            //判断左侧
            if (right-left>=s1.length()){
                if (vaild==need.size()){
                    return true;
                }
                char d=s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        vaild--;
                    }
                    window.replace(d,window.get(d)-1);
                }
            }
        }
        return false;
    }
}
