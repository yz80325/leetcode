package Easy;

import java.util.Arrays;

public class SortAgeTest {
        public static void main(String[] args) {

            int[] ages = new int[] { 23, 45, 32, 43, 21, 24, 25, 23, 22, 22, 21 };
            System.out.println("原数组为：" + Arrays.toString(ages));
            sortAge(ages);
            System.out.println("排序后的数组为：" + Arrays.toString(ages));
        }

        private static void sortAge(int[] ages) {
            if (ages==null||ages.length==0){
                return;
            }
            int maxOld=99;
            //记录次数
            int[] timeOfOld=new int[maxOld+1];
            Arrays.fill(timeOfOld,0);
            for (int i=0;i<ages.length;i++){
                int aa=ages[i];
                timeOfOld[aa]++;
            }
            int index=0;
            for (int j=0;j<=maxOld;j++){
                for (int k=0;k<timeOfOld[j];k++){
                    ages[index]=j;
                    index++;
                }
            }
        }

}
