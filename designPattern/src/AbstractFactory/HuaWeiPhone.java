package AbstractFactory;

/**
 * @Author:hdx
 * @Date:2022/5/20 10:27
 * @Description:
 */
public class HuaWeiPhone implements Phone {
    @Override
    public void call() {
        System.out.println("华为手机打电话...");
    }

    @Override
    public void sendMsg() {
        System.out.println("华为手机发送短信...");
    }
}
