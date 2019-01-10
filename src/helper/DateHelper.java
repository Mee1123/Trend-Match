package helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateHelper {

	public static java.sql.Date toSqlDate(java.util.Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		java.sql.Date d2 = new java.sql.Date(calendar.getTimeInMillis());
		return d2;
	}

	public static java.sql.Date toSqlDate(String strDate) {
		try{
	        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	        java.util.Date date = sdFormat.parse(strDate);
	        java.sql.Date date2 = toSqlDate(date);
	        return date2;
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static java.util.Date toUtilDate (java.sql.Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, 1970);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, 1);
		java.sql.Time time = new java.sql.Time(calendar.getTimeInMillis());
		return time;
	}
	public static java.util.Date toUtilDate(String strDate) {
		try{
	        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	        java.util.Date date = sdFormat.parse(strDate);
	        return date;
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
