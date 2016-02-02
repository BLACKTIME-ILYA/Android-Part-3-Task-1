package com.sourceit.task1.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sourceit.task1.R;
import com.sourceit.task1.utils.L;
import com.sourceit.task1.utils.Toasts;

public class MainActivity extends AppCompatActivity {

    private final int SECONDS = 5000;
    private final int UPDATE_TIME = 500;
    private final int PERCENT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.d("create Activity...");

        new MyAsyncTask().execute();
    }

    class MyAsyncTask extends AsyncTask<Void, String, Void> {

        TextView progress = (TextView) findViewById(R.id.TextView_Progress);
        int iterations = SECONDS / UPDATE_TIME;

        @Override
        protected void onPreExecute() {
            Toasts.show("starting...");
        }

        @Override
        protected Void doInBackground(Void... params) {

            for (int i = 0; i < iterations; i++) {

                try {
                    L.d("iteration " + i);
                    Thread.sleep(UPDATE_TIME);
                    publishProgress(String.valueOf(PERCENT / iterations * (i + 1)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toasts.show("finish");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            progress.setText(values[0]+"%");
        }
    }
}
