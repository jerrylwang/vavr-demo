import io.vavr.Function2;
import org.junit.jupiter.api.Test;

public class FunctionDemo {

    @Test
    void functionDemo() {
        Function2<Integer, Integer, Integer> sum = Integer::sum;
        System.out.println(sum.apply(100, 100));
    }
}
