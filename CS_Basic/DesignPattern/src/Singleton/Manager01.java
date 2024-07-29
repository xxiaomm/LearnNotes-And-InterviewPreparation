package Singleton;

/**
 * Eager loading 饿汉式，推荐使用
 * 类加载到内存后，就实例化一个Singleton，JVM保证线程安全。
 * adv: simple, thread-safe, good performance without any synchronization check due to created at class loading time
 * dis-adv：resource consumption(不管用到与否，类装载时就完成实例化)。
 * Class.forName("") 加载到内存，但不实例化
 */


class Manager01 {
    /**
     * static: only one instance,
     * final: can not be changed
     */

    private static final Manager01 INSTANCE = new Manager01();
    // or this way to new instance
//    static {
//        INSTANCE = new Manager01();
//    }

    /**
     * constructor should be private, nobody could new a instance.
     */
    private Manager01() {
    }

    // make others could get the instance
    public static Manager01 getINSTANCE() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Manager01 mgr1 = Manager01.getINSTANCE();
        Manager01 mgr2 = Manager01.getINSTANCE();
        System.out.println(mgr1 == mgr2);  // true
    }
}