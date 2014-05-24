package com.softexploration.loops.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Operations on loops
 */
public class LoopUtils {

    public static final long DEFAULT_INFINITY_TIMEOUT = 5000L;

    /**
     * timeout [ms] expressing infinity
     */
    private static long infinityTimeout = DEFAULT_INFINITY_TIMEOUT;

    public static void setInfinityTimeout(final long infinityTimeout) {
	LoopUtils.infinityTimeout = infinityTimeout;
    }

    /**
     * @return timeout [ms] expressing infinity
     */
    public static long getInfinityTimeout() {
	return infinityTimeout;
    }

    /**
     * Informs whether {@code runnable.run()} loops forever. Loop is considered
     * to be infinite if the execution time is longer than
     * {@link LoopUtils#getInfinityTimeout()}.
     * 
     * @param runnable
     *            - runnable to test
     * @return informs whether {@code runnable.run()} loops forever
     */
    public static boolean loopsForever(final Runnable runnable) {
	final ExecutorService executorService = Executors.newFixedThreadPool(1);
	executorService.execute(runnable);
	executorService.shutdown();
	try {
	    return !executorService.awaitTermination(infinityTimeout, TimeUnit.MILLISECONDS);
	} catch (InterruptedException e) {
	    throw new RuntimeException(e);
	} finally {
	    executorService.shutdownNow();
	}
    }

    /**
     * Informs whether {@code method.f()} loops forever. Loop is considered to
     * be infinite if the execution time is longer than
     * {@link LoopUtils#getInfinityTimeout()}.
     * 
     * @param method
     *            - method to test
     * @return informs whether {@code method.f()} loops forever
     */
    public static boolean loopsForever(final BooleanRetNoArgsMethod method) {
	return loopsForever(() -> {
	    method.f();
	});
    }

    /**
     * Informs whether {@code method.f()} loops forever. Loop is considered to
     * be infinite if the execution time is longer than
     * {@link LoopUtils#getInfinityTimeout()}.
     * 
     * @param method
     *            - method to test
     * @return informs whether {@code method.f()} loops forever
     */
    public static boolean loopsForever(final BooleanRetBooleanArgMethod method, final boolean value) {
	return loopsForever(() -> {
	    method.f(value);
	});
    }

    /**
     * Informs whether {@code method.f()} loops forever. Loop is considered to
     * be infinite if the execution time is longer than
     * {@link LoopUtils#getInfinityTimeout()}.
     * 
     * @param method
     *            - method to test
     * @return informs whether {@code method.f()} loops forever
     */
    public static boolean loopsForever(final IntegerRetIntegerArgMethod method, final int value) {
	return loopsForever(() -> {
	    method.f(value);
	});
    }

}