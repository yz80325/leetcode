package Normal;


import java.util.HashMap;

/*
* 力扣
* 3
* */
public class minWindows3 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> window=new HashMap<>();
        int left=0,right=0;
        int res=0;
        while (right<s.length()){
            char c=s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            //当有重复的
            while (window.get(c)>1){
                char l=s.charAt(left);
                left++;
                window.replace(l,window.get(l)-1);
            }
            //在这里更新
            res=Math.max(res,right-left);
        }
        return res;
    }
}
