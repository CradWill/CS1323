import java.util.Scanner;

public class Project4 {
    public static void main(String[] args) {
        // Constant
        final int SENTINEL = -1;
        final int INITIAL_SETTING = 3;

        // Scanner that takes user input
        Scanner scanner = new Scanner(System.in);

        // Variables for dial settings and changes
        int[] settingCounts = new int[5];  // counts occurrences 
        int positiveChanges = 0;
        int negativeChanges = 0;
        int noChanges = 0;
        int currentSetting;
        int previousSetting = INITIAL_SETTING;

        // prompt to user
        System.out.println("Response Dial Simulator");
        System.out.println("-----------------------");
        System.out.println("Initial setting: " + INITIAL_SETTING);

      
        System.out.println("Enter the next setting (1-5) or -1 to stop.");
        currentSetting = scanner.nextInt();

        // Main loop
        while (currentSetting != SENTINEL) {
            // Update setting count
            settingCounts[currentSetting - 1]++;

            // Determine change type
            if (currentSetting > previousSetting) {
                System.out.println("Positive change: " + previousSetting + " to " + currentSetting);
                positiveChanges++;
            } else if (currentSetting < previousSetting) {
                System.out.println("Negative change: " + previousSetting + " to " + currentSetting);
                negativeChanges++;
            } else {
                System.out.println("No change: " + previousSetting + " to " + currentSetting);
                noChanges++;
            }

            // Print current setting
            System.out.println("Current setting: " + currentSetting);

            // Make the previous setting equal to current setting
            previousSetting = currentSetting;

            // next setting
            System.out.println("Enter the next setting (1-5) or -1 to stop.");
            currentSetting = scanner.nextInt();
        }
        //Summary
        System.out.println("Response Summary");
        System.out.println("----------------");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + " was chosen " + settingCounts[i] + " time(s).");
        }
        System.out.println("Positive changes: " + positiveChanges);
        System.out.println("Negative changes: " + negativeChanges);
        System.out.println("No changes: " + noChanges);

        scanner.close();
    }
}