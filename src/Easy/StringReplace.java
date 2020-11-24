package Easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * 字符串替换
 *空格-》%20
 */

public class StringReplace {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        
        replaceSpace("you are me");
    }
    public static String replaceSpace(String s) {
        int SpaceLength=0;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]==' '){
                SpaceLength++;
            }
        }
        int newLength=SpaceLength*2+(s.length());
        char[] chars1 = Arrays.copyOf(chars, newLength);
        int indexOrigin=s.length()-1;
        int indexNex=newLength-1;
        while (indexOrigin>=0&&indexNex>indexOrigin){
            if (chars1[indexOrigin]==' '){
                chars1[indexNex--]='0';
                chars1[indexNex--]='2';
                chars1[indexNex--]='%';
            }else {
                chars1[indexNex--]=chars1[indexOrigin];
            }
            --indexOrigin;
        }
        return new String(chars1);
    }
}
