import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

public class OptionDemo {

    @Test
    void optionDemo() {
        System.out.println(Option.of(null));

        Option<String> jerry = Option.some("Jerry");
        Option<Object> none = Option.none();

        System.out.println(jerry.get());
        System.out.println(jerry.map(a -> a).getOrElse("Default name"));
        System.out.println(none.map(a -> a).getOrElse("Default name"));
    }
}
