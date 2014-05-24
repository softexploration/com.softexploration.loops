package com.softexploration.loops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softexploration.loops.util.LoopUtils;

public class RecursiveLoopsTest {

    private RecursiveLoops recursiveLoops;

    @Before
    public void setup() {
	recursiveLoops = new RecursiveLoops();
	LoopUtils.setInfinityTimeout(1000L);
    }

    @Test
    public void f() {
	Assert.assertTrue(LoopUtils.loopsForever(recursiveLoops::f));
    }

    @Test
    public void g() {
	Assert.assertTrue(LoopUtils.loopsForever(recursiveLoops::g));
    }

    @Test
    public void hFalse() {
	Assert.assertFalse(LoopUtils.loopsForever(recursiveLoops::h, false));
    }

    @Test
    public void hTrue() {
	Assert.assertFalse(LoopUtils.loopsForever(recursiveLoops::h, true));
    }

    @Test
    public void fibonacci$0() {
	Assert.assertFalse(LoopUtils.loopsForever(recursiveLoops::fibonacci, 0));
    }

    @Test
    public void fibonacci$10() {
	Assert.assertFalse(LoopUtils.loopsForever(recursiveLoops::fibonacci, 10));
    }
}
