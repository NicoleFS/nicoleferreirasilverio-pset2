package com.example.nicole.nicoleferreirasilverio_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    // create a function to go to the next screen
    public void forward(View view){
        Intent goToEnterWordsActivity = new Intent(this, EnterWordsActivity.class);
        startActivity(goToEnterWordsActivity);
        finish();
    }
}

