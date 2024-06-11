import java.util.ArrayList;
import java.util.function.Consumer;

class Movie {
    String name;
    String hero;
    String heroine;
    Movie(String name, String hero, String heroine) {
        this.name = name;
        this.hero = hero;
        this.heroine = heroine;
    }
}
public class movie_information {
    public static void main(String[] args) {
        ArrayList<Movie> movieArrayList = new ArrayList<Movie>();
        populate(movieArrayList);
        Consumer<Movie> movieConsumer = m -> {
            System.out.println("Movie Name : " + m.name);
            System.out.println("Movie Hero : " + m.hero);
            System.out.println("Movie Heroine : " + m.heroine);
            System.out.println();
        };
        for(Movie movie : movieArrayList) {
            movieConsumer.accept(movie);
        }
    }
    public static void populate(ArrayList<Movie> movieArrayList) {
        movieArrayList.add(new Movie("Bahubali", "Parabhas", "Anushka"));
        movieArrayList.add(new Movie("Rayees", "Sharukh", "Sunny"));
        movieArrayList.add(new Movie("Dangal", "Ameer", "Ritu"));
        movieArrayList.add(new Movie("Sultan", "Salman", "Anushka"));
    }
}




