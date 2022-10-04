package com.example.clubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_layout);
        Firebase.setAndroidContext(this);
        Firebase ref = new Firebase("https://club-registration-app-default-rtdb.asia-southeast1.firebasedatabase.app");
        ImageView back = findViewById(R.id.back_button);
        EditText editreg = findViewById(R.id.editReg);
        EditText editemail = findViewById(R.id.editEmail);
        EditText editpassword = findViewById(R.id.editPassword);
        Button button = findViewById(R.id.buttoninsignuppage);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            details det = new details(editreg.getText().toString(),editemail.getText().toString(),editpassword.getText().toString());
//                Toast toast = Toast.makeText(getApplicationContext(),det.reg_id + det.email_id +det.password,Toast.LENGTH_LONG);
//                        toast.show();
//            ref.child("details").child((det.reg_id)).setValue(det);
            ref.push().setValue(det);
            editreg.setText("");
            editemail.setText("");
            editpassword.setText("");
            }
        });
    }
}