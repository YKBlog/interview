package proxy.dynamic;


import org.junit.Test;

import proxy.dynamic.cglib.BookFacadeCglibProxy;
import proxy.dynamic.cglib.BookFacadeClass;
import proxy.dynamic.jdk.BookFacade;
import proxy.dynamic.jdk.BookFacadeImpl;
import proxy.dynamic.jdk.BookFacadeJdkProxy1;
import proxy.dynamic.jdk.BookFacadeJdkProxy2;

public class BookFacadeTest {

    /**
     * 测试jdk代理1
     */
    @Test
    public void testJdk1() {
        BookFacadeJdkProxy1 proxy = new BookFacadeJdkProxy1();
        BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookFacade.addBook("JAVA分布式");
    }
    /**
     * 测试jdk代理2
     */
    @Test
    public void testJdk2() {
        BookFacade bookFacade = new BookFacadeImpl();
        BookFacadeJdkProxy2 handler = new BookFacadeJdkProxy2(bookFacade);
        BookFacade proxy = (BookFacade)handler.getProxy();
        proxy.addBook("JAVA分布式");
    }

    /**
     * 测试cglib代理
     */
    @Test
    public void testCglib() {
        BookFacadeCglibProxy proxy = new BookFacadeCglibProxy();
        BookFacadeClass bookFacadeClass = (BookFacadeClass) proxy.getInstance(new BookFacadeClass());
        bookFacadeClass.updateBook("疯狂JAVA");
    }
    
}
