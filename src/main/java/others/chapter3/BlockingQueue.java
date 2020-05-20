package others.chapter3;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/12
 * @content:
 */
public class BlockingQueue<T> {
    private ReentrantLock lock;
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    private LinkedList<T> list;
    private static final int DEFAULT_LENGTH = 10;
    private int size;

    private AtomicInteger currentSize;

    public BlockingQueue(int size) {
        this.size = size;
        this.currentSize = new AtomicInteger(0);
        this.list = new LinkedList<>();
    }

    public BlockingQueue() {
        this(DEFAULT_LENGTH);
    }

    public void add(T data){
        synchronized (BlockingQueue.class){
            if (size <= currentSize.intValue()){
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.addFirst(data);
            condition2.signal();
        }

    }

    public T get() {
        return list.peekLast();
    }

    public T pop() {
        if (currentSize.get() <= 0){
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T data = list.pollLast();
        condition1.signal();
        return data;
    }
}
