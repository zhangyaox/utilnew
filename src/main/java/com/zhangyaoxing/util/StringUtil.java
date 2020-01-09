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
	 * @Description: 按照指定的编码把内容写入指定的文件中
	 * @param path
	 * @param content
	 * @param charset
	 * @throws IOException
	 * @return: void
	 */
	public static void writeFile(String path, String content, String charset) throws IOException {
		// 创建写入的文件
		File file = new File(path);
		// 判断父目录是否存在
		if (!file.getParentFile().exists()) {
			// 创建父目录
			file.getParentFile().mkdirs();
		}
		// 创建输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bw.write(content);
		bw.flush();
		bw.close();
	}

	/**
	 * @Title: readFile
	 * @Description: 读取文件内容
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readFile(File file, String charset) throws IOException {
		// 创建输出流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		// 定义缓冲对象
		StringBuffer sb = new StringBuffer();
		// 定义读取每行的结果
		String content = null;
		// 循环读取
		while ((content = br.readLine()) != null) {
			// 加入缓冲对象
			sb.append(content);
		}
		// 关闭流
		br.close();
		// 返回结果
		return sb.toString();

	}
	
	public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    //随机生成电话号码133开头
    private static String[] telFirst = "133".split(",");
    public static String getPhone(){
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+thrid;

    }
	
	//随机生成生日
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
    //随机生成邮箱
    public static String getMail(){
        String [] last = {"@qq.com", "@gmail.com", "@163.com", "@sina.com", "@hotmail.com", "@sohu.com"};
        StringBuffer sb = new StringBuffer();
        // 3~20长度，包含3及20
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
        int flag = (int) (Math.random() * 2);// 0小写字母1大写字母
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
	
	//随机生成名字
    public static String getName(){
        String name = "";
//        System.out.println(c);
        for (int i = 0; i <3 ; i++) {
            char c = (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
            name+=c;
        }
        return name;
    }
    //随机生成性别
    public static String getSex(){
        Random r = new Random();
        int i = r.nextInt(2);
        if(i==0){
            return "男";
        }else{
            return "女";
        }

    }

	
	/**
	 * 校验传入的参数是否为url
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
	         System.out.println("连接打不开!");  

	    }  
		 return false;

	}
	
	public static BufferedReader read(InputStream in){
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		return bufferedReader;
	}
	/*
	* 方法功能：根据正则在字符串提取一段值，用于后面在url地址里提取ID值
	* 例如在“http://news.cnstock.com/news,yw-201908-4413224.htm”把“4413224”提取出来。
	*/
	public static String getLastNumber(String url) {
		String regex ="[0-9]+(?=[^0-9]*$)";
	    //编译规则
		Pattern c = Pattern.compile(regex);
		//匹配
		Matcher m = c.matcher(url);
		if(m.find()) {
			return m.group();
		}
		return null;
		
	}
	//是否是手机号类型 11位
	public static boolean isPhoneNumber(String phone) {
		if(hasText(phone)) {
			String str="1[3|4|5|6|7|8|9]\\d{9}";
			return phone.matches(str);
		}else {
			return false;
		}
	}
	//是否是邮箱类型
	public static boolean isEmail(String email) {
		if(hasText(email)) {
			String str="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";//\\w+\\@\\w+\\.\\w+
			return email.matches(str);
		}else {
			return false;
		}
	}
	//判断是否是数值类型
	public static boolean isNumber(String str) {
		String st="(-)?\\d+\\.?(\\d+)?";
		return str.matches(st);
	}
	//方法1：判断源字符串是否有值，空引号(空白字符串)也算没值 (5分)
	public static boolean hasLength(String src){
		return null!=src&&src!="";
	//TODO 实现代码
	}
	//方法2：判断源字符串是否有值，空引号(空白字符串)和空格也算没值 (5分)
	public static boolean hasText(String src){
		//String trim = src.trim();//去掉空格
		return src!=null&&src.trim().length()>0;
	//TODO 实现代码
	}
	//返回一个中文
	public static String getChinese() {
		 String str = null;
         int highPos, lowPos;
         Random random = new Random();
         highPos = (176 + Math.abs(random.nextInt(40)));//区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
         random=new Random();
         lowPos = 161 + Math.abs(random.nextInt(95));//位码，0xA0打头，范围第1~94列
         byte[] bArr = new byte[2];
        
         bArr[0] = (new Integer(highPos)).byteValue();
         bArr[1] = (new Integer(lowPos)).byteValue();
         try {
             str = new String(bArr, "GB2312");   //区位码组合成汉字
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         }
             return str;
	}
	//方法3：返回参数length个中文汉字字符串，字符集必须在GB2312(相当于中文简体)范围内，例如“中呀被”(5分)
	public static String randomChineseString(int length){
		String name="";
		for (int i = 0; i < length; i++) {
			name+= getChinese();
		}
		return name;
	//TODO 实现代码
	}
	//方法4：返回中文姓名，必须以真实姓开头，百家姓在“六、附百家姓”里，名使用1-2个随机汉字(8分)，内部调用randomChineseString()方法(3分)。返回示例：“刘呀被”、“欧阳及为”
	public static String generateChineseName(){
		String name[]= {"赵","钱","孙","李","周","吴","郑","王","冯","陈","楮","卫","蒋","沈","韩","杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁","杜","阮","蓝","闽","席","季","麻","强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","锺","徐","丘","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应","宗","丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢","滑","裴","陆","荣","翁","荀","羊","於","惠","甄","麹","家","封","芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓","牧","隗","山","谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫","宁","仇","栾","暴","甘","斜","厉","戎","祖","武","符","刘","景","詹","束","龙","叶","幸","司","韶","郜","黎","蓟","薄","印","宿","白","怀","蒲","邰","从","鄂","索","咸","籍","赖","卓","蔺","屠","蒙","池","乔","阴","郁","胥","能","苍","双","闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍","郤","璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","郏","浦","尚","农","温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习","宦","艾","鱼","容","向","古","易","慎","戈","廖","庾","终","暨","居","衡","步","都","耿","满","弘","匡","国","文","寇","广","禄","阙","东","欧","殳","沃","利","蔚","越","夔","隆","师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空","曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","后","荆","红","游","竺","权","逑","盖","益","桓","公","晋","楚","阎","法","汝","鄢","涂","钦","岳","帅","缑","亢","况","后","有","琴","商","牟","佘","佴","伯","赏","墨","哈","谯","笪","年","爱","阳","佟","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方","赫连","皇甫","尉迟","公羊","澹台","公冶","宗政","濮阳","淳于","单于","太叔","申屠","公孙","仲孙","轩辕","令狐","锺离","宇文","长孙","慕容","鲜于","闾丘","司徒","司空","丌官","司寇","仉","督","子车","颛孙","端木","巫马","公西","漆雕","乐正","壤驷","公良","拓拔","夹谷","宰父","谷梁","段干","百里","东郭","南门","呼延","归","海","羊舌","微生","梁丘","左丘","东门","西门","南宫"};
		int random = RandomUtil.random(0, name.length-1);
		String randomChineseString = randomChineseString(2);
		return name[random]+randomChineseString;
	//TODO 实现代码
	}

}
