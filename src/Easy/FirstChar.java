package Easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class FirstChar {
    public static void main(String[] args) {
        System.out.println(FirstChar1("ashwyagujkasdhj"));
    }
    private static String FirstChar1(String a){
        char[] chars = a.toCharArray();
        Map<Character,Integer>map=new LinkedHashMap<>();
        Character res=null;
        for (int i=0;i<chars.length;i++){
            if (map.containsKey(chars[i])){
                map.replace(chars[i],map.get(chars[i])+1);
            }else {
                map.put(chars[i],1);
            }

        }

       Set<Character> characters = map.keySet();
        for(Character character:characters){
            if (map.get(character)==1){
                res=character;
                break;
            }
        }
        return String.valueOf(res);
    }
}
