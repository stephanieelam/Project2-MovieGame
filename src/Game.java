import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Game {
    public static void guessLetter(String randomMoviehidden, String randomMovie) {
        Scanner scanner = new Scanner(System.in);
        boolean win = false;
        int guesses = 0;
        String printSting = new String();

        while(guesses < 10) {
            System.out.println("You are guessing:" + randomMoviehidden + "," + randomMovie);
            System.out.println("Guess a letter:");
            // Character input
            //char guessLetter = scanner.next().charAt(0);
            String guessLetter = scanner.next();
            int guessIndex = -1;
            //change it to character so that the _ can be replaced
            char[] tmpString = randomMoviehidden.toCharArray();
            char ch = guessLetter.charAt(0);

            int count = 0;
            //find the index for all occurrence in the movie name
            while(true) {
                guessIndex = randomMovie.indexOf(guessLetter, guessIndex + 1);
                if (guessIndex == -1) {
                    break;
                } else {
                    count += 1;
                    tmpString[guessIndex] = ch;
                }
            }

            //if there is more than 0 occurrence, print the new string;
            //otherwise, add into the wrong guesses letter list and print out string
            if(count > 0) {
                randomMoviehidden = String.valueOf(tmpString);
                System.out.println(randomMoviehidden);
            }else {
                guesses = guesses + 1;
                printSting = printSting + " " + ch;
                System.out.println("You have guessed (" + guesses + ") wrong letters:" + printSting);
            }


            //if there is no more _, user win
            if(!randomMoviehidden.contains("_")) {
                win = true;
                System.out.println("You win!");
                System.out.println("You have guessed '"+randomMovie+"' correctly.");
                break;
            }

        }
        //if 10 guesses used = lose
        if (!win) {
            System.out.println("You lose! Game Over!");
        }
    }
}