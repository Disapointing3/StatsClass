import java.util.Random;

public class HW5 {
    public static void main(String[] args) // Does problems five and six (bruh this code took forever)
    {
        //Uses void methods for general code clarity
        fiveA();
        fiveB();
        six();
    }

    public static void fiveA()
    {
        int numTrials = 1000000; // Number of times to run the experiment
        int[] counts = new int[4 * 6 + 1]; // Array to keep track of the number of times each sum occurs
        Random rand = new Random(); // Random number generator

        // Run the experiment numTrials times
        for (int i = 0; i < numTrials; i++) {
            int sum = 0;
            // Roll four dice and compute their sum
            for (int j = 0; j < 4; j++) {
                int roll = rand.nextInt(6) + 1;
                sum += roll;
            }
            // Increment the count for this sum
            counts[sum]++;
        }

        // Print the estimated PMF
        System.out.println("PMF of Y = X1 + X2 + X3 + X4:");
        for (int i = 4; i <= 24; i++) {
            double probability = (double) counts[i] / numTrials;
            System.out.println("P(Y = " + i + ") = " + probability);
        }
    }

    public static void fiveB()
    {
        int numTrials = 1000000; // Number of times to run the experiment
        int[] counts = new int[6]; // Array to keep track of the number of times each difference occurs
        Random rand = new Random(); // Random number generator

        // Run the experiment numTrials times
        for (int i = 0; i < numTrials; i++) {
            int max = 0;
            int min = 6;
            // Roll four dice and compute their maximum and minimum
            for (int j = 0; j < 4; j++) {
                int roll = rand.nextInt(6) + 1;
                if (roll > max) max = roll;
                if (roll < min) min = roll;
            }
            // Increment the count for this difference
            counts[max - min]++;
        }

        // Print the estimated PMF
        System.out.println("PMF of Z = max(X1, X2, X3, X4) - min(X1, X2, X3, X4):");
        for (int i = 0; i <= 5; i++) {
            double probability = (double) counts[i] / numTrials;
            System.out.println("P(Z = " + i + ") = " + probability);
        }
    }

    public static void six()
    {
        int n = 10; // Number of Bernoulli random variables to sum
        double p = 0.5; // Probability of success for each Bernoulli random variable
        int numTrials = 1000000; // Number of times to run the experiment
        int[] counts = new int[n + 1]; // Array to keep track of the number of times each sum occurs
        Random rand = new Random(); // Random number generator

        // Run the experiment numTrials times
        for (int i = 0; i < numTrials; i++) {
            int sum = 0;
            // Generate n Bernoulli random variables and compute their sum
            for (int j = 0; j < n; j++) {
                boolean success = rand.nextDouble() < p;
                if (success) sum++;
            }
            // Increment the count for this sum
            counts[sum]++;
        }

        // Print the estimated PMF of the sum of n Bernoulli random variables
        System.out.println("PMF of X = X1 + X2 + ... + Xn where Xi ~ Ber(p):");
        for (int i = 0; i <= n; i++) {
            double probability = (double) counts[i] / numTrials;
            System.out.println("P(X = " + i + ") = " + probability);
        }

        // Print the PMF of a binomial random variable with parameters n and p
        System.out.println("\nPMF of Y ~ Bin(n, p):");
        for (int i = 0; i <= n; i++) {
            double probability = binomialProbability(n, p, i);
            System.out.println("P(Y = " + i + ") = " + probability);
        }
        
    }

    // Computes the probability mass function of a binomial random variable with parameters n and p
    public static double binomialProbability(int n, double p, int k) {
        return binomialHelper(n, k) * Math.pow(p, k) * Math.pow(1 - p, n - k);
    }

    // Computes n choose k
    public static long binomialHelper(int n, int k) {
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}


