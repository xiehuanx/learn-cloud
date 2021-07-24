package com.icedevcloud.upms.temp;

import java.util.Scanner;

public class HomeWork {
	
	public static void main(String[] args) {
		RectTangle stu = new RectTangle();
		Scanner scanner = new Scanner(System.in);
		System.out.print("长方形的长为：");
		stu.length = scanner.nextDouble();
		System.out.print("长方形的宽为：");
		stu.width = scanner.nextDouble();
		System.out.print("面积为：" + stu.area() + " " + "周长为:" + stu.zhouChang());

	}
}

class RectTangle {
	double length;
	double width;
	public double area() {    //方法得到一个值需要返回才可以
		return length*length;
	}
	public double zhouChang() {
		return (length + width) * 2;
	}
}