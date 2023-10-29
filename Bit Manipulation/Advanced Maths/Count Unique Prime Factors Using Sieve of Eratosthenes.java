import java.util.List;
import java.util.*;

public class Solution {
    public static List< Integer > countPrimes(int n) {
        // Write your code here.

        //O(N*logN)
        // List<Integer> ans = new ArrayList<>();

        // for(int i = 2; i<= n; i++)
        // {
        //     if(checkPrime(i) && n%i == 0)
        //     {
        //         ans.add(i);
        //     }
        // }

        // return ans;


        //using Sieve of eratosthenes
        // Form a boolean isPrime array to keep track of prime numbers.
        boolean[] isPrime = new boolean[n];
        List<Integer> ans = new ArrayList<>(); //Store final answer
        Arrays.fill(isPrime, true); // Initially mark all numbers as prime.
        isPrime[0] = false; // 0 is not a prime number.
        isPrime[1] = false; // 1 is not a prime number.

        // Start the Sieve of Eratosthenes algorithm to mark non-prime numbers.
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // If 'i' is a prime number, mark all its multiples as non-prime.
                for (int j = i * i; j < n; j += i) { //Why i*i? This is because the smaller multiples of i would have already been marked as non primes while we considered 2,3,5,7....
                    isPrime[j] = false;
                }
            }
        }

        // Count the number of prime numbers in the isPrime array.
        for (int i = 0; i < n; i++) {
            if (isPrime[i] && n%i == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    private static boolean checkPrime(int n)
    {
        for(int i = 2; i*i<=n; i++)
        {
            if(n % i == 0)
            return false;
        }
        return true;
    }
}
