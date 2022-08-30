package Factory;

/**
 * @Author:hdx
 * @Date:2022/5/19 18:00
 * @Description:
 */
public class Pig implements Animal {
    @Override
    public void eat() {
        System.out.println("猪吃泔水");
    }
}
