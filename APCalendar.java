public class APCalendar
{
/** Returns true if year is a leap year and false otherwise. */
private static boolean isLeapYear(int year)
{
    return (year%4==0 && year%100!=0);
}
/** Returns the number of leap years between year1 and year2, inclusive.
* Precondition: 0 <= year1 <= year2
*/
public static int numberOfLeapYears(int year1, int year2)
{
    int a = year1;
    for (int i=year1; i<year1+4; i++) {
        if (i%4==0) {
            a = i;
            break;
        }
    }
    int b = 0;
    for (int i=a; i<year2; i+=4) {
        if (i%100 != 0) b++;
    }
    return b;
}
/** Returns the value representing the day of the week for the first day of year,
* where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
*/
public static int firstDayOfYear(int year)
{
    int a = 1;
    for (int i=0; i<year; i++) {
        a++;
        if (isLeapYear(i)) a++;
    }
    return a%7;

}
/** Returns n, where month, day, and year specify the nth day of the year.
* Returns 1 for January 1 (month = 1, day = 1) of any year.
* Precondition: The date represented by month, day, year is a valid date.
*/
private static int dayOfYear(int month, int day, int year)
{
    int a = 0;
    if (month>1) a+=31;
    if (month>2) a+=28;
    if (isLeapYear(year)) return a++;
    if (month>3) a+=31;
    if (month>4) a+=30;
    if (month>5) a+=31;
    if (month>6) a+=30;
    if (month>7) a+=31;
    if (month>8) a+=31;
    if (month>9) a+=30;
    if (month>10) a+=31;
    if (month>11) a+=30;
    a+=day;
    return a;
}
/** Returns the value representing the day of the week for the given date
* (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
* and 6 denotes Saturday.
* Precondition: The date represented by month, day, year is a valid date.
*/
public static int dayOfWeek(int month, int day, int year)
{
    return ((dayOfYear(month, day, year)%7)+firstDayOfYear(year)-1);
}
// There may be instance variables, constructors, and other methods not shown.
}