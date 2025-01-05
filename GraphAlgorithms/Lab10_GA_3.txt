TASK3:
import java.util.*;

public class Main {
    public static void main(String[] args) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);

        int numItems = scanner.nextInt();
        Map<String, Integer> valueMap = new HashMap<>();

        String[] itemNames = new String[numItems];

        for (int i = 0; i < numItems; i++) {
            String itemName = scanner.next();
            int itemValue = scanner.nextInt();
            valueMap.put(itemName, itemValue);

            itemNames[i] = itemName;
        }

        int numConnections = scanner.nextInt();

        String[] connectionSources = new String[numConnections];
        String[] connectionDestinations = new String[numConnections];

        for (int i = 0; i < numConnections; i++) {
            connectionSources[i] = scanner.next();
            connectionDestinations[i] = scanner.next();
        }

        int maxSum = 0;

        for (int i = 0; i < numConnections; i++) {
            int currentSum = 0;

            for (int j = i; j < numConnections; j++) {
                int sourceValue = valueMap.get(connectionSources[i]);
                int destinationValue = valueMap.get(connectionDestinations[i]);

                if (i == j) {
                    currentSum += sourceValue + destinationValue;
                }

                if (connectionDestinations[j].equals(connectionSources[i])) {
                    int additionalValue = valueMap.get(connectionSources[j]);
                    currentSum += additionalValue;
                }
            }

            maxSum = Math.max(currentSum, maxSum);
        }

        if (numConnections != 0) {
            System.out.println(maxSum);
        } else {
            for (int i = 0; i < numItems; i++) {
                int itemValue = valueMap.get(itemNames[i]);

                maxSum = Math.max(itemValue, maxSum);
            }
            System.out.println(maxSum);
        }
    }
}
