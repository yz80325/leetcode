package Normal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
*752. 打开转盘锁
*
* */
public class BFS {

    public static void main(String[] args) {
        String[] a=new String[]{"0000"};
        openLock(a,"0001");
    }

    /*
    * @Param s:现在的密码
    * @Param k:滚动的位置
    * 加一
    * */
    private static String plusOne(String s,int k){
        char[] chars=s.toCharArray();
        if (chars[k]=='9'){
            chars[k]='0';
        }else {
            chars[k]+=1;
        }
        return new String(chars);
    }

    /*
     * @Param s:现在的密码
     * @Param k:滚动的位置
     * 减一
     * */
    private static String minusOne(String s,int k){
        char[] chars=s.toCharArray();
        if (chars[k]=='9'){
            chars[k]='0';
        }else {
            chars[k]-=1;
        }
        return new String(chars);
    }

    public static int openLock(String[] deadends, String target) {
        //记录死亡数字
        Set<String> dead=new HashSet<>();
        for (String d:deadends){
            dead.add(d);
        }
        //记录访问过的数据
        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        //记录步数
        int step=0;
        //记录起点
        visited.add("0000");
        q.add("0000");
        while (!q.isEmpty()){
            int sz=q.size();
            //扩散代码
            for (int i=0;i<sz;i++){
                String cur=q.poll();
                //判断是否到终点
                if (dead.contains(cur)){
                    continue;
                }
                if (cur.equals(target)){
                    return step;
                }
                //将一个节点未遍历相邻节点加入
                for (int j=0;j<4;j++){
                    String up=plusOne(cur,j);
                    if (!visited.contains(up)){
                        q.add(up);
                        visited.add(up);
                    }
                    String down=minusOne(cur,j);
                    if (!visited.contains(down)){
                        q.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
