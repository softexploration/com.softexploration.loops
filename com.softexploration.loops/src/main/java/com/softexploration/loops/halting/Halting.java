package com.softexploration.loops.halting;

public class Halting {

	public static void main(String[] args) {
		Halting halting = new Halting();

		if (halting.halts(args[0])) {
			while (true) {
				// do nothing
			}
		}
	}

	public boolean halts(String program) {
		return Boolean.valueOf(program);
	}
}
