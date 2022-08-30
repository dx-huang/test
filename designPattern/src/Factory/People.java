package Factory;

/**
 * @Author:hdx
 * @Date:2022/5/19 18:01
 * @Description:
 */
public class People implements Animal{
    @Override
    public void eat() {
        System.out.println("人吃仙丹");
    }
}
