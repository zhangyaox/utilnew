package com.zhangyaoxing.util;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateutilTest {

	@Test
	public void testGetAge() {
		Calendar c = Calendar.getInstance();
		c.set(1994, 12, 5);
		Date time = c.getTime();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		simpleDateFormat.format(date)
		int age = Dateutil.getAge(time);
		System.out.println("-----"+age);
	}

}
