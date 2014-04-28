package com.softexploration.loops;

import java.util.Scanner;

public class SimpleLoops {

	public static void main(String[] args) {

		alwaysLoops();
	}

	public static void alwaysLoops() {
		while (true) {
			// do nothing
		}
	}

	public static void alwaysLoopsVar() {
		boolean always = true;
		while (always) {
			// do nothing
		}
	}

	public static void alwaysLoopsFinalVar() {
		final boolean always = true;
		while (always) {
			// do nothing
		}
	}

	public static void neverLoops() {
		final boolean isNull = "string" == null;
		while (isNull) {
			// do nothing
		}
	}

	/**
	 * Loops when reads on input value compatible with Boolean.TRUE
	 */
	public static void somtimesLoops() {
		final boolean input = Boolean.valueOf(new Scanner(System.in).next());
		while (input) {
			// do nothing
		}
	}

}
