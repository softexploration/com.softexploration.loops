package com.softexploration.loops;

import java.util.Scanner;

public class SimpleLoops {

    public void alwaysLoops() {
	while (true) {
	    // do nothing
	}
    }

    public void alwaysLoopsVar() {
	boolean always = true;
	while (always) {
	    // do nothing
	}
    }

    public void alwaysLoopsFinalVar() {
	final boolean always = true;
	while (always) {
	    // do nothing
	}
    }

    public void neverLoops() {
	final boolean isNull = "string" == null;
	while (isNull) {
	    // do nothing
	}
    }

    /**
     * Loops when reads on input value compatible with Boolean.TRUE
     */
    public void somtimesLoops() {
	Scanner in = new Scanner(System.in);
	final boolean input = Boolean.valueOf(in.next());
	in.close();
	while (input) {
	    // do nothing
	}
    }

}
