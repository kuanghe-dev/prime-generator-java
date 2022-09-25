public class PrimeGenerator {
    public static boolean[] isPrime;
    public static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue >= 2) {
            isPrime = new boolean[maxValue + 1];

            // initialize isPrime array
            for (int i = 0; i <= maxValue; i++)
                isPrime[i] = true;

            isPrime[0] = isPrime[1] = false;

            // sieve
            for (int i = 0; i < Math.sqrt(maxValue) + 1; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= maxValue; j += i)
                        isPrime[j] = false;
                }
            }

            // copy prime numbers to result array
            int count = 0;

            for (int i = 0; i <= maxValue; i++)
                if (isPrime[i])
                    count++;

            result = new int[count];

            for (int i = 0, j = 0; i <= maxValue; i++)
                if (isPrime[i])
                    result[j++] = i;

            return result;
        } else {
            return new int[0];
        }
    }
}
