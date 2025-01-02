package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;
import java.util.HashMap;
import com.squareup.picasso.Picasso;




public class ThirdPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third_page);


        Intent intent = getIntent();
        String teamName = intent.getStringExtra("teamName");
        WebView webView = findViewById(R.id.webView);

//
        HashMap<String, HashMap<String, String>> teamsData =
                (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("teamsData");

        if (teamsData != null && teamName != null) {
            HashMap<String, String> selectedTeam = teamsData.get(teamName);

            if (selectedTeam != null) {
                // Oyuncu bilgilerini al
                String player1Name = selectedTeam.get("player1Name");
                int player1Image = Integer.parseInt(selectedTeam.get("player1Image"));

                String player2Name = selectedTeam.get("player2Name");
                int player2Image = Integer.parseInt(selectedTeam.get("player2Image"));

                String player3Name = selectedTeam.get("player3Name");
                int player3Image = Integer.parseInt(selectedTeam.get("player3Image"));

                String player4Name = selectedTeam.get("player4Name");
                int player4Image = Integer.parseInt(selectedTeam.get("player4Image"));

                String player5Name = selectedTeam.get("player5Name");
                int player5Image = Integer.parseInt(selectedTeam.get("player5Image"));

                String video = selectedTeam.get("video");


                // Örneğin, bir TextView ve ImageView'e set et
                TextView textViewPlayer1 = findViewById(R.id.textView5);
                ImageView imageViewPlayer1 = findViewById(R.id.imageView);

                TextView textViewPlayer2 = findViewById(R.id.textView4);
                ImageView imageViewPlayer2 = findViewById(R.id.imageView2);

                TextView textViewPlayer3 = findViewById(R.id.textView3);
                ImageView imageViewPlayer3 = findViewById(R.id.imageView3);

                TextView textViewPlayer4 = findViewById(R.id.textView2);
                ImageView imageViewPlayer4 = findViewById(R.id.imageView4);

                TextView textViewPlayer5 = findViewById(R.id.textView);
                ImageView imageViewPlayer5 = findViewById(R.id.imageView5);

                textViewPlayer1.setText(player1Name);
                imageViewPlayer1.setImageResource(player1Image);

                textViewPlayer2.setText(player2Name);
                imageViewPlayer2.setImageResource(player2Image);

                textViewPlayer3.setText(player3Name);
                imageViewPlayer3.setImageResource(player3Image);

                textViewPlayer4.setText(player4Name);
                imageViewPlayer4.setImageResource(player4Image);

                textViewPlayer5.setText(player5Name);
                imageViewPlayer5.setImageResource(player5Image);

                if (video!= null && !video.isEmpty()) {
                    webView.loadData(video, "text/html", "UTF-8");
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebChromeClient(new WebChromeClient());
                } else {
                    Toast.makeText(this, "Video URL is missing!", Toast.LENGTH_SHORT).show();
                }

            }

        }



//        ImageView player1Image = findViewById(R.id.imageView);
//        ImageView player2Image = findViewById(R.id.imageView2);
//        ImageView player3Image = findViewById(R.id.imageView3);
//        ImageView player4Image = findViewById(R.id.imageView4);
//        ImageView player5Image = findViewById(R.id.imageView5);
//
//        TextView player5Name = findViewById(R.id.textView);
//        TextView player4Name = findViewById(R.id.textView2);
//        TextView player3Name = findViewById(R.id.textView3);
//        TextView player2Name = findViewById(R.id.textView4);
//        TextView player1Name = findViewById(R.id.textView5);
//        // Intent'ten oyuncu isimlerini ve görsellerini al
//        Intent intent = getIntent();
//
//        // 1. Oyuncu
//        String name1 = intent.getStringExtra("jks_name");
//        int image1 = intent.getIntExtra("jks_image", 0);
//        if (name1 != null) player1Name.setText(name1);
//        if (image1 != 0) player1Image.setImageResource(image1);
//
//        // 2. Oyuncu
//        String name2 = intent.getStringExtra("naffly_name");
//        int image2 = intent.getIntExtra("naffly_image", 0);
//        if (name2 != null) player2Name.setText(name2);
//        if (image2 != 0) player2Image.setImageResource(image2);
//
//        // 3. Oyuncu
//        String name3 = intent.getStringExtra("twistzz_name");
//        int image3 = intent.getIntExtra("twistzz_image", 0);
//        if (name3 != null) player3Name.setText(name3);
//        if (image3 != 0) player3Image.setImageResource(image3);
//
//        // 4. Oyuncu
//        String name4 = intent.getStringExtra("ultimate_name");
//        int image4 = intent.getIntExtra("ultimate_image", 0);
//        if (name4 != null) player4Name.setText(name4);
//        if (image4 != 0) player4Image.setImageResource(image4);
//
//        String name5 = intent.getStringExtra("oyuncu yok");
//        int image5 = intent.getIntExtra("oyuncu_yok", 0);
//        if (name5 != null) player5Name.setText(name5);
//        if (image5 != 0) player5Image.setImageResource(image5);

    }
}