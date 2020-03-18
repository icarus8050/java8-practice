package section_8.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------");
        System.out.println("일반적인 표현 방법");
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        System.out.println(b1);

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b2);

        System.out.println("---------------------");
        System.out.println("람다 표현식을 이용한 방법");
        Validator numericValidator2 = new Validator((String s) -> s.matches("\\d+"));
        boolean b3 = numericValidator2.validate("aaaa");
        System.out.println(b3);

        Validator lowerCaseValidator2 = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b4 = lowerCaseValidator2.validate("bbbb");
        System.out.println(b4);
    }
}
