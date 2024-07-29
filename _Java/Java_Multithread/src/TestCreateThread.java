import java.util.concurrent.*;

/**
 * @Create 06/26/2024 - 14:22
 * @Author xiao
 * @Description TODO
 */

public class TestCreateThread {
    public static void main(String[] args) {
        /**
         * run() is a method of class MyRunnable, this process is to call method,
         * must finish run(), then main method could continue
         */
        MyRunnable rThread = new MyRunnable();
        rThread.run();
        /**
         * must use thread.start() to ensure create a thread and start
         */
        Thread t = new Thread(rThread);
        t.start();

        MyThread th = new MyThread();
        th.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread ---- : " + i);
        }

        MyCallable cThread = new MyCallable();
        FutureTask<String> task = new FutureTask<>(cThread);
        Thread thread = new Thread(task);
        thread.start();
        try {
            System.out.println(task.get()); // 打印Callable的返回值
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        /**
         * 4. ExecutorService
         */
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread from ExecutorService is running...");
                }
            });
        }

        executor.shutdown();

    }

}


/**
 * 1. extends Thread class
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread: " + i);
        }
    }
}

/**
 * 2. implements Runnable interface
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyRunnable: " + i);
        }
    }
}

/**
 * 3. implements Callable<> interface
 */
class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Start new thread using Callable";
    }
}