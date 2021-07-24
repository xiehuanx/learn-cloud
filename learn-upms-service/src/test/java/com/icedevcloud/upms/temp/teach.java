package com.icedevcloud.upms.temp;
public class teach{
	public static void main(String[] agrs) {
		/*Student stu = new Student(); //无参构造方法
		stu.setName("辉哥");
		stu.setAge(1000);
		stu.setBanji(1990002);*/
	    Student stu = new Student("辉哥",100,"java2222");
	    //public static stu.name("辉哥");静态属性、静态方法、静态代码块
		stu.show();
		//stu.xueXi();
		Teacher stu1 = new Teacher();
		stu1.name = ("伍玉辉");	
		stu1.age = 17;
		stu1.banJi = ("1990002");
		stu1.show();
	}
}
class Teacher extends Student{ //继承
	
}
class Student{
	public String name;
	public int age;
	public String banJi;
	//构造方法
	public Student(){}
	public Student(String name,int age,String banJi){
		this.name = name;
		this.age = age;
		this.banJi = banJi;
		
		}
	//成员方法
	public void show() {  //普通方法可以调用一切方法
		System.out.println(name+" "+age+" "+banJi);
		xueXi();
	   	}
	//静态方法
	public static void xueXi(){//静态方法里面只能调用静态方法
		System.out.println("各种学习");
		System.out.println("各种作业");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBanJi() {
		return banJi;
	}

	public void setBanJi(String banJi) {
		this.banJi = banJi;
	}
}