package maths;

import java.math.BigInteger;

public class ModularExponentiationForLargeNumbers {

	public static void main(String[] args) {
		ModularExponentiationForLargeNumbers largeNumbers = new ModularExponentiationForLargeNumbers();
		System.out.println(largeNumbers.getRes(new BigInteger("450"), new BigInteger("768"), new BigInteger("517")));
	}

	private BigInteger getRes(BigInteger a, BigInteger b, BigInteger c) {
		BigInteger d = a.pow(b.intValue());
		return d.mod(c);
	}
}
