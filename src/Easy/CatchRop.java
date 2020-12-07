package Easy;

/**
 * 剑指offer
 * 剪绳子
 */
public class CatchRop {
    public static void main(String[] args) {

        String s = Integer.toBinaryString(-4 );
        System.out.println(s);
        System.out.println(Integer.valueOf("100",2).toString());
        //System.out.println(maxCuttingRop(8));
    }
    private static int maxCuttingRop(int length){
        if (length<2)
            return 0;
        if (length==2)
            return 1;
        if (length==3)
            return 2;
        int[] products=new int[length+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;
        int max=0;
        for (int rop_length=4;rop_length<=length;++rop_length){
            //重置
            max=0;
            for (int j=1;j<=rop_length/2;++j){
                int product = products[j] * products[rop_length - j];
                if (max<product)
                    max=product;
                products[rop_length]=max;
            }
        }
        max=products[length];
        return max;
    }
}
