import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;

public class Project5
{
    // Constants for the game setup
    final private static int NUMBER_WORDS = 255;
    final private static int MAX_GUESSES = 6;
    final private static int WORD_LENGTH = 5;
    final private static String FILENAME = "Wordle.txt";
    
    // Symbols for printing out results
    final private static char SUCCESS = '*';
    final private static char RIGHT_LETTER_WRONG_PLACE = '!';
    final private static char WRONG_LETTER = 'X';

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner keyboard = new Scanner(System.in);
        String hiddenWord = getWordFromFile(NUMBER_WORDS, keyboard);


        hiddenWord = hiddenWord.toLowerCase();
        int guessCount = 0;
        boolean wordGuessed = false;

        while (guessCount < MAX_GUESSES && !wordGuessed) {
            System.out.println("Enter your guess. Remember the word has 5 letters");
            String guess = keyboard.nextLine().toLowerCase();

            if (guess.length() != WORD_LENGTH) {
                System.out.println("Your guess must be exactly 5 letters long. Try again.");
                continue;
            }

            int correctLetters = showResult(hiddenWord, guess);
            guessCount++;

            if (correctLetters == WORD_LENGTH) {
                wordGuessed = true;
            }
        }

        if (!wordGuessed) {
            System.out.println("The word was " + hiddenWord);
        }

        System.out.println(guessCount + " / " + MAX_GUESSES);
        keyboard.close();
    }

    public static String getWordFromFile(int size, Scanner keyboard) throws FileNotFoundException {
        Scanner file = new Scanner(new File(FILENAME));
        String word = "";

        int wordNumber;
        do {
            System.out.println("Which word number would you like? The maximum is " + (size));
            wordNumber = keyboard.nextInt();
            keyboard.nextLine(); // Consume the newline
        } while (wordNumber < 0 || wordNumber >= size);

        // Skip lines until reaching the desired word line
        for (int i = 0; i < wordNumber; i++) {
            file.nextLine();
        }

        // Parse the specific line to get the hidden word
        String wordLine = file.nextLine();
        file.close();

        // Split the line into parts and retrieve the word
        String[] parts = wordLine.split(" ");

        // Find a 5-letter word in the line
        for (String part : parts) {
            if (part.length() == WORD_LENGTH) {
                word = part;
                break;
            }
        }

        // If no 5-letter word is found, prompt the user to try again
        if (word.length() != WORD_LENGTH) {
            System.out.println("Error: No 5-letter word found. Please try again.");
            return getWordFromFile(size, keyboard); // Recursively call the method to try again
        }

        return word;
    }

    public static int showResult(String chosenWord, String guess)
    {
        int correctPositions = 0;
        StringBuilder result = new StringBuilder();

        // Temporary arrays to mark letters that are processed
        boolean[] chosenWordUsed = new boolean[WORD_LENGTH];
        boolean[] guessUsed = new boolean[WORD_LENGTH];

        // First pass: Check for letters in the correct position
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (guess.charAt(i) == chosenWord.charAt(i)) {
                result.append(SUCCESS);
                correctPositions++;
                chosenWordUsed[i] = true;
                guessUsed[i] = true;
            } else {
                result.append(' '); // Temporary placeholder
            }
        }

        // Second pass: Check for correct letters in the wrong positions
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (result.charAt(i) == ' ') { // Only check letters not matched in the first pass
                boolean found = false;
                for (int j = 0; j < WORD_LENGTH; j++) {
                    if (!chosenWordUsed[j] && !guessUsed[i] && guess.charAt(i) == chosenWord.charAt(j)) {
                        result.setCharAt(i, RIGHT_LETTER_WRONG_PLACE);
                        chosenWordUsed[j] = true;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result.setCharAt(i, WRONG_LETTER);
                }
            }
        }

        System.out.println(result.toString());
        return correctPositions;
    }
}
