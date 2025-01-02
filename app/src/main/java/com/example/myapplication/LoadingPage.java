package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoadingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loading_page);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true); // Animasyonlu görünüm

        // İnternet bağlantısını kontrol et
        if (!isInternetAvailable()) {
            Toast.makeText(this, "İnternet bağlantısı yok", Toast.LENGTH_SHORT).show();
            finish();
        } else {

            loadData();
        }
    }

    private void loadData() {

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            runOnUiThread(() -> {
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();
            });
        }).start();
    }
    public boolean isInternetAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkCapabilities nw = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (nw != null) {
            // Check for internet transport types
            if (nw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true;
            } else if (nw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true;
            } else return nw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET);
        }
        return false;
    }
}

