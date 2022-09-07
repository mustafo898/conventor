package dark.composer.conventor.utils;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFileService extends IntentService {
    public static final String URL = "urlpath";
    public static final String FILENAME = "filename";
    public static final String FILEPATH = "filepath";
    public static final String RESULT = "result";
    public static final String PROGRESS = "progress";
    public static final String NOTIFICATION = "jx.pdp_dars";
    private static final String TAG = "LOADER";
    private int result = -1;

    public DownloadFileService() {
        super("DownloadFileService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String urlPath = intent.getStringExtra(URL);
        String fileName = intent.getStringExtra(FILENAME);
        String filePath = "";
        int count;
        try {
            java.net.URL url = new URL(urlPath);
            URLConnection connection = url.openConnection();
            connection.connect();
            // getting file length
            int lengthOfFile = connection.getContentLength();
            // input stream to read file - with 8k buffer
            InputStream input = new BufferedInputStream(url.openStream(), 8192);
            //Create androiddeft folder if it does not exist
            File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/convertor");
            if (!directory.exists()) {
                directory.mkdir();
            }
            // Output stream to write file
            File file = new File(directory.getAbsolutePath(), fileName);
            filePath = file.getAbsolutePath();
            OutputStream output = new FileOutputStream(file);
            byte[] data = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                // After this onProgressUpdate will be called
                publishProgress((int) ((total * 100) / lengthOfFile), 0);

                // writing data to file
                output.write(data, 0, count);
            }
            // flushing output
            output.flush();

            // closing streams
            output.close();
            input.close();

            result = 1;

        } catch (Exception e) {
            Log.e("EXCEPTION", e.getMessage());
        }
        publishResults(filePath, result);
    }

    private void publishResults(String outputPath, int result) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(FILEPATH, outputPath);
        intent.putExtra(RESULT, result);
        sendBroadcast(intent);
    }

    private void publishProgress(int progress, int result) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(PROGRESS, progress);
        intent.putExtra(RESULT, result);
        sendBroadcast(intent);
    }
}

