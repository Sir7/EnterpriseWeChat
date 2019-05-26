package com.alphabet.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 
 * <p>描述:</p>
 * <p>Company:上海中信信息发展股份有限公司</p>
 * @author hp(张传乐 E-mail:zhang.chuanle@cesgroup.com.cn)
 * @date 2015-1-6  下午7:42:25
 * @version 1.0.2015.
 */
public class DateUtils {

	/**
	 * 日期和字符串之间的转换格式：年 yyyy
	 */
	public static final String PATTERN_YEAR = "yyyy";
	/**
	 * 日期和字符串之间的转换格式：年月 yyyy-MM
	 */
	public static final String PATTERN_YEARMONTH = "yyyy-MM";
	/**
	 * 日期和字符串之间的转换格式：年月日 yyyy-MM-dd
	 */
	public static final String PATTERN_DATE = "yyyy-MM-dd";
	/**
	 * 日期和字符串之间的转换格式：年月日时分 yyyy-MM-dd HH:mm
	 */
	public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm";
	/**
	 * 日期和字符串之间的转换格式：年月日时分秒 yyyy-MM-dd HH:mm:ss
	 */
	public static final String PATTERN_DATETIMESS = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 日期和字符串之间的转换格式：时分 HH:mm
	 */
	public static final String PATTERN_HHMM = "HH:mm";	
	
	/**
	 * 格式化日期为字符串，格式为年
	 *
	 * @param date 日期
	 * @return String
	 */
	public static String formatYear(Date date) {
		String result = "";
		if (date != null) {
			result = DateFormatUtils.format(date, PATTERN_YEAR);
		}
		return result;
	}

	/**
	 * 格式化日期为字符串，格式为年月
	 *
	 * @param date
	 * @return
	 */
	public static String formatYearMonth(Date date) {
		String result = "";
		if (date != null) {
			result = DateFormatUtils
					.format(date, PATTERN_YEARMONTH);
		}
		return result;
	}

	/**
	 * 格式化日期为字符串，格式为年月日
	 *
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		String result = "";
		if (date != null) {
			result = DateFormatUtils.format(date, PATTERN_DATE);
		}
		return result;
	}

	/**
	 * 格式化日期为字符串，格式为年月日时分
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) {
		String result = "";
		if (date != null) {
			result = DateFormatUtils.format(date, PATTERN_DATETIME);
		}
		return result;
	}

	/**
	 * 格式化日期为字符串，格式为年月日时分秒
	 *
	 * @param date
	 * @return
	 */
	public static String formatDateTimess(Date date) {
		String result = "";
		if (date != null) {
			result = DateFormatUtils.format(date, PATTERN_DATETIMESS);
		}
		return result;
	}

