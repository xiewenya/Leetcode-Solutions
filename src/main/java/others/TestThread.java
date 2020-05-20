package others;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/15
 * @content:
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        System.out.println(thread.getState());

        thread.start();

        System.out.println(thread.getState());

        thread.join();

        System.out.println(thread.getState());
    }

}
