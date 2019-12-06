package com.zhangyaoxing.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomUtil {
	//����1������min-max֮����������������min��maxֵ�������緵��1-3֮������������ô����1��2��3������ȷ�ģ�����4�Ͳ��ԡ� (5��)
	public static int random(int min, int max){
		Random random = new Random();
		int nextInt = random.nextInt((max-min+1)+min);//�������һ��int���͵������  ���ֵ����Сֵ����Ĺ�ʽ   (max-min+1)+min
		return nextInt;
	//TODO ʵ�ִ���
	}
	//����2������Сֵmin�����ֵmax֮���ȡsubs�����ظ����������������1-10֮��ȡ3�����ظ������������ô[2,6,9]�ǶԵģ�[3,5,5]�򲻶ԣ���Ϊ5�ظ��ˡ�Ӧ�ó�������100ƪ���������ȡ10ƪ���£��¿����ܻ�ʹ�õ��� (8��)
	public static int[] subRandom (int min, int max, int subs){
		
		HashSet<Integer> hashSet = new HashSet<Integer>();//����һ��hashset ��Ϊ����ֵ�������ظ�
		while(hashSet.size()!=subs) {//���hashset�ĳ���û�е�����Ҫ�ĳ���  �Ͳ�ֹͣ 
			int random = random(min, max);
			hashSet.add(random);//ѭ�������� ���� ����  ֵû���ظ�
		}
		//��Ϊ ����ֵ��������������
		int[] in=new int[subs];//����һ�� ���ϳ��ȵ�����
		int i=0;
		for (Integer integer : hashSet) {
			in[i]=integer;
			i++;
		}
		return in;
	//TODO ʵ�ִ���
	}
	//����3������1��1-9,a-Z֮�������ַ��� (8��)
	public static char randomCharacter (){
		String str="123456789qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSZXCVBNMA";
		char charAt = str.charAt(random(0,str.length()-1));//charAt()  ������һ���±�  ȥһ��ָ���±�Ķ�Ӧ��ֵ ת����char����
		return charAt;
	//TODO ʵ�ִ���
	}
	//����4�����ز���length���ַ���(5��)�������ڲ�Ҫ����randomCharacter()���� (4��)
	public static String randomString(int length){
		String str="";
		for (int i = 0; i < length; i++) {
			char randomCharacter = randomCharacter();
			str+=randomCharacter;
		}
		return str;
	//TODO ʵ�ִ���
	}
	//
	public static Date randomdateMonth(Date date) {
		Calendar instance = Calendar.getInstance();//������ �е�ǰʱ�� java.util.GregorianCalendar[time=1575593923258,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,MONTH=11,WEEK_OF_YEAR=49,WEEK_OF_MONTH=1,DAY_OF_MONTH=6,DAY_OF_YEAR=340,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=8,HOUR_OF_DAY=8,MINUTE=58,SECOND=43,MILLISECOND=258,ZONE_OFFSET=28800000,DST_OFFSET=0]
		instance.setTime(date);//�ѵ�ǰʱ�����  ������
		instance.set(Calendar.DAY_OF_MONTH,2);//���µ�����  ��  +1
		instance.set(Calendar.HOUR_OF_DAY,0);//HOUR  Сʱ
		instance.set(Calendar.MINUTE,0);//MINUTE  ����
		instance.set(Calendar.SECOND,0);//SECOND  ��
		System.out.println();
		//instance.add(Calendar.MONTH, 1);//Calendar.MONTH ��ȡ��ǰ�·�  instance.add(Calendar.MONTH, 1)��ǰ�·�+1
		
		return instance.getTime();
	}
	// ���ظ�ĳһ��ʱ��ε��������
	public static Date randomdate(Date mindate, Date maxdate) {
		long time = mindate.getTime();//ʱ�� ���Ժ���ֵ���ߵ�   gettime()  ��ȡ�ú���ֵ
		long time2 = maxdate.getTime();
		long lon=(long)(Math.random()*((time2-time+1)+time));//���ظ�ĳһ��ʱ��ε���� ����ֵ
		return new Date(lon);//��lon ����date ���� ��� ����ֵ��Ӧ��ʱ��
	}
}
