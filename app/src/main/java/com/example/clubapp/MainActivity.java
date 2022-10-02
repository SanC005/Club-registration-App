package com.example.clubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSignin =findViewById(R.id.buttonSignin);
        Button buttonSignup =findViewById(R.id.buttonSignup);
        Button buttonEvent =findViewById(R.id.Eventsbutton);


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