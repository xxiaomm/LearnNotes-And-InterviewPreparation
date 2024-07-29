package Singleton;

import java.util.Arrays;

/**
 * Double-checked locking, DCL 双重校验锁
 * thread-safe
 */

class Manager03 {
    /**
     * volatile 使得修改值⽴即更新到主程序
     * <p>
     * 双重检测锁模式看上去完美⽆缺，其实是存在问题，在多线程的情况下，可能会出现空指针问题，出现问
     * 题的原因是JVM在实例化对象的时候会进⾏优化和指令重排序操作。
     * 要解决双重检查锁模式带来空指针异常的问题，只需要使⽤ volatile 关键字, volatile 关
     * 键字可以保证可⻅性和有序性。
     */

    // 1, static volatile variable
    private static volatile Manager03 INSTANCE;

    // 2, make constructor be private
    private Manager03() {
    }

    /**
     * 3. static synchronized getInstance method
     * double-checked locking
     *
     * @return
     */
    public static Manager03 getINSTANCE() {
        // 4, make sure thread safe
        if (INSTANCE == null) {
            // t2, t1, t3,
            synchronized (Manager03.class) { // this
                if (INSTANCE == null) {
                    INSTANCE = new Manager03();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Manager03 mgr1 = Manager03.getINSTANCE();
        Manager03 mgr2 = Manager03.getINSTANCE();
        System.out.println(mgr1 == mgr2);  // true
    }
}
