package edu.dcccd;

public class ImperativePrimes {

    private static final int NUMBER_OF_PRIMES = 200;

    private void go() {
        var count = 0;       // primes found count
        var number = 2;      // number to be tested for prime
        while (count < NUMBER_OF_PRIMES) {
            if ( isPrime(number) ) {
                if ( ++count % 20 == 0 )
                    System.out.printf("%4d\n", number);
                else System.out.printf("%4d ", number);
            }
            number++;
        }
        System.out.println();
    }

    private boolean isPrime(int number) {
        for ( int divisor = 2; divisor < number; divisor++ ) {
            if ( number % divisor == 0 ) return false; //number is divisible so its not prime
        }
        return true; //number is prime now
    }

    public static void main(String[] args) {
        new ImperativePrimes().go();
    }
}
