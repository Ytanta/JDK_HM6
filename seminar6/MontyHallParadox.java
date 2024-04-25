package seminar6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MontyHallParadox {
    public static void main(String[] args) {
        Map<Integer, Boolean> results = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество шагов цикла: ");
        int numIterations = scanner.nextInt();

        int positiveCount = 0;
        int negativeCount = 0;

        Random rand = new Random();

        for (int i = 1; i <= numIterations; i++) {
            int prizeDoor = rand.nextInt(3) + 1;
            int initialChoice = rand.nextInt(3) + 1;

            int revealedDoor;
            do {
                revealedDoor = rand.nextInt(3) + 1;
            } while (revealedDoor == prizeDoor || revealedDoor == initialChoice);

            int finalChoice;
            do {
                finalChoice = rand.nextInt(3) + 1;
            } while (finalChoice == initialChoice || finalChoice == revealedDoor);

            boolean isWin = finalChoice == prizeDoor;
            results.put(i, isWin);

            if (isWin) {
                positiveCount++;
            } else {
                negativeCount++;
            }
        }

        System.out.println("Положительные результаты: " + positiveCount);
        System.out.println("Негативные результаты: " + negativeCount);

        double positivePercentage = (double) positiveCount / numIterations * 100;
        double negativePercentage = (double) negativeCount / numIterations * 100;

        System.out.printf("Процент положительных результатов: %.2f%%\n", positivePercentage);
        System.out.printf("Процент негативных результатов: %.2f%%\n", negativePercentage);
    }
}