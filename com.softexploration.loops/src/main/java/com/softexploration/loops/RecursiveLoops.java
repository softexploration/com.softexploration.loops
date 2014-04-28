package com.softexploration.loops;

public class RecursiveLoops {

	public static void main(String[] args) {
		h(false);
	}

	public static void f() {
		f();
	}

	public static boolean g() {
		if (g()) {
			return true;
		} else {
			return g();
		}
	}

	public static boolean h(final boolean in) {
		if (in) {
			h(!in);
		}
		return false;
	}

	public static int fibonacci(int n) {
		if (n < 2) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
