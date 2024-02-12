package data.structures.algorithm.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author starrysky
 */
public class Sleep {
    public static void main(String[] args) {
        BigDecimal big = new BigDecimal("7");
        BigDecimal yz = new BigDecimal("34");
        System.out.println(big.divide(yz,20, RoundingMode.HALF_UP));

        //checking 0.20588235294117647059
        BigDecimal big2 = new BigDecimal("0.20588235294117647059");
        BigDecimal yz2 = new BigDecimal("34");
        System.out.println(yz2.multiply(big2));
    }
}
