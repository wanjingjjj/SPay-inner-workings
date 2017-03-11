package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

public final class BigIntUtils {
    private BigIntUtils() {
    }

    public static boolean equals(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        if (bigIntegerArr.length != bigIntegerArr2.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < bigIntegerArr.length; i2++) {
            i |= bigIntegerArr[i2].compareTo(bigIntegerArr2[i2]);
        }
        return i == 0;
    }

    public static void fill(BigInteger[] bigIntegerArr, BigInteger bigInteger) {
        for (int length = bigIntegerArr.length - 1; length >= 0; length--) {
            bigIntegerArr[length] = bigInteger;
        }
    }

    public static BigInteger[] subArray(BigInteger[] bigIntegerArr, int i, int i2) {
        Object obj = new BigInteger[(i2 - i)];
        System.arraycopy(bigIntegerArr, i, obj, 0, i2 - i);
        return obj;
    }

    public static int[] toIntArray(BigInteger[] bigIntegerArr) {
        int[] iArr = new int[bigIntegerArr.length];
        for (int i = 0; i < bigIntegerArr.length; i++) {
            iArr[i] = bigIntegerArr[i].intValue();
        }
        return iArr;
    }

    public static int[] toIntArrayModQ(int i, BigInteger[] bigIntegerArr) {
        BigInteger valueOf = BigInteger.valueOf((long) i);
        int[] iArr = new int[bigIntegerArr.length];
        for (int i2 = 0; i2 < bigIntegerArr.length; i2++) {
            iArr[i2] = bigIntegerArr[i2].mod(valueOf).intValue();
        }
        return iArr;
    }

    public static byte[] toMinimalByteArray(BigInteger bigInteger) {
        Object toByteArray = bigInteger.toByteArray();
        if (toByteArray.length == 1 || (bigInteger.bitLength() & 7) != 0) {
            return toByteArray;
        }
        Object obj = new byte[(bigInteger.bitLength() >> 3)];
        System.arraycopy(toByteArray, 1, obj, 0, obj.length);
        return obj;
    }
}