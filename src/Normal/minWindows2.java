package Normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* 力扣
* 438
* */
public class minWindows2 {
    public List<Integer> findAnagrams(String s, String p) {
        //结果
        List<Integer> reg=new ArrayList<>();
        HashMap<Character,Integer> window=new HashMap<>();
        HashMap<Character,Integer> need=new HashMap<>();
        for (Character c:p.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int vaild=0;
        while (right<p.length()){
            char c=s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    vaild++;
                }
            }
            //判断左侧
            if (right-left>=p.length()){
                if (vaild==need.size()){
                    reg.add(left);
                }
                char d=s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        vaild--;
                    }
                    window.replace(d,window.get(d)-1);
                }
            }
        }
        return reg.size()==0?null:reg;
    }
}
