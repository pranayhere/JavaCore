import java.util.Arrays;

public class FindMax {
    public static void main(String arg[]){
        int[] a = {};

        Integer max = null;
        Integer secondMax = null;


        if(a != null && a.length != 0){

            Arrays.sort(a);
            max = a[a.length - 1];
            for(int i = a.length - 2; i >=0; i--){
                if(a[i] != max){
                    secondMax = a[i];
                    break;
                }
            }
        }


        System.out.println("max = "+max);
        System.out.println("second max = " + secondMax);

    }
}
