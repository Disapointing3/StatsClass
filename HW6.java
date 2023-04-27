import java.util.Scanner;

public class HW6 { //shesh br
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of realizations: ");
        int n = scanner.nextInt();
        double[] x = new double[n];
        double[] y = new double[n];
        System.out.println("Enter realizations for first RV: ");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }
        System.out.println("Enter realizations for second RV: ");
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }
        double covariance = covariance(x, y);
        double correlation = correlation(x, y);
        System.out.println("Covariance: " + covariance);
        System.out.println("Correlation: " + correlation);
    }

    public static double mean(double[] data) {
        double sum = 0;
        for (double d : data) {
            sum += d;
        }
        return sum / data.length;
    }

    public static double covariance(double[] x, double[] y) {
        double xMean = mean(x);
        double yMean = mean(y);
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += (x[i] - xMean) * (y[i] - yMean);
        }
        return sum / (x.length - 1);
    }

    public static double standardDeviation(double[] data) {
        double mean = mean(data);
        double sum = 0;
        for (double d : data) {
            sum += Math.pow(d - mean, 2);
        }
        return Math.sqrt(sum / (data.length - 1));
    }

    public static double correlation(double[] x, double[] y) {
        return covariance(x, y) / (standardDeviation(x) * standardDeviation(y));
    }
}