import java.util.Vector;

/**
 * Created by li.liu on 2017/9/27.
 */
public class VectorTest1 {

    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args){
        while(true){
            for(int i = 0; i < 10; i++){
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for(int i = 0; i < vector.size(); i++){
                            vector.remove(i);
                        }
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector){
                        for(int i = 0; i < vector.size(); i++){
                            System.out.println(vector.get(i));
                        }
                    }

                }
            });

            removeThread.start();
            printThread.start();

            // 不要同时产生过多线程，否则会导致操作系统假死
            while (Thread.activeCount() > 20);
        }
    }

}