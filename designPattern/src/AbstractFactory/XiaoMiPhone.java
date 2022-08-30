package AbstractFactory;

/**
 * @Author:hdx
 * @Date:2022/5/20 10:26
 * @Description:
 */
public class XiaoMiPhone implements Phone  {
    @Override
    public void call() {
        System.out.println("小米手机打电话...");
    }

    @Override
    public void sendMsg() {
        System.out.println("小米手机发送短信...");
    }
}
