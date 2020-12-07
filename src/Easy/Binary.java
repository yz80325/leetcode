package Easy;

public class Binary {
    public static void main(String[] args) {
        System.out.println(NumberOf1(12));
    }
    private static int NumberOf1(int n){
        int count=0;
        while (n!=0){
            ++count;
            n=(n-1)&n;
        }
        return count;
    }
}
