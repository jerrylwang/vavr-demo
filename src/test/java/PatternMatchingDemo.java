import io.vavr.Predicates;
import org.junit.jupiter.api.Test;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;

public class PatternMatchingDemo {

    @Test
    void patternMatching() {
        int input1 = 1;int input2 =2; int input3 =3;
        String number = Match(input1).of(
                Case($(1), "one"),
                Case($(2), "two"),
                Case($(), "default")
        );
        //conditional pattern
        String conditional = Match(input2).of(
                Case($(Predicates.is(1)), i -> "one" + i),
                Case($(Predicates.is(2)), i -> "two" + i),
                Case($(), i -> doSomething())
        );
        String conditional2 = Match(input3).of(
                Case($(Predicates.is(1)), i -> "one" + i),
                Case($(Predicates.is(2)), i -> "two" + i),
                Case($(), i -> doSomething())
        );
        System.out.println(number); System.out.println(conditional); System.out.println(conditional2);
    }

    private String doSomething() {
        return "doSomething";
    }

    @Test
    void patternMatching_shorter() {
        int input1 = 1;int input2 =2;
        String number = Match(input1).of(
                Case($(1), "one"),
                Case($(2), "two"),
                Case($(), "default")
        );
        //conditional pattern
        String conditional = Match(input2).of(
                Case($(Predicates.is(1)), i -> "one" + i),
                Case($(Predicates.is(2)), i -> "two" + i),
                Case($(), i -> doSomething())
        );
        System.out.println(number); System.out.println(conditional);
    }


}