	/**
	 * 格式化日期为字符串，格式为时分
	 *
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date){
		String result = "";
		if (date != null) {
			result = DateFormatUtils.format(date, PATTERN_HHMM);
		}
		return result;
	}

	/**
	 * 解析字符串为日期，格式为年
	 *
	 * @param str
	 * @return
	 */
	public static Date parseYear(String str) {
		Date result = null;
		if (str != null && !"".equals(str)) {
			try {
				result = org.apache.commons.lang.time.DateUtils.parseDate(str,
						new String[] { PATTERN_YEAR });
			} catch (ParseException e) {
				// e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 解析字符串为日期，格式为年月
	 *
	 * @param str
	 * @return
	 */
	public static Date parseYearMonth(String str) {
		Date result = null;
		if (str != null && !"".equals(str)) {
			try {
				result = org.apache.commons.lang.time.DateUtils.parseDate(str,
						new String[] { PATTERN_YEARMONTH });
			} catch (ParseException e) {
				// e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 解析字符串为日期，格式为年月日
	 *
	 * @param str
	 * @return
	 */
	public static Date parseDate(String str) {
		Date result = null;
		if (str != null && !"".equals(str)) {
			try {
				result = org.apache.commons.lang.time.DateUtils.parseDate(str,
						new String[] { PATTERN_DATE });
			} catch (ParseException e) {
				// e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 解析字符串为日期，格式为年月日时分
	 *
	 * @param str
	 * @return
	 */
	public static Date parseDateTime(String str) {
		Date result = null;
		if (str != null && !"".equals(str)) {
			try {
				result = org.apache.commons.lang.time.DateUtils.parseDate(str,
						new String[] { PATTERN_DATETIME });
			} catch (ParseException e) {
				// e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 解析字符串为日期，格式为日
	 *
	 * @param str
	 * @return
	 */
	public static String parseDay(Date str) {
		SimpleDateFormat df = new SimpleDateFormat("dd");
		return df.format(str);
	}

	/**
	 * 解析字符串为日期，格式为年月日时分秒
	 *
	 * @param str
	 * @return
	 */
	public static Date parseDateTimess(String str) {
		Date result = null;
		if (str != null && !"".equals(str)) {
			try {
				result = org.apache.commons.lang.time.DateUtils.parseDate(str,
						new String[] { PATTERN_DATETIMESS });
			} catch (ParseException e) {
				// e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 解析字符串为日期，格式为年月日时分
	 *
	 * @param str
	 * @return
	 */
	public static Date parseTime(String str) {
		Date result = null;
		if (str != null && !"".equals(str)) {
			try {
				result = org.apache.commons.lang.time.DateUtils.parseDate(str,
						new String[] { PATTERN_HHMM });
			} catch (ParseException e) {
				// e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 取得当前日期，格式为2008-01-01 01:01
	 * @return
	 */
	public static String getCurrentDate() {
		return getCurrentDate(true);
	}

	/**
	 * 取得当前日期
	 * @param hasTime 为true 格式为2008-01-01 01:01,hasTime为false 格式为2008-01-01
	 * @return
	 */
	public static String getCurrentDate(boolean hasTime) {
		return hasTime ? formatDateTime(new Date()) : formatDate(new Date());
	}
	

	/**
	 * 比较日期大小
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDate(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		return cal1.compareTo(cal2);
	}

	/**
	 * 比较日期大小
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDate(String date1, String date2) {
		return compareDate(parseDateTime(date1),parseDateTime(date2));
	}

	/**
	 * 取得当月最小日期
	 *
	 * @param date
	 * @return
	 */
	public static String getMinOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		int min = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DATE, min);
		return formatDate(cal.getTime());
	}

	/**
	 * 取得当月最大日期
	 *
	 * @param date
	 * @return
	 */
	public static String getMaxOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DATE, max);
		return formatDate(cal.getTime());
	}
	
	/**
	 * 
	 * @param s a <code>String</code> object representing a date in 
     *        in the format "yyyy-mm-dd"
     * @return a <code>java.sql.Date</code> object representing the
     *         given date
	 * @author hp(张传乐 E-mail:zhang.chuanle@cesgroup.com.cn)
	 * @date 2015-1-6  下午8:22:36
	 */
	public static java.sql.Date valueOf(String s) {
		if(StringUtils.isEmpty(s)){
			return null;
		}else{
			try{
				return java.sql.Date.valueOf(s.substring(0, 10));
			}catch (Exception e) {
					return null;
			}
		}
	}
	
	/**
	 * .判断字符串是否符合特定的日期字符串格式
	 * @author hp(王梦宇 E-mail:wang.mengyu@cesgroup.com.cn)
	 * @date 2015-1-8  下午7:58:49
	 */
	public boolean isValidDate(String dateStr,String format){
		SimpleDateFormat dateFormat=null;
		dateFormat=new SimpleDateFormat(format);
		if(dateStr==null||format==null||
				dateStr.isEmpty()||format.isEmpty()){
			return false;
		}else{
			try {
				dateFormat.parse(dateStr);
				return true;
			} catch (ParseException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	
	/**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    

	/**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(String dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(dt));
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) {  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
        long between_days=0;
    	try{ 
	        smdate=sdf.parse(sdf.format(smdate));  
	        bdate=sdf.parse(sdf.format(bdate));  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(smdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(bdate);    
	        long time2 = cal.getTimeInMillis();         
	        between_days=(time2-time1)/(1000*3600*24);  
    	}catch(ParseException e){
    		
    	}
       return Integer.parseInt(String.valueOf(between_days));           
    } 
}
