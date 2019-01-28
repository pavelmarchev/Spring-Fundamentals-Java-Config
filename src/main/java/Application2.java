import java.util.stream.Stream;

public class Application2 {

    // testing some lazy evaluation and purity of the code with FRP (Functional Reactive Programming):

    // Problem: Given numbers n and k, compute the total sum of sqrt of the first k even numbers starting from n to k.

    // solving the problem with the typical sequential execution of java code:
    public static double compute(int n, int k) {
        int index = n;
        int count = 0;
        double result = 0;

        while (count < k) {
            if (index % 2 == 0) {
                result += Math.sqrt(index);
                count++;
            }
            index++;
        }
        return result;
    }

    // functional lazy programming with Java Streams. Less struggle with code complexity and garbage variables
    public static double computeWithStream(int n, int k) {
        return Stream.iterate(n, e -> e + 1)
                .filter(e -> e % 2 == 0)
                .mapToDouble(e -> Math.sqrt(e))
                .limit(k)
                .sum();
        // you can use method reference approach to reduce noise in the code: Math::sqrt instead of e -> Math.sqrt(e)
    }

    public static void main(String[] args) {
        int n = 72;
        int k = 219;

        System.out.println(compute(n, k));
    }
}
