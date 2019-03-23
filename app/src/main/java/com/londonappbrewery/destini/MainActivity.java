package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryText;
    private Button mButtonTop, mButtonBottom;
    private int mStoryIndex=1, flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1){
                    gameFinished();
                }
                if(mStoryIndex == 1) {
                    mStoryText.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                }

                else if(mStoryIndex == 2) {
                    mStoryText.setText(R.string.T6_End);
                    flag = 1;
                }

                else if(mStoryIndex == 3){
                    mStoryText.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                }

                else if(mStoryIndex == 4){
                    mStoryText.setText(R.string.T6_End);
                    flag = 1;
                }

                mStoryIndex  = mStoryIndex + 1;
            }
        });

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1){
                    gameFinished();
                }
                if(mStoryIndex == 1){
                    mStoryText.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T2_Ans2);
                }
                else if(mStoryIndex == 2){
                    mStoryText.setText(R.string.T5_End);
                    flag = 1;
                }

                else if(mStoryIndex == 3){
                    mStoryText.setText(R.string.T4_End);
                    flag = 1;
                }

                else if(mStoryIndex == 4){
                    mStoryText.setText(R.string.T5_End);
                    flag = 1;
                }

                mStoryIndex  = mStoryIndex + 1;
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }

    private void gameFinished(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Game is Finished!");
        alert.setCancelable(false);
        alert.setMessage("Thank You for playing this game.");
        alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }
}
