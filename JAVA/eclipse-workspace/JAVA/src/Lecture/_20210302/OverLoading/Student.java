package Lecture._20210302.OverLoading;

public class Student {
	private int number;
	
	private String name;
	private int age;
	
	Student() {
		// this : 현재 사용하고 있는 객체의 변수
		number = 100;
		name = "New Student";
		age = 18;
	}
	
	Student(int number, String name, int age) {
		this.number = number;
		this.name = name;
		this.age = age;
	}
	
}
