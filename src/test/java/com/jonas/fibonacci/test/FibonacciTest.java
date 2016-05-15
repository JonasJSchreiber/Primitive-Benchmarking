package com.jonas.fibonacci.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jonas.fibonacci.Fibonacci;

public class FibonacciTest {
	
	Fibonacci fib = new Fibonacci();
	
	@SuppressWarnings({ "static-access", "unused" })
	@Test
	public void testSpeed() {
		Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();
		lookup.put(46, 1836311903);
		int input = 46;
		
		long start = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			fib.linearIterativeFib(input);
		}
		System.out.println("Iterative approach 1000000 times took " 
				+ (System.nanoTime() - start) + " ns");
		
		start = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			int x = lookup.get(46);
		}
		System.out.println("Lookup from HashMaps 1000000 times took " 
				+ (System.nanoTime() - start) + " ns");
		
		start = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			fib.logNRecursiveFib(input);
		}
		System.out.println("Matrix multiplication approach 1000000 times took " 
				+ (System.nanoTime() - start) + " ns");
	}
}
