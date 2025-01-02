package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;


import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



            FirebaseFirestore db = FirebaseFirestore.getInstance();


            DocumentReference docRef = db.collection("Teams").document("Fnatic");
            Source source = Source.CACHE;
            docRef.get(source).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        String takimAdi = documentSnapshot.getString("takimAdi");
                    } else Log.d("TAG", "Belge bulunamadı");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // Belge okunurken hata oluştu
                    Log.d("tag2", "Bir hata oluştu");
                }
            });

            ArrayList<Teams> ArrayList_teams = new ArrayList<>();

            CustomTeamAdapter customTeamAdapter = new CustomTeamAdapter(this, ArrayList_teams);
            ListView listView = findViewById(R.id.listView);
            listView.setAdapter(customTeamAdapter);

            db.collection("Teams")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Teams t = new Teams(
                                            document.getString("takimAdi"),
                                            document.getString("takimLogo"),
                                            document.getString("takimMilliyeti"),
                                            document.getLong("takimSiralama").intValue()
                                    );
                                    ArrayList_teams.add(t);
                                }
                                // Adapter'i bilgilendir
                                customTeamAdapter.notifyDataSetChanged();
                            } else {
                                Toast.makeText(MainActivity.this, "Hata oluştu 2: " + task.getException(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

            listView.setOnItemClickListener((parent, view, position, id) -> {
                //Teams selectedTeam = ArrayList_teams.get(position);
                Intent intent = new Intent(MainActivity.this, ThirdPage.class);

                HashMap<String, HashMap<String, String>> teamsData = new HashMap<>();
                if (position == 0) // Liquid
                {
                    HashMap<String, String> Liquid = new HashMap<>();
                    Liquid.put("player1Name", "JKS");
                    Liquid.put("player1Image", String.valueOf(R.drawable.jks));
                    Liquid.put("player2Name", "Naf-Fly");
                    Liquid.put("player2Image", String.valueOf(R.drawable.naffly));
                    Liquid.put("player3Name", "Twistzz");
                    Liquid.put("player3Image", String.valueOf(R.drawable.twistzz));
                    Liquid.put("player4Name", "Ultimate");
                    Liquid.put("player4Image", String.valueOf(R.drawable.ultimate));
                    Liquid.put("player5Name", "oyuncu yok");
                    Liquid.put("player5Image", String.valueOf(R.drawable.ic_launcher_background));
                    Liquid.put("video","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/jWssTf8C3cM?si=oeTly-BtH-T1RxK3\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

                    teamsData.put("Liquid", Liquid);
                    intent.putExtra("teamName", "Liquid");

                }
                else if (position == 1) // Fnatic
                {
                    HashMap<String, String> Fnatic = new HashMap<>();
                    Fnatic.put("player1Name", "Krimz");
                    Fnatic.put("player1Image", String.valueOf(R.drawable.krimz));
                    Fnatic.put("player2Name", "BlameF");
                    Fnatic.put("player2Image", String.valueOf(R.drawable.blamef));
                    Fnatic.put("player3Name", "Matys");
                    Fnatic.put("player3Image", String.valueOf(R.drawable.matys));
                    Fnatic.put("player4Name", "bodyy");
                    Fnatic.put("player4Image", String.valueOf(R.drawable.bodyy));
                    Fnatic.put("player5Name", "nawwk");
                    Fnatic.put("player5Image", String.valueOf(R.drawable.nawwk));
                    Fnatic.put("video","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/7RAthztuvpA?si=lXdqSoZsWNd44Ab8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

                    teamsData.put("Fnatic", Fnatic);
                    intent.putExtra("teamName", "Fnatic");

                }
                else if (position == 2) // G2
                {
                    HashMap<String, String> G2 = new HashMap<>();
                    G2.put("player1Name", "Niko");
                    G2.put("player1Image", String.valueOf(R.drawable.niko));
                    G2.put("player2Name", "Snax");
                    G2.put("player2Image", String.valueOf(R.drawable.snax));
                    G2.put("player3Name", "Hunter");
                    G2.put("player3Image", String.valueOf(R.drawable.hunter));
                    G2.put("player4Name", "Moneys");
                    G2.put("player4Image", String.valueOf(R.drawable.moneys));
                    G2.put("player5Name", "MalbsMd");
                    G2.put("player5Image", String.valueOf(R.drawable.malbsmd));
                    G2.put("video","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rlSER5KPNWU?si=gpc28oK0SX29PMOS\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

                    teamsData.put("G2", G2);
                    intent.putExtra("teamName", "G2");


                }
                else if (position == 3) // Eternal Fire
                {
                    HashMap<String, String> eternalFire = new HashMap<>();
                    eternalFire.put("player1Name", "Calyx");
                    eternalFire.put("player1Image", String.valueOf(R.drawable.calyx));
                    eternalFire.put("player2Name", "MAJ3R");
                    eternalFire.put("player2Image", String.valueOf(R.drawable.majer));
                    eternalFire.put("player3Name", "Woxic");
                    eternalFire.put("player3Image", String.valueOf(R.drawable.woxic));
                    eternalFire.put("player4Name", "Xantares");
                    eternalFire.put("player4Image", String.valueOf(R.drawable.xantares));
                    eternalFire.put("player5Name","Wicadia");
                    eternalFire.put("player5Image",String.valueOf(R.drawable.wicadia));
                    eternalFire.put("video","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SS7ne332X-g?si=3w8APpblxGw4i1Xl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>");

                    teamsData.put("EternalFire", eternalFire);
                    intent.putExtra("teamName", "EternalFire");
                    intent.putExtra("teamsData", teamsData);

                }

                intent.putExtra("teamsData", teamsData);
                startActivity(intent);
        });

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

//DatabaseReference DB = FirebaseDatabase.getInstance().getReference("teams");
//DB.

}
