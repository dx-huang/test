import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class test {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final A a1 = new A(1,"a1");
    private static final A a2 = new A(2,"a2");


    @Test
    public void test() {
        new Thread(()->{
            synchronized (a1) {
                logger.info("t1获取到a1");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a2) {
                    logger.info("t1获取到a2");
                }
            }
        },"t1").start();

        new Thread(()->{
            synchronized (a2) {
                logger.info("t2获取到a2");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a1) {
                    logger.info("t2获取到a1");
                }
            }
        },"t2").start();
    }

}
