package com.softexploration.loops;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softexploration.loops.util.LoopUtils;

public class SimpleLoopsTest {

    private SimpleLoops simpleLoops;

    @Before
    public void setup() {
	simpleLoops = new SimpleLoops();
	LoopUtils.setInfinityTimeout(1000L);
    }

    @Test
    public void alwaysLoops() {
	Assert.assertTrue(LoopUtils.loopsForever(simpleLoops::alwaysLoops));
    }

    @Test
    public void alwaysLoopsVar() {
	Assert.assertTrue(LoopUtils.loopsForever(simpleLoops::alwaysLoopsVar));
    }

    @Test
    public void alwaysLoopsFinalVar() {
	Assert.assertTrue(LoopUtils.loopsForever(simpleLoops::alwaysLoopsFinalVar));
    }

    @Test
    public void neverLoops() {
	Assert.assertFalse(LoopUtils.loopsForever(simpleLoops::neverLoops));
    }

    @Test
    public void somtimesLoopsFalse() {
	final InputStream systemIn = System.in;
	System.setIn(new ByteArrayInputStream(Boolean.FALSE.toString().getBytes()));
	final boolean loopsForever = LoopUtils.loopsForever(simpleLoops::somtimesLoops);
	System.setIn(systemIn);
	Assert.assertFalse(loopsForever);
    }

    @Test
    public void somtimesLoopsTrue() {
	final InputStream systemIn = System.in;
	System.setIn(new ByteArrayInputStream(Boolean.TRUE.toString().getBytes()));
	final boolean loopsForever = LoopUtils.loopsForever(simpleLoops::somtimesLoops);
	System.setIn(systemIn);
	Assert.assertTrue(loopsForever);
    }

}
