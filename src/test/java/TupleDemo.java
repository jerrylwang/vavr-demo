import org.junit.jupiter.api.Test;
import io.vavr.*;

public class TupleDemo {

    private static Tuple2<String, String> getStatus() {
        return Tuple.of("Rejected", "Passed");
    };

    @Test
    void tupleDemo() {
        Tuple2<Integer, Integer> tuple2 = Tuple.of(1, 2);
        System.out.println(tuple2._1); //to retrieve first value
        System.out.println(tuple2._2); //to retrieve second value
        System.out.println(getStatus()); //function returning multiple values

        Tuple2<String, String> transformedTuple = getStatus().map(first -> first.concat(" : 403"),
                second -> second.concat(" : 200")); //transforming values of a tuple

        System.out.println(transformedTuple);

        Tuple2<Integer, String> jerry = Tuple.of(1, "Jerry"); //jerry

        System.out.println(jerry._2);
    }
}
