class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        // Approach - Sieve of Eratosthenes

        // Form a boolean isPrime array to keep track of prime numbers.
        boolean[] isPrime = new boolean[n];
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

        int count = 0;
        // Count the number of prime numbers in the isPrime array.
        for (int i = 0; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
