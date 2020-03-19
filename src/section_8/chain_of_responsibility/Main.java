package section_8.chain_of_responsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("역할 사슬 패턴");
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labdas really good?!!");
        System.out.println(result);

        System.out.println("----------------------------------");
        System.out.println("역할 사슬 패턴 (람다)");
        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;

        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");

        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);

        String result2 = pipeline.apply("Aren't labdas really good?!!");
        System.out.println(result2);
    }
}
