package proxy.dynamic.cglib;
/**
 * 没有实现接口的类
 * @Title: BookFacade.java
 * @Description: <br>
 *               <br>
 * @Created on 2016年3月2日 上午10:39:21
 * @author yangkai
 * @version 1.0
 */
public class BookFacadeClass {

    public void updateBook(String book){
        System.out.println("----更新图书:"+book);
    }
}
