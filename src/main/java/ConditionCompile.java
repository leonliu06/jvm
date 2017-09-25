/**
 * Created by leon on 2017/9/25.
 */
public class ConditionCompile {

    public static void main(String[] args){

        /**
         * 生成的字节码中只包含“System.out.println("block 1");”一条语句
         */
        if(true){
            System.out.println("block 1");
        }else{
            System.out.println("block 2");
        }

        /**
         * Unreachable Statement
         */
//        while(false){
//            System.out.println("");
//        }
    }
}
