package com.zhangyaoxing.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomUtil {
	//方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。 (5分)
	public static int random(int min, int max){
		Random random = new Random();
		int nextInt = random.nextInt((max-min+1)+min);//随机返回一个int类型的随机数  最大值和最小值区间的公式   (max-min+1)+min
		return nextInt;
	//TODO 实现代码
	}
	//方法2：在最小值min与最大值max之间截取subs个不重复的随机数。例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。 (8分)
	public static int[] subRandom (int min, int max, int subs){
		
		HashSet<Integer> hashSet = new HashSet<Integer>();//创建一个hashset 因为他的值不可以重复
		while(hashSet.size()!=subs) {//如果hashset的长度没有到我想要的长度  就不停止 
			int random = random(min, max);
			hashSet.add(random);//循环结束后 长度 够了  值没有重复
		}
		//因为 返回值类型是数组所以
		int[] in=new int[subs];//创建一个 符合长度的数组
		int i=0;
		for (Integer integer : hashSet) {
			in[i]=integer;
			i++;
		}
		return in;
	//TODO 实现代码
	}
	//方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
	public static char randomCharacter (){
		String str="123456789qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSZXCVBNMA";
		char charAt = str.charAt(random(0,str.length()-1));//charAt()  里面是一个下标  去一个指定下标的对应的值 转换成char类型
		return charAt;
	//TODO 实现代码
	}
	//方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
	public static String randomString(int length){
		String str="";
		for (int i = 0; i < length; i++) {
			char randomCharacter = randomCharacter();
			str+=randomCharacter;
		}
		return str;
	//TODO 实现代码
	}
	//
	public static Date randomdateMonth(Date date) {
		Calendar instance = Calendar.getInstance();//日历类 有当前时间 java.util.GregorianCalendar[time=1575593923258,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,MONTH=11,WEEK_OF_YEAR=49,WEEK_OF_MONTH=1,DAY_OF_MONTH=6,DAY_OF_YEAR=340,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=8,HOUR_OF_DAY=8,MINUTE=58,SECOND=43,MILLISECOND=258,ZONE_OFFSET=28800000,DST_OFFSET=0]
		instance.setTime(date);//把当前时间存入  日历类
		instance.set(Calendar.DAY_OF_MONTH,2);//当月的天数  是  +1
		instance.set(Calendar.HOUR_OF_DAY,0);//HOUR  小时
		instance.set(Calendar.MINUTE,0);//MINUTE  分钟
		instance.set(Calendar.SECOND,0);//SECOND  秒
		System.out.println();
		//instance.add(Calendar.MONTH, 1);//Calendar.MONTH 获取当前月份  instance.add(Calendar.MONTH, 1)当前月份+1
		
		return instance.getTime();
	}
	// 返回个某一个时间段的随机日期
	public static Date randomdate(Date mindate, Date maxdate) {
		long time = mindate.getTime();//时间 是以毫秒值在走的   gettime()  是取得毫秒值
		long time2 = maxdate.getTime();
		long lon=(long)(Math.random()*((time2-time+1)+time));//返回个某一个时间段的随机 毫秒值
		return new Date(lon);//把lon 放入date 返回 随机 毫秒值对应的时间
	}
}
