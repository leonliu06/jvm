import java.util.List;

/**
 * Created by li.liu on 2017/9/25.
 */

/**
 * 当Java泛型遇见重载
 */
public class GenericTypes1 {
    public static void method(List<String> list){
        System.out.println("invoke method(List<String> list)");
    }

    public static void method(List<Integer> list){
        System.out.println("invoke method(List<Integer> list)");
    }
}
