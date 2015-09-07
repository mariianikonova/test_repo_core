package books.examples.effectiveJava.article3_singleton;

/**
 * Created by mnikonova on 28.05.15.
 */
//can be easily changed from singleton
public class SingletonDemo2 {

    private static final SingletonDemo2 singletonDemo = new SingletonDemo2();

    public static SingletonDemo2 getSingletonDemo(){
        return singletonDemo;
    }

    //this method not protected from reflection access:
/*    String funMethod = "fun";
    Method method = clz.getDeclaredMethod(funMethod);
    method.setAccessible(true);
    method.invoke();*/

}
