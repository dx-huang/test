package AbstractFactory;

/**
 * @Author:hdx
 * @Date:2022/5/20 10:35
 * @Description:
 */
public class HuaWeiFactory implements AbstractFactory {
    @Override
    public Phone producePhone() {
        return new HuaWeiPhone();
    }

    @Override
    public Computer produceComputer() {
        return new HuaWeiComputer();
    }
}
