/**
 * Created by li.liu on 2017/8/30.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存举出异常
 *
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 在JDK 1.6及之前的版本中，由于常量池分配在永久代内，我们可以通过以上参数限制方法区大小，从而间接限制其中常量池的容量.
 * 在JDK 1.6中运行结果：Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
 * 在OutOfMemoryError后面跟随的揭示信息是“PermGen Space”，说明运行常量池属于方法区（HotSpot虚拟机中的永久代）的一部分。
 *
 * 而使用JDK 1.7(去永久代)运行这段程序就不会得到相同的结果，while循环将一直进行下去。
 *
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
