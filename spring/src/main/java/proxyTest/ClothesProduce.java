package proxyTest;

/**
 * @Author:hdx
 * @Date:2021/10/26 9:57
 * @Description:
 */
public interface ClothesProduce {
    void produce();
}

class ATClothesProduce implements ClothesProduce{

    @Override
    public void produce() {
        System.out.println("AT工厂正在生产衣服");
    }
}


