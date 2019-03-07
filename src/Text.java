import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Text {
    public static void main(String[] args) throws InterruptedException {

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // =Executors.newScheduledThreadpool
        //executorService.scheduled(r,3,TimeUnit.Seconds);线程池中的线程会延迟3秒执行.

        Runnable r = () -> concurrentHashMap.merge("Tom",1,Integer::sum);
                                    //将"Tom"所对的值进行后面的操作，如果没有就加进去一个，值为默认

        for (int i = 0; i < 1000; i++) {
            executorService.submit(r);
        }

        Thread.sleep(2000);
        executorService.shutdown();

        System.out.println(concurrentHashMap.get("Tom"));


    }
}
