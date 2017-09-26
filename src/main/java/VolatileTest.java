/**
 * Created by li.liu on 2017/9/26.
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args){
        Thread[] threads = new Thread[THREAD_COUNT];
        for(int i = 0; i < THREAD_COUNT; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 10000; i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        while (Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(race);
    }
}
