import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by leon on 2017/9/25.
 */
public class Box1 {
    public static void main(String[] args){
        List list = Arrays.asList(new Integer[]{
                Integer.valueOf(1),
                Integer.valueOf(2),
                Integer.valueOf(3),
                Integer.valueOf(4)
        });

        int sum = 0;
        for(Iterator localIterator = list.iterator(); localIterator.hasNext();){
            int i = ((Integer)localIterator.next()).intValue();
            sum += i;
        }

        System.out.println(sum);
    }
}
