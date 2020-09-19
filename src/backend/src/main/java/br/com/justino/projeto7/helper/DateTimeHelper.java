package br.com.justino.projeto7.helper;

import javax.validation.ValidationException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeHelper {

    public static Date retornaData(Date data) {
        if (data == null)
            return data;
        data = retornaDataHora(data);
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        return cal.getTime();
    }

    public static Date retornaDataHora(Date data) {
        if (data == null)
            return data;
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Integer getMonth(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static Integer getDay(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static Integer getYear(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal.get(Calendar.YEAR);
    }

    public static Integer getMonth(Double data) {
        return getMonth(getDataByDecimal(data));
    }

    public static Integer getYear(Double data) {
        return getYear(getDataByDecimal(data));
    }

    public static Date toDateYmd(Integer ano, Integer mes, Integer dia) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.MONTH, mes - 1);
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.YEAR, ano);
        return cal.getTime();
    }

    public static Date dataHoraServidor() {
        return new Date();
    }

    public static Date dataServidor() {
        return retornaData(dataHoraServidor());
    }

    public static Date addDay(Date data, Integer dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, dias);
        return cal.getTime();
    }

    public static Date decreaseDay(Date data, Integer dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, -dias);
        return cal.getTime();
    }

    public static Date addHour(Date data, Integer horas) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.HOUR, horas);
        return cal.getTime();
    }

    public static Date addMonth(Date data, Integer meses) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MONTH, meses);
        return cal.getTime();
    }

    public static Double addMonth(Double value, Integer month) {
        Date d = addMonth(getDataByDecimal(value), month);
        return getAnoMesDecimal(d);
    }

    public static Date decreaseMonth(Date data, Integer decrease) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MONTH, -decrease);
        return cal.getTime();
    }

    public static Double decreaseMonth(Double value, Integer decrease) {
        Date d = decreaseMonth(getDataByDecimal(value), decrease);
        return getAnoMesDecimal(d);
    }

    /**
     * @implNote see task #7204
     */
    public static Date addSeconds(Date data, Integer segundos) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.SECOND, segundos);
        return cal.getTime();
    }

    /**
     * @implNote see task #7204
     */
    public static Date decreaseSeconds(Date data, Integer segundos) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.SECOND, -segundos);
        return cal.getTime();
    }

    public static Date addMilliseconds(Date data, Integer milis) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MILLISECOND, milis);
        return cal.getTime();
    }

    public static Date addMinutes(Date data, Integer minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    public static Date endMonth(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }


    public static Date getDataByPeriodo(String mesano) { /** @implNote "mm/yyyy" */
        Date retorno = null;
        Integer mes, ano;
        mes = Integer.valueOf(mesano.split("/")[0]);
        ano = Integer.valueOf(mesano.split("/")[1]);
        retorno = toDateYmd(ano, mes, 1);
        return retorno;
    }

    /**
     * @implNote see task #7353
     */
    public static Integer getWeekDay(Date pData) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(pData);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * @implNote see task #7353
     */
    public static Integer getHour(Date pDataHora) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(pDataHora);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * @implNote see task #7353
     */
    public static Integer getMinute(Date pDataHora) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(pDataHora);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * @implNote see task #7353
     */
    public static Integer getSecond(Date pDataHora) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(pDataHora);
        return cal.get(Calendar.SECOND);
    }

    public static Integer getMillisecond(Date pDataHora) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(pDataHora);
        return cal.get(Calendar.MILLISECOND);
    }

    /**
     * @implNote see task #6360
     */
    public static int compareTo(Date objeto1, Object objeto2) {
        return compareTo(objeto1, (Date) objeto2);

    }

    /**
     * @implNote see task #6360
     */
    public static int compareTo(Date objeto1, Date objeto2) {
        return (objeto1 == null && objeto2 == null ? 0
                : (objeto1 != null && objeto2 != null ? (objectEquals(objeto1,objeto2) ? 0 :Long.compare(objeto1.getTime(),objeto2.getTime()))
                : (objeto1 != null ? 1 : -1)));
    }

    public static String duration(Date startDate, Date endDate) {

        long duration = endDate.getTime() - startDate.getTime();

        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);

        if (diffInHours > 0) {
            return diffInHours + "h";
        } else if (diffInMinutes > 0) {
            return diffInMinutes + "min";
        } else {
            return diffInSeconds + "s";
        }
    }

    /**
     * <code>SimpleDateFormat</code> is a concrete class for formatting and parsing dates in a locale-sensitive manner. It allows for
     * formatting (date &rarr; text), parsing (text &rarr; date), and normalization.
     * <p>
     * <p>
     * <code>SimpleDateFormat</code> allows you to start by choosing any user-defined patterns for date-time formatting. However, you are
     * encouraged to create a date-time formatter with either <code>getTimeInstance</code>, <code>getDateInstance</code>, or
     * <code>getDateTimeInstance</code> in <code>DateFormat</code>. Each of these class methods can return a date/time formatter initialized
     * with a default format pattern. You may modify the format pattern using the <code>applyPattern</code> methods as desired. For more
     * information on using these methods, see {@link DateFormat}.
     * <p>
     * <h3>Date and Time Patterns</h3>
     * <p>
     * Date and time formats are specified by <em>date and time pattern</em> strings. Within date and time pattern strings, unquoted letters
     * from <code>'A'</code> to <code>'Z'</code> and from <code>'a'</code> to <code>'z'</code> are interpreted as pattern letters
     * representing the components of a date or time string. Text can be quoted using single quotes (<code>'</code>) to avoid
     * interpretation. <code>"''"</code> represents a single quote. All other characters are not interpreted; they're simply copied into the
     * output string during formatting or matched against the input string during parsing.
     * <p>
     * The following pattern letters are defined (all other characters from <code>'A'</code> to <code>'Z'</code> and from <code>'a'</code>
     * to <code>'z'</code> are reserved): <blockquote>
     * <table border=0 cellspacing=3 cellpadding=0 summary="Chart shows pattern letters, date/time component, presentation, and examples.">
     * <tr style="background-color: rgb(204, 204, 255);">
     * <th align=left>Letter
     * <th align=left>Date or Time Component
     * <th align=left>Presentation
     * <th align=left>Examples
     * <tr>
     * <td><code>G</code>
     * <td>Era designator
     * <td><a href="#text">Text</a>
     * <td><code>AD</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>y</code>
     * <td>Year
     * <td><a href="#year">Year</a>
     * <td><code>1996</code>; <code>96</code>
     * <tr>
     * <td><code>Y</code>
     * <td>Week year
     * <td><a href="#year">Year</a>
     * <td><code>2009</code>; <code>09</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>M</code>
     * <td>Month in year (context sensitive)
     * <td><a href="#month">Month</a>
     * <td><code>July</code>; <code>Jul</code>; <code>07</code>
     * <tr>
     * <td><code>L</code>
     * <td>Month in year (standalone form)
     * <td><a href="#month">Month</a>
     * <td><code>July</code>; <code>Jul</code>; <code>07</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>w</code>
     * <td>Week in year
     * <td><a href="#number">Number</a>
     * <td><code>27</code>
     * <tr>
     * <td><code>W</code>
     * <td>Week in month
     * <td><a href="#number">Number</a>
     * <td><code>2</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>D</code>
     * <td>Day in year
     * <td><a href="#number">Number</a>
     * <td><code>189</code>
     * <tr>
     * <td><code>d</code>
     * <td>Day in month
     * <td><a href="#number">Number</a>
     * <td><code>10</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>F</code>
     * <td>Day of week in month
     * <td><a href="#number">Number</a>
     * <td><code>2</code>
     * <tr>
     * <td><code>E</code>
     * <td>Day name in week
     * <td><a href="#text">Text</a>
     * <td><code>Tuesday</code>; <code>Tue</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>u</code>
     * <td>Day number of week (1 = Monday, ..., 7 = Sunday)
     * <td><a href="#number">Number</a>
     * <td><code>1</code>
     * <tr>
     * <td><code>a</code>
     * <td>Am/pm marker
     * <td><a href="#text">Text</a>
     * <td><code>PM</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>H</code>
     * <td>Hour in day (0-23)
     * <td><a href="#number">Number</a>
     * <td><code>0</code>
     * <tr>
     * <td><code>k</code>
     * <td>Hour in day (1-24)
     * <td><a href="#number">Number</a>
     * <td><code>24</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>K</code>
     * <td>Hour in am/pm (0-11)
     * <td><a href="#number">Number</a>
     * <td><code>0</code>
     * <tr>
     * <td><code>h</code>
     * <td>Hour in am/pm (1-12)
     * <td><a href="#number">Number</a>
     * <td><code>12</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>m</code>
     * <td>Minute in hour
     * <td><a href="#number">Number</a>
     * <td><code>30</code>
     * <tr>
     * <td><code>s</code>
     * <td>Second in minute
     * <td><a href="#number">Number</a>
     * <td><code>55</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>S</code>
     * <td>Millisecond
     * <td><a href="#number">Number</a>
     * <td><code>978</code>
     * <tr>
     * <td><code>z</code>
     * <td>Time zone
     * <td><a href="#timezone">General time zone</a>
     * <td><code>Pacific Standard Time</code>; <code>PST</code>; <code>GMT-08:00</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>Z</code>
     * <td>Time zone
     * <td><a href="#rfc822timezone">RFC 822 time zone</a>
     * <td><code>-0800</code>
     * <tr>
     * <td><code>X</code>
     * <td>Time zone
     * <td><a href="#iso8601timezone">ISO 8601 time zone</a>
     * <td><code>-08</code>; <code>-0800</code>; <code>-08:00</code>
     * </table>
     * </blockquote> Pattern letters are usually repeated, as their number determines the exact presentation:
     * <ul>
     * <li><strong><a name="text">Text:</a></strong> For formatting, if the number of pattern letters is 4 or more, the full form is used;
     * otherwise a short or abbreviated form is used if available. For parsing, both forms are accepted, independent of the number of
     * pattern letters.<br>
     * <br>
     * </li>
     * <li><strong><a name="number">Number:</a></strong> For formatting, the number of pattern letters is the minimum number of digits, and
     * shorter numbers are zero-padded to this amount. For parsing, the number of pattern letters is ignored unless it's needed to separate
     * two adjacent fields.<br>
     * <br>
     * </li>
     * <li><strong><a name="year">Year:</a></strong> If the formatter's {getCalendar() Calendar} is the Gregorian calendar, the following
     * rules are applied.<br>
     * <ul>
     * <li>For formatting, if the number of pattern letters is 2, the year is truncated to 2 digits; otherwise it is interpreted as a
     * <a href="#number">number</a>.
     * <li>For parsing, if the number of pattern letters is more than 2, the year is interpreted literally, regardless of the number of
     * digits. So using the pattern "MM/dd/yyyy", "01/11/12" parses to Jan 11, 12 A.D.
     * <li>For parsing with the abbreviated year pattern ("y" or "yy"), <code>SimpleDateFormat</code> must interpret the abbreviated year
     * relative to some century. It does this by adjusting dates to be within 80 years before and 20 years after the time the
     * <code>SimpleDateFormat</code> instance is created. For example, using a pattern of "MM/dd/yy" and a <code>SimpleDateFormat</code>
     * instance created on Jan 1, 1997, the string "01/11/12" would be interpreted as Jan 11, 2012 while the string "05/04/64" would be
     * interpreted as May 4, 1964. During parsing, only strings consisting of exactly two digits, as defined by
     * {@link Character#isDigit(char)}, will be parsed into the default century. Any other numeric string, such as a one digit string, a
     * three or more digit string, or a two digit string that isn't all digits (for example, "-1"), is interpreted literally. So "01/02/3"
     * or "01/02/003" are parsed, using the same pattern, as Jan 2, 3 AD. Likewise, "01/02/-3" is parsed as Jan 2, 4 BC.
     * </ul>
     * Otherwise, calendar system specific forms are applied. For both formatting and parsing, if the number of pattern letters is 4 or
     * more, a calendar specific {@linkplain Calendar#LONG long form} is used. Otherwise, a calendar specific {@linkplain Calendar#SHORT
     * short or abbreviated form} is used.<br>
     * <br>
     * If week year {@code 'Y'} is specified and the {getCalendar() calendar} doesn't support any
     * <a href="../util/GregorianCalendar.html#week_year"> week years</a>, the calendar year ({@code 'y'}) is used instead. The support of
     * week years can be tested with a call to {@link DateFormat#getCalendar()
     * getCalendar()}.{@link java.util.Calendar#isWeekDateSupported() isWeekDateSupported()}.<br>
     * <br>
     * </li>
     * <li><strong><a name="month">Month:</a></strong> If the number of pattern letters is 3 or more, the month is interpreted as
     * <a href="#text">text</a>; otherwise, it is interpreted as a <a href="#number">number</a>.<br>
     * <ul>
     * <li>Letter <em>M</em> produces context-sensitive month names, such as the embedded form of names. If a {@code DateFormatSymbols} has
     * been set explicitly with constructor {SimpleDateFormat(String, DateFormatSymbols)} or method
     * {setDateFormatSymbols(DateFormatSymbols)}, the month names given by the {@code DateFormatSymbols} are used.</li>
     * <li>Letter <em>L</em> produces the standalone form of month names.</li>
     * </ul>
     * <br>
     * </li>
     * <li><strong><a name="timezone">General time zone:</a></strong> Time zones are interpreted as <a href="#text">text</a> if they have
     * names. For time zones representing a GMT offset value, the following syntax is used:
     * <p>
     *
     * <pre>
     *     <a name="GMTOffsetTimeZone"><i>GMTOffsetTimeZone:</i></a>
     *             <code>GMT</code> <i>Sign</i> <i>Hours</i> <code>:</code> <i>Minutes</i>
     *     <i>Sign:</i> one of
     *             <code>+ -</code>
     *     <i>Hours:</i>
     *             <i>Digit</i>
     *             <i>Digit</i> <i>Digit</i>
     *     <i>Minutes:</i>
     *             <i>Digit</i> <i>Digit</i>
     *     <i>Digit:</i> one of
     *             <code>0 1 2 3 4 5 6 7 8 9</code>
     * </pre>
     * <p>
     * <i>Hours</i> must be between 0 and 23, and <i>Minutes</i> must be between 00 and 59. The format is locale independent and digits must
     * be taken from the Basic Latin block of the Unicode standard.
     * <p>
     * For parsing, <a href="#rfc822timezone">RFC 822 time zones</a> are also accepted.<br>
     * <br>
     * </li>
     * <li><strong><a name="rfc822timezone">RFC 822 time zone:</a></strong> For formatting, the RFC 822 4-digit time zone format is used:
     * <p>
     *
     * <pre>
     *     <i>RFC822TimeZone:</i>
     *             <i>Sign</i> <i>TwoDigitHours</i> <i>Minutes</i>
     *     <i>TwoDigitHours:</i>
     *             <i>Digit Digit</i>
     * </pre>
     * <p>
     * <i>TwoDigitHours</i> must be between 00 and 23. Other definitions are as for <a href="#timezone">general time zones</a>.
     * <p>
     * <p>
     * For parsing, <a href="#timezone">general time zones</a> are also accepted.
     * <li><strong><a name="iso8601timezone">ISO 8601 Time zone:</a></strong> The number of pattern letters designates the format for both
     * formatting and parsing as follows:
     * <p>
     *
     * <pre>
     *     <i>ISO8601TimeZone:</i>
     *             <i>OneLetterISO8601TimeZone</i>
     *             <i>TwoLetterISO8601TimeZone</i>
     *             <i>ThreeLetterISO8601TimeZone</i>
     *     <i>OneLetterISO8601TimeZone:</i>
     *             <i>Sign</i> <i>TwoDigitHours</i>
     *             {@code Z}
     *     <i>TwoLetterISO8601TimeZone:</i>
     *             <i>Sign</i> <i>TwoDigitHours</i> <i>Minutes</i>
     *             {@code Z}
     *     <i>ThreeLetterISO8601TimeZone:</i>
     *             <i>Sign</i> <i>TwoDigitHours</i> {@code :} <i>Minutes</i>
     *             {@code Z}
     * </pre>
     * <p>
     * Other definitions are as for <a href="#timezone">general time zones</a> or <a href="#rfc822timezone">RFC 822 time zones</a>.
     * <p>
     * <p>
     * For formatting, if the offset value from GMT is 0, {@code "Z"} is produced. If the number of pattern letters is 1, any fraction of an
     * hour is ignored. For example, if the pattern is {@code "X"} and the time zone is {@code "GMT+05:30"}, {@code "+05"} is produced.
     * <p>
     * <p>
     * For parsing, {@code "Z"} is parsed as the UTC time zone designator. <a href="#timezone">General time zones</a> are <em>not</em>
     * accepted.
     * <p>
     * <p>
     * If the number of pattern letters is 4 or more, {@link IllegalArgumentException} is thrown when constructing a {@code
     * SimpleDateFormat} or {applyPattern(String) applying a pattern}.
     * </ul>
     * <code>SimpleDateFormat</code> also supports <em>localized date and time pattern</em> strings. In these strings, the pattern letters
     * described above may be replaced with other, locale dependent, pattern letters. <code>SimpleDateFormat</code> does not deal with the
     * localization of text other than the pattern letters; that's up to the client of the class.
     * <p>
     * <h4>Examples</h4>
     * <p>
     * The following examples show how date and time patterns are interpreted in the U.S. locale. The given date and time are 2001-07-04
     * 12:08:56 local time in the U.S. Pacific Time time zone. <blockquote>
     * <table border=0 cellspacing=3 cellpadding=0 summary="Examples of date and time patterns interpreted in the U.S. locale">
     * <tr style="background-color: rgb(204, 204, 255);">
     * <th align=left>Date and Time Pattern
     * <th align=left>Result
     * <tr>
     * <td><code>"yyyy.MM.dd G 'at' HH:mm:ss z"</code>
     * <td><code>2001.07.04 AD at 12:08:56 PDT</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>"EEE, MMM d, ''yy"</code>
     * <td><code>Wed, Jul 4, '01</code>
     * <tr>
     * <td><code>"h:mm a"</code>
     * <td><code>12:08 PM</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>"hh 'o''clock' a, zzzz"</code>
     * <td><code>12 o'clock PM, Pacific Daylight Time</code>
     * <tr>
     * <td><code>"K:mm a, z"</code>
     * <td><code>0:08 PM, PDT</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>"yyyyy.MMMMM.dd GGG hh:mm aaa"</code>
     * <td><code>02001.July.04 AD 12:08 PM</code>
     * <tr>
     * <td><code>"EEE, d MMM yyyy HH:mm:ss Z"</code>
     * <td><code>Wed, 4 Jul 2001 12:08:56 -0700</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>"yyMMddHHmmssZ"</code>
     * <td><code>010704120856-0700</code>
     * <tr>
     * <td><code>"yyyy-MM-dd'T'HH:mm:ss.SSSZ"</code>
     * <td><code>2001-07-04T12:08:56.235-0700</code>
     * <tr style="background-color: rgb(238, 238, 255);">
     * <td><code>"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"</code>
     * <td><code>2001-07-04T12:08:56.235-07:00</code>
     * <tr>
     * <td><code>"YYYY-'W'ww-u"</code>
     * <td><code>2001-W27-3</code>
     * </table>
     * </blockquote>
     * <p>
     * <h4><a name="synchronization">Synchronization</a></h4>
     * <p>
     * <p>
     * Date formats are not synchronized. It is recommended to create separate format instances for each thread. If multiple threads access
     * a format concurrently, it must be synchronized externally.
     *
     * @author Mark Davis, Chen-Lieh Huang, Alan Liu
     * @see <a href= "https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html"> Java Tutorial</a>
     * @see java.util.Calendar
     * @see java.util.TimeZone
     * @see DateFormat
     * @see DateFormatSymbols
     */
    public static Date toDate(String data, String format) {
        DateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        Date result = null;
        try {
            result = df.parse(data);
        } catch (ParseException e) {
            Logger.getLogger(StaticFunctions.class.getName()).log(Level.SEVERE,
                    "## [ERROR] ## Nao foi possivel converter Data [" + data + "] para o formato [" + format + "].", e);
        }
        return result;
    }

    public static Date toDateWithTZ(String data) {
        if (data == null)
            return null;

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
        Date result = null;
        try {
            result = df.parse(data.replace("-03:00", "").replace("-02:00", ""));
        } catch (ParseException e) {
            Logger.getLogger(StaticFunctions.class.getName()).log(Level.SEVERE,
                    "## [ERROR] ## Nao foi possivel converter Data [" + data + "] para o formato [yyyy-MM-dd'T'HH:mm:ssZ].", e);
        }
        return result;
    }

    public static Date getDateZero() {
        return getMinimalDate();
    }

    public static Boolean isValidDate(String dateString) {
        if (dateString.endsWith("-03:00") || dateString.endsWith("-02:00") || ((dateString.indexOf('T') == 10) && dateString.endsWith("Z"))
                || (dateString.indexOf('-') == 4 && dateString.lastIndexOf('-') == 7 && dateString.indexOf('T') == 10)) {
            return true;
        }
        return false;
    }

    public static int dayOfWeek(Date data) {
        return getWeekDay(data);
    }

    public static Boolean isSunday(Date data) {
        return (dayOfWeek(data) == Calendar.SUNDAY);
    }

    public static Boolean isSaturday(Date data) {
        return (dayOfWeek(data) == Calendar.SATURDAY);
    }


    /**
     * @return Retorna os segundos da data passada por parametro.
     * @implNote see task #5183
     */
    public static Integer getSeconds(String hora) {
        int h = 0, m = 0, s = 0;
        String[] split = hora.split(":");
        if (split.length != 3) {
            StaticFunctions.throwConstraintViolationException("Erro ao converter hora para segundos.", hora);
        } else {
            h = StaticFunctions.toInteger(split[0]);
            m = StaticFunctions.toInteger(split[1]);
            s = StaticFunctions.toInteger(split[2]);
        }
        return (h * 3600) + (m * 60) + s;

    }

    public static Date zeraData(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.set(Calendar.DAY_OF_MONTH, 01);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.YEAR, 1970);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getMinimalDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 01);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.YEAR, 1970);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * @return retorna a data passada em parametro com a hora setada.
     * @implNote see task #6567
     */
    public static Date makeDataHora(Date data, String hora) {
        String pattern = "(^([012]\\d:[0-5]\\d:[0-5]\\d))$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(hora);
        if (m.find()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data);
            calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hora.split(":")[0]));
            calendar.set(Calendar.MINUTE, Integer.valueOf(hora.split(":")[1]));
            calendar.set(Calendar.SECOND, Integer.valueOf(hora.split(":")[2]));
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        } else {
            StaticFunctions.throwConstraintViolationException("Hora [" + hora + "] n�o condiz com pattern: " + pattern, hora);
        }

        return data;
    }



    public static Double getAnoMesDecimal(Date date) {
        if (date == null)
            return null;
        return Double.valueOf(StringHelper.formatDate(date, "yyyy.MM"));
    }

    public static Date getDataByDecimal(Double data) {
        try {
            String[] p = data.toString().split("\\.");
            Calendar c = GregorianCalendar.getInstance();
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.set(Calendar.YEAR, Integer.valueOf(p[0]));
            c.set(Calendar.MONTH, Integer.valueOf(p[1].equals("1") ? "10" : p[1]) - 1);
            return c.getTime();
        } catch (Exception e) {
            throw new ValidationException(e.getMessage());
        }
    }

    public static Date getLastDataByDecimal(Double data) {
        try {
            Date dataUltima = getDataByDecimal(data);
            dataUltima = addMonth(dataUltima, 1);
            return addDay(dataUltima, -1);
        } catch (Exception e) {
            throw new ValidationException(e.getMessage());
        }
    }

    public static Date getLastSystemDate(){
        return makeDataHora(toDateYmd(9999,12,31), "23:59:59");
    }


    public static boolean objectEquals(Date a, Date b) {
        int dia1,mes1,ano1,hora1,minuto1,segundo1,milesimo1;
        int dia2,mes2,ano2,hora2,minuto2,segundo2,milesimo2;
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        dia1 = getDay(a);
        mes1 = getMonth(a);
        ano1 = getYear(a);
        minuto1 = getMinute(a);
        segundo1 = getSecond(a);
        hora1 = getHour(a);
        milesimo1 = getMillisecond(a);

        dia2 = getDay(b);
        mes2 = getMonth(b);
        ano2 = getYear(b);
        minuto2 = getMinute(b);
        segundo2 = getSecond(b);
        hora2 = getHour(b);
        milesimo2 = getMillisecond(b);

        return (StaticFunctions.objectEquals(dia1,dia2) &&
                StaticFunctions.objectEquals(mes1,mes2) &&
                StaticFunctions.objectEquals(ano1,ano2) &&
                StaticFunctions.objectEquals(hora1,hora2) &&
                StaticFunctions.objectEquals(minuto1,minuto2) &&
                StaticFunctions.objectEquals(segundo1,segundo2) &&
                StaticFunctions.objectEquals(milesimo1,milesimo2)
        );
    }


    public static List<Date> getListOfDates(Date dataInicial, Date dataFinal){
        List<Date> datas = new ArrayList<>();
        datas.add(dataInicial);
        Calendar inicio = Calendar.getInstance();
        inicio.setTime(dataInicial);
        while(inicio.getTime().before(dataFinal)){
            inicio.add(Calendar.DAY_OF_YEAR,1);
            datas.add(inicio.getTime());
        }
        return datas;
    }

}