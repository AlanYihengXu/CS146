package ExtraCredit.ThirdLightbulb;

public class Fibonacci {
    public static int nthFibonacci(int n) {
        if (n == 0) return 0;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        if (args.length > 0)
            System.out.println(nthFibonacci(Integer.parseInt(args[0])));
    }
}
