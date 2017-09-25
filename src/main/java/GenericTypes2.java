/**
 * Created by li.liu on 2017/9/25.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * 当Java泛型遇见重载
 *
 * 只有使用Sun JDK 1.6的javac编译器才能编译成功
 */
public class GenericTypes2 {

    public static String method(List<String> list){
        System.out.println("invoke method(List<String> list)");
        return "";
    }

    public static int method(List<Integer> list){
        System.out.println("invoke method(List<Integer> list)");
        return 1;
    }

    public static void main(String[] args){
        method(new ArrayList<String>());
        method(new ArrayList<Integer>());
    }

}
