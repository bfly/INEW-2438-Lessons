package edu.dcccd.main;

import edu.dcccd.primes.StreamPrimes;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final int NUMBER_OF_PRIMES = 200;

    public static void main(String[] args) {
        StreamPrimes streamPrimes = new StreamPrimes();
        var count = new AtomicInteger(1);
        streamPrimes.primes(NUMBER_OF_PRIMES)
            .forEach(prime -> {
                if ( count.getAndIncrement() % 20 == 0 )
                     System.out.printf("%4d\n", prime);
                else System.out.printf("%4d ", prime);
            });
    }}
