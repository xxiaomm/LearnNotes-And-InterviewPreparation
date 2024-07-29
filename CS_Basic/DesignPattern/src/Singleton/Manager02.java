package Singleton;

/**
 * lazy loading 懒汉式
 * not thread-safe & thread-safe
 */

class Manager02 {
    // static: only one instance, final: can not be changed
    private static Manager02 INSTANCE;

    private Manager02() {
    }

    /**
     * not thread-safe
     * multiple thread access function, may new multiple instances
     */
    public static Manager02 getINSTANCE1() {
        if (INSTANCE == null) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            INSTANCE = new Manager02();
        }
        return INSTANCE;
    }

    /**
     * thread-safe, but based on method-level -> high overhead, low efficiency
     */
    public static synchronized Manager02 getINSTANCE2() {
        if (INSTANCE == null) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            INSTANCE = new Manager02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World! 你好，世界！");
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Manager02.getINSTANCE1().hashCode());
            }).start();
            // 匿名内部类，lambda是针对只有一个方法的匿名内部类/借口，runnable是一个interface
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            }).start();
        }
    }
}