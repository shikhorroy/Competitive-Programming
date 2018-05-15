package utils.algo.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GCD {
    public static <T> BigInteger of(T a, T b) {
        BigInteger A = new BigInteger(a.toString());
        BigInteger B = new BigInteger(b.toString());

        return A.gcd(B);
    }
}
