package iteratorIterable;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by user on 12.03.15.
 */
public class IterImpl implements Iterable<IterImpl> {

    private IterImpl[] strings;
    private int cursor;
    private final int end;

    public IterImpl(int cursor, IterImpl[] strings) {
        this.end = strings.length;
        this.cursor = cursor;
        this.strings = strings;
    }

    public Iterator<IterImpl> iterator() {
        return new StringsIterator();
    }

    private class StringsIterator implements Iterator<IterImpl> {

        @Override
        public boolean hasNext() {
            return cursor < end;
        }

        @Override
        public IterImpl next() {
            if (this.hasNext()) {
                IterImpl current = strings[cursor];
                ++cursor;
                return current;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}