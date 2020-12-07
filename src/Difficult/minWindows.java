package Difficult;

import java.util.HashMap;
import java.util.Map;

/*
 * 滑动窗口模板
 * 力扣76
 * */
public class minWindows {

    public static void main(String[] args) {

        String a = minWindow("ADOBECODEBANC","ABC");
        System.out.println(a);
    }


    public static String minWindow(String s, String t) {
        //存储需要的数据（A:2,B:1,C:1）
        HashMap<Character, Integer> need = new HashMap<>();
        //窗口包括的数据
        HashMap<Character, Integer> window = new HashMap<>();
        //字符串转为char
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        //遍历过得符合要求的个数
        int valid = 0;
        //记录长度
        int len = Integer.MAX_VALUE;
        int start = 0;
        boolean changed=false;
        //判断是否到边界
        int a=s.length();
        while (right < s.length()) {
            //c是移入窗口的字符
            char c = s.charAt(right);
            //右移
            right++;
            //进行窗口内数据的更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c)== need.get(c)) {
                    valid++;
                }
            }
            //左侧窗口缩(此时已经获取到全部字符)
            while (valid == need.size()) {
                //更新最小字符串长度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                    changed=true;
                }
                //移除窗口的字符
                char d = s.charAt(left);
                left++;
                //进行数据更新
                if (need.containsKey(d)) {
                    //Intenger是包装类，必须用equals
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.replace(d, window.get(d) - 1);
                }
            }
        }
        return changed ? s.substring(start,start+len) : "";
    }
}
