import java.util.Scanner;
//This projects goal is to test if some is just exhausted or actually stressed out
//This can be a great test to ask students and it take around a minute or less
public class Project3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = 0; // Accumulator for the stress score
        //States the possible string answers to the next questions that will be asked
        System.out.println("Answer yes or no to the following questions");

        // Question 1
        System.out.println("I am losing my sense of humor.");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            score++;
        }

        // Question 2
        System.out.println("I find it more and more difficult to see people socially.");
        answer = input.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            score++;
        }

        // Question 3
        System.out.println("I feel tired most of the time.");
        answer = input.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            score++;
        }

        // Checks the stress score and prints final statement based on score
        if (score == 0) {
            System.out.println("You are more exhausted than stressed out");
        } else if (score == 1) {
            System.out.println("You are beginning to stress out");
        } else if (score == 2) {
            System.out.println("You are possibly stressed out");
        } else {
            System.out.println("You are probably stressed out");
        }

        input.close();
    }
}