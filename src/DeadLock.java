import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author:hdx
 * @Date:2022/8/30 13:44
 * @Description: 死锁
 */
public class DeadLock {

    private static Logger logger = LoggerFactory.getLogger(DeadLock.class);

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            logger.info(TimeUtils.getNotTimeStr() + "尝试获取lock1");
            synchronized (lock1) {
                logger.info(TimeUtils.getNotTimeStr() + "获取到lock1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info(TimeUtils.getNotTimeStr() + "尝试获取lock2");
                synchronized (lock2) {
                    logger.info(TimeUtils.getNotTimeStr() + "获取到lock2");
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            logger.info(TimeUtils.getNotTimeStr() + "尝试获取lock2");
            synchronized (lock2) {
                logger.info(TimeUtils.getNotTimeStr() + "获取到lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info(TimeUtils.getNotTimeStr() + "尝试获取lock1");
                synchronized (lock1) {
                    logger.info(TimeUtils.getNotTimeStr() + "获取到lock1");
                }
            }
        }, "t2");

        logger.info(TimeUtils.getNotTimeStr() + "主线程运行");
        t1.start();
        t2.start();
    }



}
