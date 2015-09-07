package books.examples.effectiveJava.article5_oddObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by mnikonova on 28.05.15.
 */
public class ImmutableReusageDemo {

    //Bad solution: current implementation create every method call new instances of Calendar, TimeZone, and Date
    public class Person1 {

        private final Date personBirthDay;

        public Person1(Date personBirthDay) {
            this.personBirthDay = personBirthDay;
        }


        public boolean isBabyBoomer() {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0);

            Date boomStart = calendar.getTime();
            calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0);

            Date boomEnd = calendar.getTime();

            return personBirthDay.compareTo(boomStart) >= 0 && personBirthDay.compareTo(boomEnd) < 0;
        }
    }

    //Good solution:
    public static class Person2 {

        private final Date personBirthDay;

        private static final Date BOOM_START;
        private static final Date BOOM_END;

        public Person2(Date personBirthDay) {
            this.personBirthDay = personBirthDay;
        }

        static {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
            BOOM_START = calendar.getTime();
            calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
            BOOM_END = calendar.getTime();
        }

        public boolean isBabyBoomer() {
            return personBirthDay.compareTo(BOOM_START) >= 0 && personBirthDay.compareTo(BOOM_END) < 0;
        }
    }


}
