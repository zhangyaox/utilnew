package com.zhangyaoxing.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	/**
	 * @Title: writeFile
	 * @Description: ����ָ���ı��������д��ָ�����ļ���
	 * @param path
	 * @param content
	 * @param charset
	 * @throws IOException
	 * @return: void
	 */
	public static void writeFile(String path, String content, String charset) throws IOException {
		// ����д����ļ�
		File file = new File(path);
		// �жϸ�Ŀ¼�Ƿ����
		if (!file.getParentFile().exists()) {
			// ������Ŀ¼
			file.getParentFile().mkdirs();
		}
		// �������������
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bw.write(content);
		bw.flush();
		bw.close();
	}

	/**
	 * @Title: readFile
	 * @Description: ��ȡ�ļ�����
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readFile(File file, String charset) throws IOException {
		// �������������
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		// ���建�����
		StringBuffer sb = new StringBuffer();
		// �����ȡÿ�еĽ��
		String content = null;
		// ѭ����ȡ
		while ((content = br.readLine()) != null) {
			// ���뻺�����
			sb.append(content);
		}
		// �ر���
		br.close();
		// ���ؽ��
		return sb.toString();

	}
	
	public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    //������ɵ绰����133��ͷ
    private static String[] telFirst = "133".split(",");
    public static String getPhone(){
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+thrid;

    }
	
	//�����������
    public static String getBirthday(){
        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1949, 2001);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    //�����������
    public static String getMail(){
        String [] last = {"@qq.com", "@gmail.com", "@163.com", "@sina.com", "@hotmail.com", "@sohu.com"};
        StringBuffer sb = new StringBuffer();
        // 3~20���ȣ�����3��20
        int length = 3 + (int) (Math.random() * 9);
        String word = "";
        for (int i = 0; i < length; i++) {
            word += (char) randomChar();
        }
        sb.append(word);
        Random r = new Random();
        final int j = r.nextInt(6);
        sb.append(last[j]);
        return sb.toString();
    }
    private static byte randomChar() {
        // 0<= Math.random()< 1
        int flag = (int) (Math.random() * 2);// 0Сд��ĸ1��д��ĸ
        byte resultBt;
        if (flag == 0) {
            byte bt = (byte) (Math.random() * 26);// 0 <= bt < 26
            resultBt = (byte) (65 + bt);
        } else {
            byte bt = (byte) (Math.random() * 26);// 0 <= bt < 26
            resultBt = (byte) (97 + bt);
        }
        return resultBt;
    }
	
	//�����������
    public static String getName(){
        String name = "";
//        System.out.println(c);
        for (int i = 0; i <3 ; i++) {
            char c = (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
            name+=c;
        }
        return name;
    }
    //��������Ա�
    public static String getSex(){
        Random r = new Random();
        int i = r.nextInt(2);
        if(i==0){
            return "��";
        }else{
            return "Ů";
        }

    }

	
	/**
	 * У�鴫��Ĳ����Ƿ�Ϊurl
	 * @param param
	 * @return
	 */
	public static boolean isHttpUrl(String param) {
		 URL url;  
		 try {  
	         url = new URL(param);
	        url.openStream();  
	         return true; 
	    } catch (Exception e1) {  
	         System.out.println("���Ӵ򲻿�!");  

	    }  
		 return false;

	}
	
	public static BufferedReader read(InputStream in){
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		return bufferedReader;
	}
	/*
	* �������ܣ������������ַ�����ȡһ��ֵ�����ں�����url��ַ����ȡIDֵ
	* �����ڡ�http://news.cnstock.com/news,yw-201908-4413224.htm���ѡ�4413224����ȡ������
	*/
	public static String getLastNumber(String url) {
		String regex ="[0-9]+(?=[^0-9]*$)";
	    //�������
		Pattern c = Pattern.compile(regex);
		//ƥ��
		Matcher m = c.matcher(url);
		if(m.find()) {
			return m.group();
		}
		return null;
		
	}
	//�Ƿ����ֻ������� 11λ
	public static boolean isPhoneNumber(String phone) {
		if(hasText(phone)) {
			String str="1[3|4|5|6|7|8|9]\\d{9}";
			return phone.matches(str);
		}else {
			return false;
		}
	}
	//�Ƿ�����������
	public static boolean isEmail(String email) {
		if(hasText(email)) {
			String str="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";//\\w+\\@\\w+\\.\\w+
			return email.matches(str);
		}else {
			return false;
		}
	}
	//�ж��Ƿ�����ֵ����
	public static boolean isNumber(String str) {
		String st="(-)?\\d+\\.?(\\d+)?";
		return str.matches(st);
	}
	//����1���ж�Դ�ַ����Ƿ���ֵ��������(�հ��ַ���)Ҳ��ûֵ (5��)
	public static boolean hasLength(String src){
		return null!=src&&src!="";
	//TODO ʵ�ִ���
	}
	//����2���ж�Դ�ַ����Ƿ���ֵ��������(�հ��ַ���)�Ϳո�Ҳ��ûֵ (5��)
	public static boolean hasText(String src){
		//String trim = src.trim();//ȥ���ո�
		return src!=null&&src.trim().length()>0;
	//TODO ʵ�ִ���
	}
	//����һ������
	public static String getChinese() {
		 String str = null;
         int highPos, lowPos;
         Random random = new Random();
         highPos = (176 + Math.abs(random.nextInt(40)));//���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������
         random=new Random();
         lowPos = 161 + Math.abs(random.nextInt(95));//λ�룬0xA0��ͷ����Χ��1~94��
         byte[] bArr = new byte[2];
        
         bArr[0] = (new Integer(highPos)).byteValue();
         bArr[1] = (new Integer(lowPos)).byteValue();
         try {
             str = new String(bArr, "GB2312");   //��λ����ϳɺ���
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         }
             return str;
	}
	//����3�����ز���length�����ĺ����ַ������ַ���������GB2312(�൱�����ļ���)��Χ�ڣ����硰��ѽ����(5��)
	public static String randomChineseString(int length){
		String name="";
		for (int i = 0; i < length; i++) {
			name+= getChinese();
		}
		return name;
	//TODO ʵ�ִ���
	}
	//����4������������������������ʵ�տ�ͷ���ټ����ڡ��������ټ��ա����ʹ��1-2���������(8��)���ڲ�����randomChineseString()����(3��)������ʾ��������ѽ��������ŷ����Ϊ��
	public static String generateChineseName(){
		String name[]= {"��","Ǯ","��","��","��","��","֣","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ʩ","��","��","��","��","��","��","κ","��","��","��","л","��","��","��","ˮ","�","��","��","��","��","��","��","��","��","��","³","Τ","��","��","��","��","��","��","��","��","Ԭ","��","ۺ","��","ʷ","��","��","��","�","Ѧ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ʱ","��","Ƥ","��","��","��","��","��","Ԫ","��","��","��","ƽ","��","��","��","��","��","Ҧ","��","տ","��","��","ë","��","��","��","��","��","�","��","��","��","��","̸","��","é","��","��","��","��","��","��","ף","��","��","��","��","��","��","ϯ","��","��","ǿ","��","·","¦","Σ","��","ͯ","��","��","÷","ʢ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","֧","��","��","��","¬","Ī","��","��","��","��","��","��","Ӧ","��","��","��","��","��","��","��","��","��","��","��","��","ʯ","��","��","ť","��","��","��","��","��","��","½","��","��","��","��","�","��","��","�L","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ɽ","��","��","��","�","��","ȫ","ۭ","��","��","��","��","��","��","��","��","��","��","��","б","��","��","��","��","��","��","��","ղ","��","��","Ҷ","��","˾","��","۬","��","��","��","ӡ","��","��","��","��","ۢ","��","��","��","��","��","��","׿","��","��","��","��","��","��","��","��","��","��","˫","��","ݷ","��","��","̷","��","��","��","��","��","��","��","Ƚ","��","۪","Ӻ","�S","�","ɣ","��","�","ţ","��","ͨ","��","��","��","��","ۣ","��","��","ũ","��","��","ׯ","��","��","��","��","��","Ľ","��","��","ϰ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","»","��","��","ŷ","�","��","��","ε","Խ","��","¡","ʦ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ɳ","ؿ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","Ȩ","��","��","��","��","��","��","��","��","��","��","۳","Ϳ","��","��","˧","��","��","��","��","��","��","��","Ĳ","��","٦","��","��","ī","��","��","��","��","��","��","١","��ٹ","˾��","�Ϲ�","ŷ��","�ĺ�","���","����","����","����","�ʸ�","ξ��","����","�̨","��ұ","����","���","����","����","̫��","����","����","����","��ԯ","���","����","����","����","Ľ��","����","����","˾ͽ","˾��","آ��","˾��","��","��","�ӳ�","���","��ľ","����","����","���","����","����","����","�ذ�","�й�","�׸�","����","�θ�","����","����","����","����","��","��","����","΢��","����","����","����","����","�Ϲ�"};
		int random = RandomUtil.random(0, name.length-1);
		String randomChineseString = randomChineseString(2);
		return name[random]+randomChineseString;
	//TODO ʵ�ִ���
	}

}
