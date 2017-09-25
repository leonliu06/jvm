package leon.classloading.execute;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by leon on 2017/9/24.
 */

/**
 * 为JavaClass劫持java.lang.System提供支持
 * 除了out和err外，其余的都直接转发给System处理
 */
public class HackSystem {

    public final static InputStream in = System.in;

    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public final static PrintStream out = new PrintStream(buffer);

    public static String getBufferString(){
        return buffer.toString();
    }

    public static void clearBuffer(){
        buffer.reset();
    }

    public static void setSecurityManager(final SecurityManager s){
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager(){
        return System.getSecurityManager();
    }

    public static long currenTimeMillis(){
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length){
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    public static int identifyHashCode(Object x){
        return System.identityHashCode(x);
    }


}
