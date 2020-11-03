import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {
    private int id;
    private Semaphore semaphore;
    private int mB = 0;
    private CountDownLatch cdl;

    public Downloader(int id, Semaphore semaphore, CountDownLatch cdl) {
        this.id = id;
        this.semaphore = semaphore;
        this.cdl = cdl;
    }

    public void run() {
        try {
            semaphore.acquire();

            System.out.println("\n----------next " + this.getName() + "is allowed to download ------------------");
            sleep(500);

            for (int i = 1; i < 6; i++) {
                mB = mB + 100;
                System.out.println("\n Downloader " + id + " got " + mB + "mB" + "(100mB/sec)");
                sleep(1000);
            }
            semaphore.release();
        } catch (Exception e) {
        }
    }
}
