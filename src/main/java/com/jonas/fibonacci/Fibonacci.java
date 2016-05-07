package com.jonas.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	public static int nthFib = 46;
	public static Integer[][] matrix = {{1, 1}, {1, 0}};
	static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
	static Map<Integer, Integer[][]> logNMemo = new HashMap<Integer, Integer[][]>();
	
	static {
		memo.put(0, 1);
		memo.put(1, 1);
		memo.put(2, 1);
		
		Integer[][] m = {{1, 1}, {1, 0}};
		logNMemo.put(0, m);
		logNMemo.put(1, m);
	}
	
	public static int linearIterativeFib(int x) {
		if (x <= 2) {
			return 1;
		} else {
			int prev = 0;
			int result = 1;
			for (int i = 2; i <= x; i++) {
				int temp = result;
				result += prev;
				prev = temp;
			}
			return result;	
		}	
	}
	
	public static int linearRecursiveFib(int x) {
		Integer result = null;
		if ((result = memo.get(x)) != null) {
			return result;
		} else {
			result = linearRecursiveFib(x - 1) 
					+ linearRecursiveFib(x - 2);
			memo.put(x, result);
			return result;
		}
	}
	
	/*
	 * Idea: Matrix multiplication with DP
	 * Strategy: break down into n subproblems
	 * Memoize Solutions
	 * Build up tree
	 * 
	 * |Fn+1 Fn  | = | 1 1 |^n
	 * |Fn   Fn-1|   | 1 0 |
	 */
	
	public static int logNRecursiveFib(int x) {
		Integer[][] m = recurse(x-1);
//		printMatrix(m);
		return m[0][0];
	}
	
	public static Integer[][] recurse(int x) {
		Integer[][] m = matrix;
		Integer[][] result = null;
		for (int i = 2; i <= x; i++) {
			if ((result = logNMemo.get(i)) != null) {
				return result;
			} else {
				m = multiply(m, matrix);
				logNMemo.put(i, m);	
			}
		}
		return m;
	}
	
	public static Integer[][] multiply(Integer[][] m1, Integer[][] m2) {
		int a, b, c, d;
		a = (m1[0][0] * m2[0][0]) + (m1[0][1] * m2[1][0]);
		b = (m1[0][0] * m2[0][1]) + (m1[0][1] * m2[1][1]);
		c = (m1[1][0] * m2[0][0]) + (m1[1][1] * m2[1][0]);
		d = (m1[1][0] * m2[0][1]) + (m1[1][1] * m2[1][1]);
		return new Integer[][]{{a, b}, {c, d}};
	}
	
	public static void printMatrix(Integer[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
