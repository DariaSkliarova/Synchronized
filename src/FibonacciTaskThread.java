public class FibonacciTaskThread extends Thread {

    int f;

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            f = getFibonacci(14);
        }
    }

    private int getFibonacci(int n) {
        int x = 0;
        int y = 1;
        if (n == 1) {
            return x;
        } else if (n == 2) {
            return y;
        } else {
            for (int i = 0; i < n - 2; i++) {
                int temp = y;
                y += x;
                x = temp;
            }
        }
        return y;
    }
}
