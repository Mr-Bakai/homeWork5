
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class Main {

    public static void main(String[] args) {

        CountDownLatch cdl = new CountDownLatch(1);
        CountDownLatch cdd = new CountDownLatch(10);
        try {
            Uploader ud = new Uploader("Uploader", cdl, 500, 20);
            ud.start();
            ud.join();

            cdl.countDown();
            cdl.await();
            //System.out.println(cdl.getCount() + " --=======================");

            Semaphore sp = new Semaphore(3);
            for (int i = 1; i < 11; i++) {
                Downloader dw = new Downloader(i, sp, cdd);
                dw.start();
            }
            cdd.await();
            ud.progressBar();
        } catch (Exception e) {
        }
    }
}

/*5)  Вариант А (Дэдлайн 31.10.2020 18:59)
a)  Написать многопоточное приложение, которое
    бы симулировало загрузку файлов на сервер.
    И их скачивание. Используя классы Semaphore и CountDownLatch.
    Либо можно использовать методы wait(), notify(), notifyAll().                   ✅

b)  Uploader загружает 1 файл 500 мб на сервер. Скорость загрузки 20 мб в секунду.
    Нужно в консоли отобразить процесс загрузки симулируя через sleep().            ✅

c)  После того как весь файл загружен на сервер Downloaders начинают его
    скачивать со скоростью 100 мб в секунду. Должны скачать файл 10 человек,
    одновременно могут скачивать не более 3х человек.                               ✅

d)  После того как файл был скачан 10 раз, он удаляется с сервера                   ✅

 */
