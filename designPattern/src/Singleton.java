/**
 * @Author:hdx
 * @Date:2022/5/19 17:13
 * @Description: 单例模式
 */
public class Singleton {

    //懒汉 线程不安全
//    private static  Singleton singleton;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    //饿汉 线程安全 可能造成资源浪费
//    private static final Singleton singleton = new Singleton();
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        return singleton;
//    }


    //懒汉 双锁 线程安全
    private volatile static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
