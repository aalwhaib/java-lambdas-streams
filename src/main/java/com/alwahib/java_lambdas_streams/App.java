package com.alwahib.java_lambdas_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alwahib.java_lambdas_streams.emp.Employee;

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

		Greeting greeting3 = () -> System.out.println("Hello World");
		greeting3.sayHello();

		IntBinaryOperator calculator = (x, y) -> {
			Random random = new Random();
			int randomNumber = random.nextInt(50);
			return x * y + randomNumber;
		};

		System.out.println(calculator.applyAsInt(1, 2));
		
		
		
		Integer[] scores = new Integer[]{80, 66, 73, 92, 43};

	    List<String> shoppingList = new ArrayList<>();
	    shoppingList.add("coffee");
	    shoppingList.add("bread");
	    shoppingList.add("pineapple");
	    shoppingList.add("milk");
	    shoppingList.add("pasta");
	    
	    System.out.println("======> ShoppingList: ");
	    Stream<String> shoppingListStream = shoppingList.stream();
	    shoppingListStream.map(s -> s.toUpperCase())
	    	.filter(s -> !s.startsWith("C") )
	    	.sorted()
	    	//.forEach(t -> System.out.println(t));
	    	.forEach(System.out::println);
	    
	    System.out.println(shoppingList);
	    
	    Predicate<String> notStartWithC = s -> !s.startsWith("C");
	    Function<String, String> toUpperCase = s -> s.toUpperCase();
	    
	    List<String> sortedShoppingList = shoppingList.stream()
	    		.map(toUpperCase)
	    		.filter(notStartWithC)
	    		.sorted()
		    	.collect(Collectors.toList());
	    System.out.println(sortedShoppingList);
	    
	    System.out.println("======> Scores: ");
	    Arrays.asList(scores).stream()
	    	.map(i -> i * i)
	    	.filter(i -> i % 2 != 0)
	    	.forEach(System.out::println);
	    System.out.println("======> Names: ");
	    Stream<String> names = Stream.of("Ahmed", "Test");
	    names.forEach(System.out::println);
	    
	}
}
