import io.vavr.Function2;
import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

public class TryDemo {

    @Test
    void tryDemo() {
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;

        Try<Integer> failure = Try.of(() -> divide.apply(5, 0)) //wrapping a method call to a lambda function
                .onFailure(e -> System.err.println("Someone has just thrown an exception e"))
                .onFailure(e -> System.err.println("Maybe I should do something about it."));

        System.out.println(failure);
        System.err.println(failure.getOrElse(0));

        System.out.println("--------------");

        Try<Integer> success = Try.of(() -> divide.apply(5, 1))
                .onSuccess(s -> System.out.println("I am going to log what just happened!!!"))
//                .peek(p -> System.out.printf("Did someone say they want to do some more stuff in here? %s + 100 %n", p))
                .peek(r -> System.out.println(r+100));

        System.out.println(success);
        System.out.println(success.get());

    }

    @Test
    void tryDemo_shorter() {
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;

        Try<Integer> failure = Try.of(() -> divide.apply(5, 0)); //wrapping a method call to a lambda function
        System.out.println(failure);
        Try<Integer> success = Try.of(() -> divide.apply(5, 1));
        System.out.println(success);
        System.out.println(success.get());
        System.err.println(failure.toJavaOptional());
    }
}
