package books.examples.effectiveJava.article7_avoidFinalize;

import java.util.Objects;

/**
 *  @autor mnikonova
 *  @since 02.06.15.
 */
public class FinalizeDemo {

    //override fanalize - is bad practice
    //the once possible solution: - manual binding with super.finalize();
    @Override
    protected void finalize() throws Throwable {
        try {
            //remove object state directly
        } finally {
            super.finalize();
        }
    }

    //if finalize was overwritten, super.finalize never won`t be called automatically;
    //but you can avoid it:
    //this class exist only for utilization outer class:

    private final Object finalizerGuardian = new Object(){
      @Override
      protected void finalize() throws Throwable {
          //utilize outer object FinalizeDemo
      }
    };
}
