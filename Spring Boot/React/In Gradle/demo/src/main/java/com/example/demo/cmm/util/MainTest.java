package com.example.demo.cmm.util;

public class MainTest {
	public static void main(String[] args) {
		// Proxy.print.accept("헬로 람다");
		// System.out.print("헬로 람다");
		
		int i = Proxy.i4.apply("FF", 16);
		System.out.println(i);
	}
}
