package com.kh.test.shape.model.vo;

public class Circle {
	public static double PI = 3.14;
	private double radius;
	

	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() { 
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getPi() {
		return PI;
	}
	
	public void draw( ) {
		System.out.println("반지름" + radius + "cm인 원를 그립니다.");
	}
}
