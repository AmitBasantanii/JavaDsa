import java.util.function.Function;

public class function_chaining {
    public static void main(String[] args) {
        Function<String, String> function1 = s -> s.toUpperCase();
        Function<String, String> function2 = s -> s.substring(0,9);

        System.out.println("The Result of  function1 : " + function1.apply("AmitBasantani"));
        System.out.println("The Result of function2 : " + function2.apply("AmitBasantani"));
        System.out.println("The Result of function1.andThen(function2):" + function1.andThen(function2).apply("AmitBasantani"));
        System.out.println("The Result of function1.compose(function2) : " + function1.compose(function2).apply("AmitBasantani"));
    }
}
