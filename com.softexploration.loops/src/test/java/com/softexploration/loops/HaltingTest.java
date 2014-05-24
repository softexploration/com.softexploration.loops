package com.softexploration.loops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softexploration.loops.halting.Halting;
import com.softexploration.loops.util.LoopUtils;

public class HaltingTest {

    @Before
    public void setup() {
	LoopUtils.setInfinityTimeout(1000L);
    }

    @Test
    public void doNotHalt() {

	final String halts = Boolean.TRUE.toString();

	Assert.assertTrue(LoopUtils.loopsForever(() -> {
	    final Halting halting = new Halting();

	    if (halting.halts(halts)) {
		while (true) {
		    // do nothing
	    }
	}

    })  );
    }

    @Test
    public void doHalt() {

	final String halts = Boolean.FALSE.toString();

	Assert.assertFalse(LoopUtils.loopsForever(() -> {
	    final Halting halting = new Halting();

	    if (halting.halts(halts)) {
		while (true) {
		    // do nothing
	    }
	}

    })  );
    }

}
