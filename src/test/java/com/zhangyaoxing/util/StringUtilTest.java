package com.zhangyaoxing.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void getLastNumber() {
		String lastNumber = StringUtil.getLastNumber("http://news.cnstock.com/news,yw-201908-4413224.htm");
		System.out.println("lastNumber==="+lastNumber);
	}
	@Test
	public void testIsPhoneNumber() {
		boolean phoneNumber = StringUtil.isPhoneNumber("13123456789");
		System.out.println(phoneNumber);
	}
	@Test
	public void testIsEmail() {
		boolean number = StringUtil.isEmail("xx");
		System.out.println(number);
	}
	@Test
	public void testIsNumber() {
		boolean number = StringUtil.isNumber("0.1");
		System.out.println(number);
	}
	
	@Test
	public void testHasLength() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasText() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChinese() {
		fail("Not yet implemented");
	}

	@Test
	public void testRandomChineseString() {
		String randomChineseString = StringUtil.randomChineseString(2);
		System.out.println(randomChineseString);
	}

	@Test
	public void testGenerateChineseName() {
		fail("Not yet implemented");
	}

}
