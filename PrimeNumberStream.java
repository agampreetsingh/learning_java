/* PrimeNumberStream.java:
 * -----------------------
 * This program illustrates the basic use of streams in Java 9+.
 * We will first generate all integers between one and a user given N, then
 * filter out only the primer numbers and collect them into a list.
 * After printing the list, we will create a new stream from this list, square
 * each number and sum them.
 */
import java.util.*;
import java.util.stream.*;

class PrimeNumberStream {
    // Establishes if the given input is a prime number.
    public static boolean isPrime(int n) {
        // Only numbers upto the square root of n are viable candidates
        // for disproving primality.
        IntStream candidates = IntStream
            .rangeClosed(2, n)
            .takeWhile(i -> i * i <= n);
        
        // A prime number is greater than one and is not divided by any
        // other number.
        return n > 1 && !candidates.anyMatch(i -> n % i == 0);
    }

    // Main program entry point.
    public static void main(String[] args) {
        // Firstly, we will read the nnumber N.
        Scanner s = new Scanner(System.in);
        System.out.print("Please, give me a positive number >> ");
        int n = s.nextInt();
        
        // Now we create a stream with all number between 1 and N (inclusive).
        IntStream ints = IntStream.rangeClosed(1, n);
        
        // Let's now filter only the prime numbers and collect them in a list.
        List<Integer> primes = ints
            .filter(PrimeNumberStream::isPrime)
            .boxed()  // Converts from IntStream to Stream<Integer> for collect.
            .collect(Collectors.toList());
        
        // Let's print our resulting primes
        System.out.println("Our primes are:");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println();
        
        // Now we will create a new stream, square each number and sum them up.
        int squarePrimesSum = primes
            .stream()
            .map(prime -> prime * prime)
            .reduce(0, (subtotal, element) -> subtotal + element);
        
        System.out.println("The sum of square primes is: " + squarePrimesSum);
    }
}