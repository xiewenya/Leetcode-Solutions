package others;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/18
 * @content:
 */
public class ThreadTask {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition condition1 = reentrantLock.newCondition();
    static Condition condition2 = reentrantLock.newCondition();

    static Thread thread1 = null, thread2 = null;

    public static void main(String[] args) throws InterruptedException {

//        thread2 = new Thread(() -> {
//
//            for (int i = 1; i <= 26; i++) {
//                LockSupport.park();
//                System.out.print(i);
//                LockSupport.unpark(thread1);
//            }
//        });
//
//        thread1 = new Thread(() -> {
//            char start = 'A';
//
//            for (int i = 0; i < 26; i++) {
//                System.out.print((char)(start + i));
//                LockSupport.unpark(thread2);
//                LockSupport.park();
//            }
//        });

        thread2 = new Thread(() -> {


            try{
                reentrantLock.lock();
                for (int i = 1; i <= 26; i++) {
                    try {
                        condition2.await();
                        System.out.print(i);
                        condition1.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                reentrantLock.unlock();
            }

        });

        thread1 = new Thread(() -> {
            char start = 'A';
            try{
                reentrantLock.lock();
                for (int i = 0; i < 26; i++) {
                    System.out.print((char)(start + i));
                    condition2.signal();
                    try {
                        if (i < 25){
                            condition1.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                reentrantLock.unlock();
            }

        });


        thread2.start();
        Thread.sleep(1000);
        thread1.start();
    }
}
