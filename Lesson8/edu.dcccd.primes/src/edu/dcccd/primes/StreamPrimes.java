package edu.dcccd.primes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamPrimes {

    public List<Integer> primes(int number) {
        return Stream.iterate(1, iterator -> iterator + 1)
                .filter(this :: isPrime)
                .limit(number)
                .collect(Collectors.toCollection(ArrayList ::new));
    }

    private boolean isPrime(int number) {
        return IntStream
                .rangeClosed(2, ( int ) Math.sqrt(( double ) number))
                .noneMatch(divisor -> number % divisor == 0);
    }
}
