import java.util.concurrent.ExecutionException;

import java.util.concurrent.FutureTask;

public class Text1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task =new FutureTask<>(()->{
            Thread.sleep(2000);
            return 1;
            });
        Thread t =new Thread(task);
        System.out.println(task.isDone());
        t.start();
        System.out.println(task.get());
    }
}
