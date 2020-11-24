package Easy;

/*
*二维数组查找
* */
public class Solution2DArray {
    public static void main(String[] args) {
        String a="We are you";
        a.replaceAll(" ","%20");
        int[][] aa=new int[3][4];
        System.out.println(aa[1].length);
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row=0;
        int column=matrix[0].length-1;
        while (row<matrix.length&&column>=0){
            if (matrix[row][column]==target){
                return true;
            }
            else if(matrix[row][column]>target){
                column--;
            }
            else{

                row++;
            }
        }
        return false;
    }

}
