package AbstractFactory;

/**
 * @Author:hdx
 * @Date:2022/5/20 10:31
 * @Description:
 */
public class XiaoMiFactory implements AbstractFactory{

    @Override
    public Phone producePhone() {
        return new XiaoMiPhone();
    }

    @Override
    public Computer produceComputer() {
        return new XiaoMiComputer();
    }
}
