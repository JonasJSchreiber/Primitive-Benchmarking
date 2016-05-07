package com.jonas.concurrency.test;

import org.junit.Test;

import com.jonas.concurrency.Concurrency;

public class ConcurrencyTest {
	
	Concurrency con = new Concurrency();
	
	@Test
	public void testConcurrency() {
		con.initializeSquareRandomMatrices(1000);
		con.spawnExecutorsWorkers();
		con.spawnFutureWorkers();
		con.singleThreadedMatrixMultiplication();
//		con.printMatrix();
	}
}
