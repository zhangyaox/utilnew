package com.zhangyaoxing.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: Dateutil 
 * @Description: TODO
 * @author: 13362
 * @date: 2019��12��6�� ����2:49:19
 */
public class Dateutil {
	/**
	 * ���ݳ������ڻ�ȡ����
	 */
	public static int getAge(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int oldYear = c.get(c.YEAR);
		int oldMONTH = c.get(c.MONTH);
		int oldDay = c.get(c.DAY_OF_MONTH);
		
		c.setTime(new Date());
		int newYear = c.get(c.YEAR);
		int newMONTH = c.get(c.MONTH);
		int newDay = c.get(c.DAY_OF_MONTH);
		System.out.println("newYear"+newYear+"oldYear="+oldYear);
		int age=newYear-oldYear;
		
		if(newMONTH<oldMONTH) {
			age--;
		}
		if(newMONTH==oldMONTH&&newDay<oldDay) {
				age--;
		}
		return age;
	}
}
