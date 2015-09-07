package books.examples.effectiveJava.article3_singleton;

import java.lang.reflect.Field;

/**
 * Created by mnikonova on 28.05.15.
 */

//can be only singleton
public class SingletonDemo {

    public static final SingletonDemo instance = new SingletonDemo();

    private SingletonDemo() {
    }


//this method not protected from reflection access:
/*    String funMethod = "fun";
    Method method = clz.getDeclaredMethod(funMethod);
    method.setAccessible(true);
    method.invoke();*/


}
