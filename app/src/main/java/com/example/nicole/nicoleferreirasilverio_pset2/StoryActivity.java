package com.example.nicole.nicoleferreirasilverio_pset2;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // get the data needed
        String storyComplete = getIntent().getExtras().getString("completeStory");
        // make TextView completed
        TextView completed = (TextView) findViewById(R.id.textView5);
        // enter the story just filled in into completed
        completed.setText(storyComplete);
    }

    // create a function to go back to the homescreen if wanted
    public void createNew(View view){
        Intent goToHomeScreen = new Intent(this, WelcomeActivity.class);
        startActivity(goToHomeScreen);
        finish();
    }
}
