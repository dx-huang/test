package AbstractFactory;

/**
 * @Author:hdx
 * @Date:2022/5/20 10:30
 * @Description:
 */
public class HuaWeiComputer implements Computer {
    @Override
    public void work() {
        System.out.println("华为电脑工作中...");
    }
}
