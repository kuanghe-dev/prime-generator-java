public class PrimeGenerator {
    public static boolean[] isPrime;
    public static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2)
            return new int[0];

        initialzeIsPrimeArray(maxValue);
        crossOutMultiples();
        copyPrimesIntoResult();

        return result;
    }

    private static void initialzeIsPrimeArray(int maxValue) {
        isPrime = new boolean[maxValue + 1];

        for (int i = 2; i <= maxValue; i++)
            isPrime[i] = true;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i])
                crossOutMultiplesOf(i);
        }
    }

    private static int determineIterationLimit() {
        // Every multiple in the array has a prime factor that is less than or
        // equal to the sqrt of the array size, so we don't have to cross out
        // multiples of numbers larger than that root.
        return (int)Math.sqrt(isPrime.length);
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = i * i; multiple < isPrime.length; multiple += i)
            isPrime[multiple] = false;
    }

    private static void copyPrimesIntoResult() {
        result = new int[countNumberOfPrimes()];

        for (int i = 0, j = 0; i < isPrime.length; i++)
            if (isPrime[i])
                result[j++] = i;
    }

    private static int countNumberOfPrimes() {
        int count = 0;

        for (boolean value : isPrime) {
            if (value)
                count++;
        }

        return count;
    }
}
