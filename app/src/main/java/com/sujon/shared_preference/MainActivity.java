package com.sujon.shared_preference;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText userEmailText,userPasswordText;
    Button submitButton;
    SharedPreferences preferences;
    String myPreferenceName = "SHAREPREFERENCE_FILEONE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmailText = findViewById(R.id.editTextTextEmailAddress);
        userPasswordText = findViewById(R.id.editTextTextPassword);
        submitButton = findViewById(R.id.button);
        preferences = getSharedPreferences(myPreferenceName,MODE_PRIVATE);

        if (preferences.getBoolean("IS_LOGGEDIN",false)){
            String email = preferences.getString("USER_EMAIL",null);
            if (email!=null)
                Toast.makeText(this,"WELCOME "+email,Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this,"Please Log in first",Toast.LENGTH_SHORT).show();
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEmailText.getText().toString();
                String password = userPasswordText.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("USER_EMAIL",email);
                editor.putBoolean("IS_LOGGEDIN",true);

//                editor.commit();
                editor.apply();

            }
        });

    }
}