package hw07paycheck_version2.employees;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserDate {
    private Calendar date;
    private int monthNumber;

    public UserDate(int year, int month, int date) {
        this.date =new GregorianCalendar();
        this.date.set(year,month-1,date);
        this.monthNumber=month;
    }

    public Calendar getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "{" + date.get(Calendar.YEAR) +
                '/'+monthNumber+'/'+date.get(Calendar.DATE)+ '}';
    }
}
