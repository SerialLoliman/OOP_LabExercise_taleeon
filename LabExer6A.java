package labexer6a;

import java.io.IOException;
import java.nio.file.*;

import java.util.*;

public class LabExer6A {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path file = Paths.get("C:\\Java\\Words\\words.txt");
        
        try {
        
        System.out.println("Welcome to the Guessing Game");
        System.out.println("Let's play");
        List<String> wordList = Files.readAllLines(file);
        Random rand = new Random();
        int index = rand.nextInt(wordList.size());
        String wordToGuess = wordList.get(index);
        StringBuilder hiddenWord = new StringBuilder(wordToGuess.length());
        for (int i = 0; i < wordToGuess.length(); i++) {
            hiddenWord.append("*");
        }
        System.out.println("The word to guess is: " + hiddenWord.toString());
        int guesses = 0;
        while (guesses < 6) {
            System.out.println("Guess a letter: ");
            String guess = input.nextLine();
            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess.charAt(0)) {
                    hiddenWord.setCharAt(i, guess.charAt(0));
                    found = true;
                }
            }
            if (found) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
                guesses++;
            }
            System.out.println("Guesses left: " + (6 - guesses));
            System.out.println("The word is now: " + hiddenWord.toString());
            if (wordToGuess.equals(hiddenWord.toString())) {
                System.out.println("Congratulations! You guessed the word!");
                break;
            }
        }
        if (guesses == 6) {
            System.out.println("Sorry, you ran out of guesses. The word was: " + wordToGuess);
        }
    } catch(IOException e) {
        System.out.println(e);
    }
}
}