/**
 * <p>Copyright:Copyright(c) 2014</p>
 * <p>Company:上海中信信息发展股份有限公司</p>
 * <p>包名:com.ces.prison.common.tools</p>
 * <p>文件名:CommonTools.java</p>
 * <p>类更新历史信息</p>
 * @todo admin(冯有双  E-mail:feng.youshuang@cesgroup.com.cn) 
 * 创建于 2014-12-22 上午10:03:19
 */
package com.alphabet.Utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * <p>描述:存放在Common包下供各个包使用的公共方法类</p>
 * <p>Company:上海中信信息发展股份有限公司</p>
 * @author admin(冯有双 E-mail:feng.youshuang@cesgroup.com.cn)
 * @date 2014-12-22  上午10:03:19
 * @version 1.0.2014.
 */
public class CommonTools {
	
	private static JdbcTemplate jdbcTemplate = null;
	
	/**
	 * <p>获取jdbcTemplate.</p>
	 * @return JdbcTemplate
	 * @author admin(冯有双 E-mail:feng.youshuang@cesgroup.com.cn)
	 * @date 2014-12-20  下午3:29:58
	 */
	/*public static JdbcTemplate getJdbcTemplate() {
		if(jdbcTemplate==null){
			jdbcTemplate = XarchListener.getBean(JdbcTemplate.class);
		}
		return jdbcTemplate;
	}*/
	
