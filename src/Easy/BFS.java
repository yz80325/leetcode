package Easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
* 广度优先级
* BFS
* */
public class BFS {

    /*
    * @Param graph 构造图
    * @Param dist 记录每个顶点离起始点的距离，也即最短距离
    * @Param start 开始点
    *
    * */
    private static void BFS(HashMap<Character, LinkedList<Character>> graph,HashMap<Character,Integer>dist,char start)
    {
        //记录走过的节点
        Queue<Character> queue=new LinkedList<>();
        queue.add(start);
        dist.put(start,0);
        while (!queue.isEmpty()){
            char top=queue.poll();
            System.out.println("The th element:" + top + " Distance from s is:" + dist.get(top));
            int d = dist.get(top) + 1;// 得出其周边还未被访问的节点的距离
            for (Character c : graph.get(top)) {
                if (!dist.containsKey(c))// 如果dist中还没有该元素说明还没有被访问
                {
                    dist.put(c, d);
                    queue.add(c);
                }
            }
        }

    }
}
