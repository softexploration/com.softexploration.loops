package com.softexploration.loops;

public class RecursiveLoops {

    public static final long DEFAULT_RECURSIVE_INVOCATION_DELAY = 1;

    /**
     * Delay [ms] in recursive invocation
     */
    private long recursiveInvocationDelay = DEFAULT_RECURSIVE_INVOCATION_DELAY;

    public void setRecursiveInvocationDelay(final long recursiveInvocationDelay) {
	this.recursiveInvocationDelay = recursiveInvocationDelay;
    }

    /**
     * @return delay [ms] in recursive invocation
     */
    public long getRecursiveInvocationDelay() {
	return recursiveInvocationDelay;
    }

    public void f() {
	delay();
	f();
    }

    public boolean g() {
	delay();
	if (g()) {
	    return true;
	} else {
	    return g();
	}
    }

    public boolean h(final boolean in) {
	delay();
	if (in) {
	    h(!in);
	}
	return false;
    }

    public int fibonacci(int n) {
	delay();
	if (n < 2) {
	    return n;
	} else {
	    return fibonacci(n - 1) + fibonacci(n - 2);
	}
    }

    private void delay() {
	try {
	    Thread.sleep(recursiveInvocationDelay);
	} catch (InterruptedException e) {
	    // interrupted
	}
    }
}
