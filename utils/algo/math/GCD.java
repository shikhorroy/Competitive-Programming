package utils.algo.math;

import java.math.BigInteger;

public class GCD {
    public static <T> T of(T a, T b) {
        BigInteger A = new BigInteger(a.toString());
        BigInteger B = new BigInteger(b.toString());

        return (T) A.gcd(B);
    }
}
