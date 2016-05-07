package com.jonas.fibonacci.test;

import org.junit.Test;

import com.jonas.fibonacci.Fibonacci;

public class FibonacciTest {
	
	Fibonacci fib = new Fibonacci();
	
	@SuppressWarnings("static-access")
	@Test
	public void testSpeed() {
		int input = 46;
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			fib.linearIterativeFib(input);
		}
		System.out.println("Iterative approach took " 
				+ (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			fib.linearRecursiveFib(input);
		}
		System.out.println("Recursive approach took " 
				+ (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			fib.logNRecursiveFib(input);
		}
		System.out.println("Matrix multiplication approach took " 
				+ (System.currentTimeMillis() - start) + "ms");
	}
}
