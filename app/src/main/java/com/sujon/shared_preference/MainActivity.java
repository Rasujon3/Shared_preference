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
    Save save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmailText = findViewById(R.id.editTextTextEmailAddress);
        userPasswordText = findViewById(R.id.editTextTextPassword);
        submitButton = findViewById(R.id.button);

        save = Save.getInstance(this);
        if (save.getSaveBoolean("IS_LOGGEDIN")){
            Toast.makeText(this,"Welcome"+save.getSavedString("USER_EMAIL"),Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Log in first",Toast.LENGTH_SHORT).show();
        }


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEmailText.getText().toString();
                String password = userPasswordText.getText().toString();

                save.saveString("USER_EMAIL",email);
                save.saveBoolean("IS_LOGGEDIN",true);

            }
        });

    }
}