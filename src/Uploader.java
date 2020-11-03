import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {

    private CountDownLatch cdl;
    private int fileSize;
    private int mB;

    // char[] animationChars = new char[]{'|', '/', '-', '\\'};
    String[] animationChars = new String[]{"\uD83D\uDFE9", "\uD83D\uDFE9\uD83D\uDFE9", "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9", "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9",
            "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9", "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9",
            "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9", "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9"
            , "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9",
            "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9",
            "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9"
    };

    // String[] animationChars = new String[]{download, download + download, download + download + download};
    public Uploader(String name, CountDownLatch cdl, int fileSize, int mB) {
        super(name);
        this.cdl = cdl;
        this.fileSize = fileSize;
        this.mB = mB;
    }

    public void run() {
        try {
            //Progress bar for uploading
            for (int i = 0; i < 100; i++) {
                fileSize = fileSize - 20;
                mB = mB + 20;
                System.out.print("Uploading: " + i + "% " + animationChars[i % 11] + "\r");
                sleep(200);
            }
            System.out.println("Uploading is : Done ☑️ ");
            sleep(1000);

            // Progress bar for deleting file
            for (int i = 0; i < 11; i++) {
                System.out.print("Deleting file from server: " + i + "% " + animationChars[i % 11] + "\r");
                sleep(300);
            }
            sleep(1000);
            System.out.println("File has been deleted ☑️");
        } catch (Exception e) {
        }
    }
}
