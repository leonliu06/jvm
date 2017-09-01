/**
 * Created by li.liu on 2017/8/30.
 */

/**
 * VM Args: -Xss100M
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while (true){}
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
