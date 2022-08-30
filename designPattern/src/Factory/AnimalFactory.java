package Factory;

/**
 * @Author:hdx
 * @Date:2022/5/19 18:02
 * @Description:
 */
public class AnimalFactory {

    public static Animal getInstance(String clazz) {
        if (clazz == null) return null;
        if (clazz.equals("Pig")) {
            return new Pig();
        }else if (clazz.equals("Dog")) {
            return new Dog();
        }else if (clazz.equals("People")) {
            return new People();
        }
        return null;
    }
}
