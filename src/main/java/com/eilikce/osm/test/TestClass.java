package com.eilikce.osm.test;

import org.springframework.core.io.ClassPathResource;

public class TestClass {
	public static void main(String[] args) {
		System.out.println("Make The World Great Agein");
		Resource();
	}
	public static void Resource(){
		ClassPathResource cr = new ClassPathResource("spring-servlet.xml");
		System.out.println(cr.exists());
		System.out.println(cr.getFilename());
		System.out.println(cr.getDescription());
	}
}
