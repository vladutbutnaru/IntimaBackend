package ro.enered.utils;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Helper for date handle
 *
 * @author Jerome RADUGET
 */
public abstract class DateHelper {

    /**
     * @param birthdate
     * @return Age from the current date
     */
    public static int getAge(final Date birthdate) {
        return getAge(Calendar.getInstance().getTime(), birthdate);
    }

    /**
     * Calculating age from a current date
     *
     * @param current
     * @param birthdate
     * @return Age from the current (arg) date
     */
    public static int getAge(final Date current, final Date birthdate) {

        if (birthdate == null) {
            return 0;
        }
        if (current == null) {
            return getAge(birthdate);
        } else {
            final Calendar calend = new GregorianCalendar();
            calend.set(Calendar.HOUR_OF_DAY, 0);
            calend.set(Calendar.MINUTE, 0);
            calend.set(Calendar.SECOND, 0);
            calend.set(Calendar.MILLISECOND, 0);

            calend.setTimeInMillis(current.getTime() - birthdate.getTime());

            int result = 0;
            result = calend.get(Calendar.YEAR) - 1970;
            result += (float) calend.get(Calendar.MONTH) / (float) 12;
            return result;
        }

    }
}
