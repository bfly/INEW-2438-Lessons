package edu.dcccd;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamFactorial {
    private void go() {
        IntStream.rangeClosed(1, 20)
                .forEach(n -> System.out.printf("%d - %,d\n", n, factorialStream(n)));
        IntStream.rangeClosed(1, 20)
                .forEach(n -> System.out.printf("%d - %,d\n", n, factorialTailRecursive(n)));
    }

    private long factorialStream(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long a, long b) -> a * b);
    }

    private long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    private long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n - 1);
    }

    public static void main(String[] args) {
        new StreamFactorial().go();
    }
}
