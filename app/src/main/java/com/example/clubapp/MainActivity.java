package com.example.clubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Firebase.setAndroidContext(this);
//        Firebase ref= new Firebase("https://console.firebase.google.com/project/club-registration-app/database/club-registration-app-default-rtdb/data/~2F");
        Button buttonSignin =findViewById(R.id.buttonSignin);
        Button buttonSignup =findViewById(R.id.buttonSignup);
        Button buttonEvent =findViewById(R.id.Eventsbutton);

        DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                if (connected) {
                    Log.d("TAG", "connected");
                } else {
                    Log.d("(TAG", "not connected");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            Log.w("TAG", "Listener was cancelled");
            }

        });
        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fm.beginTransaction();
                BlankFragment blankFragment=new BlankFragment();
                fragmentTransaction.add(R.id.fragmentContainerView,blankFragment,null);
                fragmentTransaction.commit();


            }
        });
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Events_page.class);
                startActivity(intent);
            }
        });
    }
}