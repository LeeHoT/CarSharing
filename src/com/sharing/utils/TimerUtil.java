package com.sharing.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具
 * 
 * @author leehot(李慧婷)
 *
 */
public class TimerUtil {

	/**
	 * 转换Date型到String 型, 格式为yyyy年MM月dd日
	 * 
	 * @param date
	 * @return yyyy年MM月dd日
	 */
	public String transDate2String(Date date) {
		String re_time = null;
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		re_time = sdf.format(date);
		return re_time;

	}

	/**
	 * 转换String型到Date 型, 格式为Thu Oct 06 00:00:00 CST 2016
	 * 
	 * @param date
	 * @return Thu Oct 06 00:00:00 CST 2016
	 */
	public Date transString2Date(String time) {
		System.out.println(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
