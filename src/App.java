/**
 * @author: MARK ANDREW B. DUZA
 *          BSIT 103
 *          Computer Programming E-LMS Activity
 */

public class App {

    // useable variables
    static int rows = 10;
    static String symbol = "*";

    Object upper = new Object();
    Object lower = new Object();

    public void up() throws Exception {
        synchronized (upper) {
            // upper section
            for (int i = 1; i <= rows; i++) {
                for (int j = rows; j > i; j--) {
                    System.out.print(" ");
                }
                // symbol
                System.out.print(symbol);
                Thread.sleep(100);
                for (int k = 1; k < (i - 1) * 2; k++) {
                    // space
                    System.out.print(" ");
                }
                if (i == 1) {
                    // proceeds to the next line
                    System.out.println();
                } else {
                    // prints the symbol and then proceeds to the next line
                    System.out.println(symbol);
                    Thread.sleep(100);
                }
            }
        }
    }

    public void low() throws Exception {
        // lower section
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = rows; j > i; j--) {
                // space
                System.out.print(" ");
            }
            // symbol
            System.out.print(symbol);
            Thread.sleep(100);
            for (int k = 1; k < (i - 1) * 2; k++) {
                // space
                System.out.print(" ");
            }
            if (i == 1) {
                // proceeds to the next line
                System.out.println();
            } else {
                System.out.println(symbol);
                Thread.sleep(100);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int MAX_EXECUTION = 5;
        for (int i = 0; i < MAX_EXECUTION; i++) {
            Runnable upperSection = new Runnable() {
                @Override
                public void run() {
                    try {
                        new App().up();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            Runnable lowerSection = new Runnable() {
                @Override
                public void run() {
                    try {
                        new App().low();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread first = new Thread(upperSection);
            Thread second = new Thread(lowerSection);
            first.start();
            first.join();
            second.start();
            second.join();
        }
    }
}
