package proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * cglib 动态代理  代理类无需实现接口
 * 原理：对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理
 * @Title: BookFacadeCglibProxy.java
 * @Description: <br>
 *               <br>
 * @Created on 2016年3月2日 上午10:31:38
 * @author yangkai
 * @version 1.0
 */
public class BookFacadeCglibProxy implements MethodInterceptor{
    
    private Object target;  //代理对象
    
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);  //回调方法
        return enhancer.create();  //创建代理对象
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        proxy.invokeSuper(obj, args);
        after();
        return null;
    }
    public void before() {
        System.out.println("----开启事务---");
    }

    public void after() {
        System.out.println("----结束事务---");
    }
}
