public class Tr {
    public static void main(String[] args) throws java.lang.Exception {
        int i = 0;
        while (i < 21) {
            System.out.print("[");
            for (int j = 0; j < i; j++) {
                System.out.print("🟩");
            }
            for (int j = 0; j < 20 - i; j++) {
                System.out.print(" ");
            }
            System.out.print("] " + i * 5 + "%");
            if (i < 20) {
                System.out.print("\r");
                Thread.sleep(300);
            }
            i++;
        }
        System.out.println();
    }
}
