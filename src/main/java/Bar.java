/**
 * Created by li.liu on 2017/9/4.
 */
public class Bar {
    int a = 1;
    static int b = 2;
    public int sum(int c){
        return a + b + c;
    }

    public static void main(String[] args){
        new Bar().sum(3);
    }
}
