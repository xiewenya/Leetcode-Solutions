package others;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.IntStream;

/**
 * Created by bresai on 2017/1/5.
 */
public class LockFreeStack<E>{
    private final AtomicReferenceArray<E> array;
    private AtomicInteger size;
    private static final int DEFAULT_LENGTH = 1000;

    public LockFreeStack() {
        this(DEFAULT_LENGTH);
    }

    public LockFreeStack(int length) {
        array = new AtomicReferenceArray<E>(length);
        size = new AtomicInteger();
        size.set(0);
    }

    public void push(E item){
        array.compareAndSet(size.getAndIncrement(), null, item);
    }

    public E pop(){
        if (size.get() <= 0) {
            return null;
        }
        return array.getAndSet(size.decrementAndGet(), null);
    }

    public E peek(){
        if (size.get() <= 0) {
            return null;
        }

        return array.get(size.get() - 1);
    }

    public boolean empty(){
        return array.length() == 0;
    }

    public static void main(String[] args) throws InterruptedException {
        LockFreeStack<Integer> stack = new LockFreeStack<>();
        IntStream.range(0,10).forEach(stack::push);

        class TestThread implements Runnable{
            @Override
            public void run() {
                try {
                    Thread.sleep(Math.abs((int) (Math.random() * 100)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "push before" + stack.peek());
                stack.push(stack.peek() + 1);
                System.out.println(Thread.currentThread().getId() + "push after" + stack.peek());
            }
        }

        class PopThread implements Runnable{
            @Override
            public void run() {
                try {
                    Thread.sleep(Math.abs((int) (Math.random() * 100)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "pop before" + stack.peek());
                stack.pop();
                System.out.println(Thread.currentThread().getId() + "pop after" + stack.peek());
            }
        }

        IntStream.range(0,1000).boxed().forEach(i -> (new Thread(new TestThread())).start());
        IntStream.range(0,1000).boxed().forEach(i -> (new Thread(new PopThread())).start());
//        stack.peek();
    }
}
