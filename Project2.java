import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) {
    	//this open the scanner and names it keyboard
        Scanner keyboard = new Scanner(System.in);
        //Asks for the name of the yarn and assigns it as a string value to patternYarnName
        System.out.println("Enter the name of the yarn specified by your pattern.");
        String patternYarnName = keyboard.nextLine();
        //Ask the number of original yarn balls required for the pattern and assigns it as a int value to patternYarnBalls
        System.out.println("Enter the number of balls of " + patternYarnName + " that are required.");
        int patternYarnBalls = keyboard.nextInt();
        //Asks the number of yards in each ball of the original yarn ball and assigns it as a int value to patterYarnYards
        System.out.println("Enter the number of yards per ball of " + patternYarnName + ".");
        int patternYarnYards = keyboard.nextInt();
        //pauses code so that the substituteYarnName question and substituteYarnYards question aren't asked at the same time
        keyboard.nextLine();
        //Asks the name of the substitute yarn ball and assigns it as a string value to substituteYarnName
        System.out.println("Enter the name of the substitute yarn.");
        String substituteYarnName = keyboard.nextLine();
        //Asks for the number of yards in each ball of the substitute yarn and assigns it as a int value to substitueYarnYards
        System.out.println("Enter the number of yards per ball of " + substituteYarnName + ".");
        int substituteYarnYards = keyboard.nextInt();
        //Finds the number of total number of yards of yarn needed for the pattern and assigns it as a double value to totalYardsNeeded
        double totalYardsNeeded = patternYarnBalls * patternYarnYards;
        //Does the math to find the number of substituted yarn balls needed and calculates it as a int value and assigns it to substituteYarnBalls
        int substituteYarnBalls = (int) Math.ceil(totalYardsNeeded / substituteYarnYards);
        //Prints the final statement of how many substitute yarns balls you should purchase
        System.out.println("You should purchase " + substituteYarnBalls + " balls of " + substituteYarnName +
                           " instead of " + patternYarnBalls + " balls of " + patternYarnName + ".");
        //Closes the scanner
        keyboard.close();
    }
}