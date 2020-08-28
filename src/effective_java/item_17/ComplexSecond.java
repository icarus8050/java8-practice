package effective_java.item_17;

public class ComplexSecond {
    private final double re;
    private final double im;

    private ComplexSecond(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static ComplexSecond valueOf(double re, double im) {
        return new ComplexSecond(re, im);
    }

    //나머지 코드 생략
}
