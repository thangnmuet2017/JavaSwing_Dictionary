import java.util.ArrayList;
import java.util.Collections;

public class Tri01 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            list.add(10*i);
        }

        System.out.println( Collections.binarySearch(list,30) );
    }
}
