package proxyTest;

/**
 * @Author:hdx
 * @Date:2021/10/26 9:45
 * @Description:
 */
public interface Human {
    String belief();
    void eat(String food);
}

class Superman implements Human{

    @Override
    public String belief() {
        return "I believe i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我爱吃" + food);
    }
}
