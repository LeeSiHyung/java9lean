package chap01;

import java.math.BigDecimal;

public class ValueTest {

    public static void main(String[] args) {

        System.out.println(2.0 - 1.1);

        System.out.println(BigDecimal.valueOf(2,0).subtract(BigDecimal.valueOf(11, 1)) );

    }

}
