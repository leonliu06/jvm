import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 2017/9/25.
 */
public class Box {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        int sum = 0;
        for(int i : list){
            sum += i;
        }

        System.out.println(sum);
    }

}
