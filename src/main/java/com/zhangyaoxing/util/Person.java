package com.zhangyaoxing.util;

import java.util.Date;

/**
 * 
 * @ClassName: Person 
 * @Description: TODO
 * @author: 13362
 * @date: 2019年12月5日 下午9:24:44
 * 
 * 姓名(name)、年龄(age)、介绍(about)、注册日期(created)
 */
public class Person {
	private String name;
	private String age;
	private String about;
	private Date created;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String age, String about, Date created) {
		super();
		this.name = name;
		this.age = age;
		this.about = about;
		this.created = created;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", about=" + about + ", created=" + created + "]";
	}
	
}
