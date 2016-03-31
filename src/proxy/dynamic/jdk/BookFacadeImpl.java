package proxy.dynamic.jdk;

public class BookFacadeImpl implements BookFacade {

    @Override
    public void addBook(String book) {
        System.out.println("----添加图书:"+book);
    }

}
