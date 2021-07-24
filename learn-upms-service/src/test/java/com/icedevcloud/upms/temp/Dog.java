package com.icedevcloud.upms.temp;

public class Dog extends Animal {
	public Dog(String name) {
		setName(name);
	}
	public void eat() {
		System.out.println(getName()+"在吃东西.....");
	}
}