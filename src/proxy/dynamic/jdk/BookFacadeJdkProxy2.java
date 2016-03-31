package proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * JDK 动态代理   缺点：只能代理实现了接口的类
 * @Title: BookFacadeJDKProxy.java
 * @Description: <br>
 *               <br>
 * @Created on 2016年3月2日 上午10:29:43
 * @author yangkai
 * @version 1.0
 */
public class BookFacadeJdkProxy2 implements InvocationHandler {

    private Object target; // 代理对象

    
    public BookFacadeJdkProxy2(Object target) {
        super();
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        before();
        result = method.invoke(target, args);
        after();
        return result;
    }

    public void before() {
        System.out.println("----开启事务---");
    }

    public void after() {
        System.out.println("----结束事务---");
    }
}
