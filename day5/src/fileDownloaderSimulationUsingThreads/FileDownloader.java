package fileDownloaderSimulationUsingThreads;

import java.util.concurrent.ThreadLocalRandom;

public class FileDownloader implements Runnable {

    private String fileUrl;

    public FileDownloader(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    private String getFileName() {
        return fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
    }

    @Override
    public void run() {

        String fileName = getFileName();
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " - Starting download: " + fileName);

        try {
            int sleepTime =
                    ThreadLocalRandom.current().nextInt(200, 501);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(threadName + " - Completed: " + fileName);
    }
}
