package books.examples.effectiveJava.article3_singleton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created by mnikonova on 28.05.15.
 */
//can be easily changed from singleton
public class SingletonDemoSerializable implements Serializable{

    private static /*final*/ SingletonDemoSerializable instance = new SingletonDemoSerializable();

    public static SingletonDemoSerializable getSingletonDemo(){
        return instance;
    }

    private Object readResolve (){
        return instance;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        instance = this;
    }

    //this method not protected from reflection access:
/*    String funMethod = "fun";
    Method method = clz.getDeclaredMethod(funMethod);
    method.setAccessible(true);
    method.invoke();*/

}
