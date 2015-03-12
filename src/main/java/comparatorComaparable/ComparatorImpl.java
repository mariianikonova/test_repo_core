package comparatorComaparable;

import java.util.Comparator;

/**
 * Created by user on 03.03.15.
 */

public class ComparatorImpl implements Comparator<ComparableImpl> {
    @Override
    public int compare(ComparableImpl o1, ComparableImpl o2) {
        int res = o1.getName().compareTo(o2.getName());
        if (res != 0) {
            return res;
        }
        return o1.getAge().compareTo(o2.getAge());
    }
}
