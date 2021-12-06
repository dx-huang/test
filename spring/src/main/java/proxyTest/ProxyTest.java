package proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:hdx
 * @Date:2021/10/26 9:34
 * @Description: 动态代理
 */

class ProxyFactory {

    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }

}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
       return method.invoke(obj, args);
    }
}



public class ProxyTest {
    public static void main(String[] args) {
        Human human =  (Human)ProxyFactory.getProxyInstance(new Superman());
        String belief = human.belief();
        System.out.println(belief);
        human.eat("小怪兽");

        ClothesProduce clothesProduce = (ClothesProduce) ProxyFactory.getProxyInstance(new ATClothesProduce());
        clothesProduce.produce();


    }

}
