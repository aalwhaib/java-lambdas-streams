package com.alwahib.java_lambdas_streams;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Greeting greeting = new HelloWorldGreeting();
		greeting.sayHello();

		Greeting greeting2 = new Greeting() {

			public void sayHello() {
				System.out.println("Hello World");

			}
		};

		greeting2.sayHello();
	}
}
