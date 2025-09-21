package HW1;

public class FunctionGrowth {
    public static void main(String[] args) {
        for(int i = 2; i <= 2048; i*=2){
            int lnn = (int)Math.log(i);
            int n = i;
            int nlogn = (int)(n*Math.log(i));
            int n2 = i*i;

            System.out.println( lnn + "\t" + n + "\t" + nlogn + "\t" + n2 + "\t" + (long)i*i*i);
        }
    }
}
