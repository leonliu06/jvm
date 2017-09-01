/**
 * Created by li.liu on 2017/8/30.
 */

/**
 *
 * 这段代码在JDK 1.6中运行，会得到两个false，而在JDK 1.7中运行，会得到一个true和一个false。
 * 产生的原因是：
 *
 */
public class RuntimeConstantPoolOOM1 {
    public static void main(String[] args){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
