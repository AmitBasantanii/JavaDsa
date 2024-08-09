import java.util.function.Consumer;

class movie_chaining {
    String name;
    String result;
    movie_chaining(String name, String result) {
        this.name = name;
        this.result = result;
    }
}
public class consumer_chaining {
    public static void main(String[] args) {
        Consumer<movie_chaining> consumer1 = movie -> System.out.println("Movie: " + movie.name + " is ready to release");

        Consumer<movie_chaining> consumer2 = movie -> System.out.println("Movie : "+ movie.name + " is just released and it is : "  + movie.result);

        Consumer<movie_chaining> consumer3 = movie -> System.out.println("Movie: " + movie.name + " information storing in database");

        Consumer<movie_chaining> chainedC = consumer1.andThen(consumer2).andThen(consumer3);

        movie_chaining m1 = new movie_chaining("Bahubali", "Hit");
        chainedC.accept(m1);

        movie_chaining m2 = new movie_chaining("Spider man", "Flop");
        chainedC.accept(m2);
    }
}
