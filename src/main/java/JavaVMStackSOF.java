/**
 * Created by li.liu on 2017/8/30.
 */

/**
 * VM Args: -Xss128K
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try{
            sof.stackLeak();
        }catch (Throwable e){
            System.out.println("Stack length: " + sof.stackLength);
            throw e;
        }
    }
}
