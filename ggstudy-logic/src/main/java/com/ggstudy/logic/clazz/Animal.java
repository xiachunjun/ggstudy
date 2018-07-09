package com.ggstudy.logic.clazz;

public abstract class Animal {
	public void fly() {
		System.out.println("Animal fly!");
		this.biubiubiu();
	}
	
	abstract void biubiubiu();
}
