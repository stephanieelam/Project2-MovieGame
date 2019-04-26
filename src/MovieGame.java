import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MovieGame {

    public static void main(String[] args) throws Exception {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        //read whole file
        int words = 0;
        //put into new array list
        ArrayList<String> movieList = new ArrayList<String>();
        Random rand = new Random();
        while (scanner.hasNextLine()) {
            //read each line
            String movie = scanner.nextLine();
            //add items to movielist
            movieList.add(movie);
        }
        String randomMovie = movieList.get(rand.nextInt(movieList.size()));
        System.out.println(randomMovie);
        String randomMoviehidden = randomMovie.replaceAll("[a-zA-Z]","_");

        Game.guessLetter(randomMoviehidden, randomMovie);
    }
}