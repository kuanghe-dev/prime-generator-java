import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {
    @Test
    public void testNullArray() {
        int[] nullArray = PrimeGenerator.generatePrimes(0);
        assertEquals(0, nullArray.length);
    }

    @Test
    public void testArrayUpToTwo() {
        int[] twoArray = PrimeGenerator.generatePrimes(2);
        assertEquals(1, twoArray.length);
        assertEquals(2, twoArray[0]);
    }

    @Test
    public void testArrayUpToThree() {
        int[] threeArray = PrimeGenerator.generatePrimes(3);
        assertEquals(2, threeArray.length);
        assertEquals(2, threeArray[0]);
        assertEquals(3, threeArray[1]);
    }

    @Test
    public void testArrayUpToOneHundred() {
        int[] oneHundredArray = PrimeGenerator.generatePrimes(100);
        assertEquals(25, oneHundredArray.length);
        assertEquals(97, oneHundredArray[24]);
    }

    @Test
    public void testExhaustive() {
        int[] fiveHundredArray = PrimeGenerator.generatePrimes(500);
        for (int value : fiveHundredArray)
            assertTrue(isPrime(value));
    }

    public boolean isPrime(int value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0)
                return false;
        }

        return true;
    }
}