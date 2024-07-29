import java.util.Date;

/**
 * @Create 06/26/2024 - 15:12
 * @Author xiao
 * @Description TODO
 */

public class TestMethods {
    public static void main(String[] args) {
//        MyThread1 thread = new MyThread1();
//        thread.start();
//
//       try{Thread.sleep(10000);}
//       catch (InterruptedException e) {}
//       thread.interrupt();  // 非常粗暴，stop()更粗暴，轻易不要用。

//        MyThread2 t2 = new MyThread2("t2");
//        t2.start();
//        /**
//         * join()：将线程t2的内容合并到main thread, 所以main必须等待t2执行结束
//         */
//        try {
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        for (int i=0; i<10; i++) {
//            System.out.println("I am main thread");
//        }

        MyThread3 t3 = new MyThread3("t31");
        MyThread3 t33 = new MyThread3("t32");
        t3.start();
        t33.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("I am main thread");
        }
    }
}

class MyThread1 extends Thread {
    boolean flag = true;

    public void run() {
        while (true) {
            System.out.println("=== : " + new Date() + " ===");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}

class MyThread2 extends Thread {
    // 给当前thread起一个String类型的名字调用父类constructor，
    MyThread2(String s) {
        super(s);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("I am : " + getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}

class MyThread3 extends Thread {
    MyThread3(String s) {
        super(s);
    }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("I am : " + getName() + ", i: " + i);
            if (i % 10 == 0) {
                Thread.yield();
            }

        }
    }
}