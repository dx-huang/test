import AbstractFactory.Computer;
import AbstractFactory.HuaWeiFactory;
import AbstractFactory.Phone;
import AbstractFactory.XiaoMiFactory;
import Factory.Animal;
import Factory.AnimalFactory;

/**
 * @Author:hdx
 * @Date:2022/5/19 17:19
 * @Description:
 */
public class DesignPatternTest {

    public static void main(String[] args) {
        XiaoMiFactory factory = new XiaoMiFactory();
        Phone phone = factory.producePhone();
        Computer computer = factory.produceComputer();
        phone.call();
        phone.sendMsg();
        computer.work();
    }
}
