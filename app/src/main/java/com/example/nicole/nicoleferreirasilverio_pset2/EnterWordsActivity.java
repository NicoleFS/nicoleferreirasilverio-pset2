package com.example.nicole.nicoleferreirasilverio_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class EnterWordsActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_words);

        // initialize an inputstream
        InputStream inputText;

        // generate a random number
        Random rand = new Random();
        int randomNum = rand.nextInt((5 - 1) + 1) + 1;

        // put the randomly chosen text in inputText
        try{
            if (randomNum == 1){
                inputText = getAssets().open("madlib0_simple.txt");
            }
            else if (randomNum == 2){
                inputText = getAssets().open("madlib1_tarzan.txt");
            }
            else if (randomNum == 3){
                inputText = getAssets().open("madlib2_university.txt");
            }
            else if (randomNum == 4){
                inputText = getAssets().open("madlib3_clothes.txt");
            }
            else if (randomNum == 5){
                inputText = getAssets().open("madlib4_dance.txt");
            }
            else{
                inputText = null;
            }
        }catch (IOException e){
            e.printStackTrace();
            inputText = null;
        }

        // if inputText is not empty
        if(inputText != null){
            // create story
            story = new Story(inputText);
            setContentView(R.layout.activity_enter_words);
            // make TextView wordsLeft
            TextView wordsLeft = (TextView) findViewById(R.id.textView4);
            // set the text of wordsleft to show the remaining words to be filled in
            wordsLeft.setText(story.getPlaceholderRemainingCount() + " word(s) left");
            // make EditText wordFill
            EditText wordFill = (EditText) findViewById(R.id.editText);
            // set the hint of wordFill to show the placeholder
            wordFill.setHint(story.getNextPlaceholder());

        }
    }
    // create a function to fill the placeholders and continue to the last screen
    public void fillPlace(View view){
        EditText filledIn = (EditText) findViewById(R.id.editText);
        TextView wordsLeft = (TextView) findViewById(R.id.textView4);
        // if the text entered in filledIn is not empty
        if (filledIn.getText().length() != 0) {
            // fill in the placeholder with the entered word
            story.fillInPlaceholder(filledIn.getText().toString());
            // set the hint of filledIn
            filledIn.setHint(story.getNextPlaceholder());
            // show how many words need to be filled in
            wordsLeft.setText(story.getPlaceholderRemainingCount() + " word(s) left");

            // if there are no more words that need to be filled in
            if (story.getPlaceholderRemainingCount() == 0) {
                // go to the next screen
                Intent goToStoryActivity = new Intent(this, StoryActivity.class);
                goToStoryActivity.putExtra("completeStory", story.toString());
                startActivity(goToStoryActivity);
                finish();
            }
        }
        // if there is no text entered in filledIn
        else{
                // ask user to enter a word
                wordsLeft.setText("Please enter a word.\n" + story.getPlaceholderRemainingCount() + " word(s) left");
        }
        // make sure that after entering a word, the text in filledIn disappears
        filledIn.setText("");
    }
}