	/**
	 * .将Map对象转换成java实体类
	 * @param map
	 * @param clazz
	 * @return Object
	 * @throws IntrospectionException
	 * @throws InstantiationException
	 * @throws IllegalAccessException Object
	 * @author admin(冯有双 E-mail:feng.youshuang@cesgroup.com.cn)
	 * @date 2014-12-22  下午2:19:06
	 */
	@SuppressWarnings("rawtypes")
	public static Object convertMap2Entity(Map<String, Object> map,
			Class clazz) throws IntrospectionException,
			InstantiationException, IllegalAccessException {
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
		Object object = clazz.newInstance();
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		if (propertyDescriptors != null && propertyDescriptors.length > 0) {
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor property = propertyDescriptors[i];
				String propertyName = property.getName();
				System.out.println(propertyName);
				if (map.containsKey(propertyName)&&!"class,filter,types".contains(propertyName)) {
					Object propertyValue = map.get(propertyName);
					System.out.println(propertyName+":"+propertyValue);
					Object[] args = new Object[] { propertyValue };
					try {
						property.getWriteMethod().invoke(object, args);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return object;
	}
	
	/**
	 * .将实体类转换成Map
	 * @param entity 需要转换的实体类
	 * @return Map 
	 * @throws IntrospectionException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException Map<String,Object>
	 * @author admin(冯有双 E-mail:feng.youshuang@cesgroup.com.cn)
	 * @date 2014-12-22  下午3:12:20
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> convertEntity2Map(Object entity)
			throws IntrospectionException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Map<String, Object> map = new HashMap<String, Object>();
		Class clazz = entity.getClass();
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		if (propertyDescriptors != null && propertyDescriptors.length > 0) {
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor property = propertyDescriptors[i];
				String propertyName = property.getName();
				if (!"class,filter,types".contains(propertyName)) {
					try {
						Object propertyValue = property.getReadMethod().invoke(
								entity, new Object[0]);
						map.put(propertyName, propertyValue);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return map;
	}
	
	public static String disposeId(String idArray) {
		String ids = "";
		if (idArray != null) {
			String[] temp = idArray.split(",");
			for (int i = 0; i < temp.length; i++) {
				ids += ",'" + temp[i] + "'";
			}
			ids = ids.substring(1);
		}
		return ids;
	}
	private static final String[] chineseNumber = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };

	/**
	 * .将阿拉伯数字转换成中文数字
	 * @param number
	 * @return String
	 * @author admin(冯有双 E-mail:feng.youshuang@cesgroup.com.cn)
	 * @date 2014-12-25  上午11:03:40
	 */
	public static String convert2ChineseNumber(String number) {
		String chinese = "";
		if (number != null && !"".equals(number)) {
			for (int i = 0; i < number.length(); i++) {
				int num = Integer.parseInt(number.substring(i, i + 1));
				chinese += chineseNumber[num];
			}
		}
		return chinese;
	}

	/**
	 * 将日期转换为中文格式
	 *
	 * @param date
	 * @return
	 */
	public static String convert2ChineseDate(Date date) {
		String chinese = "";
		if (date != null) {
			String str = DateFormatUtils.format(date, "yyyy-M-d");
			String year = convert2ChineseNumber(str.substring(0,
					str.indexOf("-")));
			String month = convert2ChineseNumber(str.substring(
					str.indexOf("-") + 1, str.lastIndexOf("-")));
			String day = convert2ChineseNumber(str.substring(str
					.lastIndexOf("-") + 1));
			if (month.length() > 1) {
				if (month.startsWith("一")) {
					month = "十" + month.substring(1);
				} else {
					month = month.substring(0, 1) + "十" + month.substring(1);
				}
				if (month.endsWith("〇")) {
					month = month.substring(0, month.length() - 1);
				}
			}
			if (day.length() > 1) {
				if (day.startsWith("一")) {
					day = "十" + day.substring(1);
				} else {
					day = day.substring(0, 1) + "十" + day.substring(1);
				}
				if (day.endsWith("〇")) {
					day = day.substring(0, day.length() - 1);
				}
			}
			chinese = year + "年" + month + "月" + day + "日";
		}
		return chinese;
	}
	
	/**
	 * 计算两个日期间隔
	 * @param start 开始日期
	 * @param end 结束日期
	 * @return str
	 * @throws Exception
	 */
	public static String getDateDiff(String start, String end) throws Exception {
		String result = "";
		if (start == null || end == null) {
			return "";
		}
		Date sdate = DateUtil.parseDate(start);
		Date edate = DateUtil.parseDate(end);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdate);
		int yearStart = cal.get(Calendar.YEAR);
		int monthStart = cal.get(Calendar.MONTH) + 1;
		int dayStart = cal.get(Calendar.DATE);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(edate);

		int yearEnd = cal2.get(Calendar.YEAR);
		int monthEnd = cal2.get(Calendar.MONTH) + 1;
		int dayEnd = cal2.get(Calendar.DATE);

		int year = 0;
		int month = 0;
		int day = 0;
		if (sdate.after(edate)) {
			result = "";
		} else {
			if (isZhenYue(yearStart, monthStart, dayStart)
					&& isZhenYue(yearEnd, monthEnd, dayEnd)) {
				day = 0;
			} else if (isZhenYue(yearStart, monthStart, dayStart)
					&& !isZhenYue(yearEnd, monthEnd, dayEnd)) {
				day = dayEnd;
				monthEnd = monthEnd - 1;

			} else if (!isZhenYue(yearStart, monthStart, dayStart)
					&& isZhenYue(yearEnd, monthEnd, dayEnd)) {
				day = getMonthLast(yearStart, monthStart) - dayStart;
			} else {
				while (dayEnd < dayStart) {
					monthEnd = monthEnd - 1;
					if (monthEnd == 0 || monthEnd == 1 || monthEnd == 3
							|| monthEnd == 5 || monthEnd == 7 || monthEnd == 8
							|| monthEnd == 10) {
						dayEnd = dayEnd + 31;

					} else if (monthEnd == 4 || monthEnd == 6 || monthEnd == 9
							|| monthEnd == 11) {
						dayEnd = dayEnd + 30;
					} else {
						if (isLeapYear(yearEnd)) {
							dayEnd = dayEnd + 29;
						} else {
							dayEnd = dayEnd + 28;
						}
					}
				}
				day = dayEnd - dayStart;
			}

			if (monthEnd < monthStart) {
				yearEnd = yearEnd - 1;
				monthEnd = monthEnd + 12;
			}
			month = monthEnd - monthStart;
			year = yearEnd - yearStart;
			if (year != 0) {
				result += year + "年";
			}
			if (month != 0) {
				result += month + "个月";
			}
			if (day != 0) {
				result += day + "天";
			}
		}
		return result;
	}
	/**
	 * 判断是否润平年
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}
	/**
	 * 判断是否为整月
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static boolean isZhenYue(int year, int month, int day) {
		int maxDay = getMonthLast(year, month);
		if (day == maxDay) {
			return true;
		} else
			return false;
	}
	/**
	 * 获取的指定月最后一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthLast(int year, int month) {
		int maxDay = 0;
		int day = 1;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		maxDay = calendar.getActualMaximum(Calendar.DATE);
		return maxDay;
	}

	/**
	 * .生成UI随机字符串
	 * @return String
	 * @author admin(冯有双 E-mail:feng.youshuang@cesgroup.com.cn)
	 * @date 2015-1-14  上午11:10:49
	 */
	public static String generateUIId(){
		return "NS"+UUID.randomUUID().toString().replaceAll("-", "")+"_";
	}
	
	/**
	 * 小写转大写
	 * @param xiaoxie
	 * @return
	 */
	/**
     * 把金额阿拉伯数字转换为汉字表示，小数点后四舍五入保留两位
	 * 还有一种方法可以在转换的过程中不考虑连续0的情况，然后对最终的结果进行一次遍历合并连续的零
     */
	public static String [] ChineseNum = new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	public static String changeToBig(BigDecimal xiaoxie){
		double num = xiaoxie.doubleValue();
	    if(num > 99999999999999.99 || num < -99999999999999.99)
            throw new IllegalArgumentException("参数值超出允许范围 (-99999999999999.99 ～ 99999999999999.99)！");
		boolean negative = false;//正负标号
		if(num<0){
			negative = true;
			num = num*(-1);
		}
		long temp = Math.round(num*100);
		int numFen=(int)(temp%10);//分
		temp=temp/10;
		int numJiao = (int)(temp%10);//角
		temp=temp/10;
		//此时temp只包含整数部分
		int [] parts =new int[20];//将金额整数部分分为在0-9999之间数的各个部分
		int numParts = 0;//记录把原来金额整数部分分割为几个部分 
		for(int i=0;;i++){
			if(temp == 0)
				break;
			int part = (int)(temp%10000);
			parts[i] =part;
			temp = temp/10000;
			numParts++;
		}
		boolean beforeWanIsZero = true;//标志位，记录万的下一级是否为0
		String chineseStr = "";
		for(int i=0;i<numParts;i++){
			String partChinese = partConvert(parts[i]);
			if(i%2==0){
				if("".equals(partChinese))
					beforeWanIsZero = true;
				else
					beforeWanIsZero = false;
			}
			if(i!=0){
				if(i%2==0)//亿的部分
					chineseStr = "亿"+chineseStr;
				else{
					if("".equals(partChinese)&&!beforeWanIsZero)// 如果“万”对应的 part 为 0，而“万”下面一级不为 0，则不加“万”，而加“零”
						chineseStr = "零"+chineseStr;
					else{
						if(parts[i-1]<1000&&parts[i-1]>0)//如果万的部分不为0，而万前面的部分小于1000大于0，则万后面应该跟零
							chineseStr = "零"+chineseStr;
						chineseStr = "万"+chineseStr;
					}
				}
			}
			chineseStr = partChinese + chineseStr;
		}
		if("".equals(chineseStr))//整数部分为0，则表示为零圆
			chineseStr = ChineseNum[0];
		else if(negative)//整数部分部位0，但是为负数
			chineseStr = "负" +chineseStr;
		chineseStr = chineseStr + "圆";
		if(numFen==0&&numJiao==0){
			chineseStr = chineseStr +"整";
		}
		else if(numFen==0){//0分
			chineseStr = chineseStr +ChineseNum[numJiao] + "角";
		}
		else{
			if(numJiao==0)
				chineseStr = chineseStr + "零" + ChineseNum[numFen] + "分";
            else
                chineseStr = chineseStr + ChineseNum[numJiao] + "角" + ChineseNum[numFen] + "分";
		}
		return chineseStr;
	}
	//转换拆分后的每个部分，0-9999之间
	public static String partConvert(int partNum){
		if(partNum<0||partNum>10000){
			throw new IllegalArgumentException("参数必须是大于等于0或小于10000的整数");
		}
		String [] units = new String[]{"","拾","佰","仟"};
		int temp = partNum;
		String partResult = new Integer(partNum).toString();
		int partResultLength = partResult.length();
		boolean lastIsZero = true;//记录上一位是否为0
		String chineseStr = "";
		for(int i=0;i<partResultLength;i++){
			if(temp == 0)//高位无数字
				break;
			int digit = temp%10;
			if(digit == 0){
				if(!lastIsZero)//如果前一个数字不是0则在当前汉字串前加零
					chineseStr = "零"+chineseStr;
				lastIsZero = true;
			}
			else{
				chineseStr = ChineseNum[digit] + units[i] +chineseStr;
				lastIsZero = false;
			}
			temp =temp/10;
		}
		return chineseStr;	
	}
	
	
	
	
	
	
	
//	public static String changeToBig(BigDecimal xiaoxie){
//		StringBuffer bigType = new StringBuffer();
//		if(xiaoxie==null){
//			return "";
//		}
//		if(xiaoxie.doubleValue()==0){
//			return "零圆";
//		}
//		String[] hunit = { "拾", "佰", "仟" };
//		String[] vunit = { "万", "亿" };
//		String[] digit = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
//		BigDecimal midVal = xiaoxie.multiply(new BigDecimal(100));
//		StringBuffer valStr = new StringBuffer(midVal.toString());
//        if(valStr.indexOf(".")>0){
//			valStr = new StringBuffer(valStr.substring(0,valStr.indexOf(".")));	
//		}
//
//        StringBuffer head = new StringBuffer(valStr.substring(0, valStr.length()- 2)); 
//        StringBuffer rail = new StringBuffer(valStr.substring(valStr.length() - 2)); // 取小数部分
//        StringBuffer prefix = new StringBuffer(); // 整数部分转化的结果
//        StringBuffer suffix = new StringBuffer(); // 小数部分转化的结果
//		// 处理小数点后面的数
//		if ("00".equals(rail.toString())) { // 如果小数部分为0
//			suffix = new StringBuffer("整");
//		} else {
//			//rail.charAt(0) - '0'进行运算过后就是数字
//			suffix = new StringBuffer(digit[rail.charAt(0) - '0'] + "角" + digit[rail.charAt(1) - '0'] + "分"); // 否则把角分转化出来
//		}
//		// 处理小数点前面的数
//		
//		char[] chDig = new char[head.length()]; // 把整数部分转化成字符数组
//		for(int i = 0;i<head.length();i++){
//			chDig[i]=head.charAt(i);
//		}
//		StringBuffer zero = new StringBuffer("0"); // 标志'0′表示出现过0
//		int zeroSerNum = 0; // 连续出现0的次数
//		for (int i = 0; i < chDig.length; i++) {
//			int idx = (chDig.length - i - 1) % 4; // 取段内位置
//			int vidx = (chDig.length - i - 1) / 4; // 取段位置
//			if (chDig[i]=='0') { // 如果当前字符是0
//				zeroSerNum++; // 连续0次数递增
//				if ("0".equals(zero.toString())) { // 标志第一次出现0
//		    		zero = new StringBuffer(digit[0]);
//		     	//idex==0表示是段位的结尾;zeroSerNum表示这个段位有数字,不全部为0
//		    	} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
//		    		prefix.append(vunit[vidx - 1]);//单位:万,亿
//		     		zero = new StringBuffer("0");
//		    	}
//		    	continue;
//			}
//			zeroSerNum = 0; // 连续0次数清零
//			if (!"0".equals(zero.toString())) { // 如果标志不为0,则加上,例如万,亿什么的
//				prefix.append(zero);
//				zero = new StringBuffer("0");
//			}
//			prefix.append(digit[chDig[i] - '0']); // 转化该数字表示
//			if (idx > 0)
//				prefix.append(hunit[idx - 1]);//单位:拾,佰,仟
//			//段位大于0,段内位置是末尾
//			if (idx == 0 && vidx > 0) {
//				prefix.append(vunit[vidx - 1]); // 段结束位置应该加上段名如万,亿
//			}
//		}
//		if (prefix.length() > 0){
//			prefix.append("圆");
//		}
//		    
//		bigType.append(prefix).append(suffix); // 返回正确表示	
//		
//		return bigType.toString();
//	}
	
	public static void main(String[] args) {
		//changeToBig(new BigDecimal("23001001.14"));
	}
}
