package fileDownloaderSimulationUsingThreads;

public class DownloadManager {

    public static void main(String[] args) {

        String[] urls = new String[25];
        for (int i = 0; i < 25; i++) {
            urls[i] =
                "https://www.dropbox.com/photo" + (i + 1) + ".jpg";
        }

        for (int i = 0; i < urls.length; i++) {
            Thread t = new Thread(
                    new FileDownloader(urls[i]),
                    "Downloader-" + (i + 1)
            );
            t.start();
        }
    }
}
