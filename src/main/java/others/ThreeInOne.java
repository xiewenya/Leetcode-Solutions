package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/12
 * @content:
 */
public class ThreeInOne<T> {

    private List<Stack<T>> list;

    public static final int DEFAULT_STACK_SIZE = 10;

    public ThreeInOne() {
        this.list = new ArrayList<>();
    }

    public void push(T data){
        if (list.size() == 0){
            list.add(new Stack<>());
        }

        Stack<T> lastStack  = list.get(list.size() - 1);

        if (lastStack.size() >= DEFAULT_STACK_SIZE){
            lastStack = new Stack<>();
            list.add(lastStack);
        }

        lastStack.push(data);
    }

    public T pop() throws Exception {
        if (list.size() == 0){
            throw new Exception();
        }

        Stack<T> lastStack = list.get(list.size() - 1);
        if (lastStack.size() == 0){
            list.remove(list.size() - 1);
            if (list.size() == 0){
                throw new Exception();
            }
            lastStack = list.get(list.size() - 1);
        }

        return lastStack.pop();
    }
}
