import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by li.liu on 2017/9/28.
 */
public class AtomicTest {

    private static AtomicInteger race = new AtomicInteger(0);

    private static void increase(){
        race.incrementAndGet();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args){
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i = 0; i < THREADS_COUNT; i++){
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
        while(Thread.activeCount() > 1) Thread.yield();
        System.out.println(race.get());
    }
}
